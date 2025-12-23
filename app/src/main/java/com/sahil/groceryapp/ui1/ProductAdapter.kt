package com.example.groceryapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sahil.groceryapp.R

class ProductAdapter(
    private val products: List<Product>,
    private val onAddToCartClick: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvProductName)
        val price: TextView = itemView.findViewById(R.id.tvProductPrice)
        val image: ImageView = itemView.findViewById(R.id.ivProduct)
        val btnAdd: Button = itemView.findViewById(R.id.btnAddToCart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.name.text = product.name
        holder.price.text = "₹${product.price}"
        holder.image.setImageResource(product.image)
        holder.btnAdd.setOnClickListener { onAddToCartClick(product) }
    }

    override fun getItemCount(): Int = products.size
}