package com.sahil.groceryapp.ui1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.Cart
import com.sahil.groceryapp.R

class CartActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var tvTotal: TextView
    private lateinit var btnClear: Button
    private lateinit var adapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        recyclerView = findViewById(R.id.recyclerViewCart)
        tvTotal = findViewById(R.id.tvTotalPrice)
        btnClear = findViewById(R.id.btnClearCart)

        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CartAdapter(Cart.getItems())
        { updateTotal() }
        recyclerView.adapter = adapter

        updateTotal()

        btnClear.setOnClickListener {
            Cart.clear()
            adapter.notifyDataSetChanged()
            updateTotal()
        }
    }

    private fun updateTotal() {
        val total = Cart.getItems().sumOf { it.price }
        tvTotal.text = "Total: ₹$total"
    }
}