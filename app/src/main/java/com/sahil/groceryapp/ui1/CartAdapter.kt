
package com.sahil.groceryapp.ui1
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.Cart
import com.example.groceryapp.Product
import com.sahil.groceryapp.R

class CartAdapter(
    private val items: List<Product>,
    private val onUpdate: () -> Unit // callback for total update
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvCartProductName)
        val price: TextView = itemView.findViewById(R.id.tvCartProductPrice)
        val image: ImageView = itemView.findViewById(R.id.ivCartProduct)
        val btnIncrease: Button = itemView.findViewById(R.id.btnIncrease)
        val btnDecrease: Button = itemView.findViewById(R.id.btnDecrease)
        val btnRemove: Button = itemView.findViewById(R.id.btnRemove)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        val product = items[position]
        holder.name.text = product.name
        holder.price.text = "₹${product.price * product.quantity}"
        holder.image.setImageResource(product.image)

        holder.btnIncrease.setOnClickListener {
            product.quantity += 1
            notifyItemChanged(position)
            onUpdate()
        }

        holder.btnDecrease.setOnClickListener {
            if (product.quantity > 1) {
                product.quantity -= 1
                notifyItemChanged(position)
                onUpdate()
            }
        }

        holder.btnRemove.setOnClickListener {
            Cart.removeItem(product)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, items.size)
            onUpdate()
        }
    }

    override fun getItemCount(): Int = items.size
}