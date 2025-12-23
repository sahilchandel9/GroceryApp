package com.example.groceryapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.sahil.groceryapp.R
import com.sahil.groceryapp.ui1.CartActivity

class ProductActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var productList: ArrayList<Product>
    private lateinit var adapter: ProductAdapter
    private lateinit var tvCategory: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        tvCategory = findViewById(R.id.tvCategoryTitle)
        recyclerView = findViewById(R.id.recyclerViewProduct)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val btnViewCart: Button = findViewById(R.id.btnViewCart)
        btnViewCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        val categoryName = intent.getStringExtra("categoryName")
        tvCategory.text = categoryName

        productList = ArrayList()
        loadProducts(categoryName)

        adapter = ProductAdapter(productList) { product ->
            Cart.addItem(product)
        }

        recyclerView.adapter = adapter
    }

    private fun loadProducts(category: String?) {
        when (category) {
            "Fruits" -> {
                productList.add(Product("Apple", 50, R.drawable.apple))
                productList.add(Product("Banana", 20, R.drawable.banana))
            }
            "Vegetables" -> {
                productList.add(Product("Tomato", 30, R.drawable.tomato))
                productList.add(Product("Carrot", 40, R.drawable.carrot))
            }
            "Dairy" -> {
                productList.add(Product("Milk", 60, R.drawable.milk))
                productList.add(Product("Cheese", 120, R.drawable.cheese))
            }
            "Snacks" -> {
                productList.add(Product("Chips", 30, R.drawable.chips))
                productList.add(Product("Chocolate", 50, R.drawable.chocolate))
            }
        }
    }
}