package com.sahil.groceryapp.ui.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sahil.groceryapp.R
import com.sahil.groceryapp.adapter.CategoryAdapter
import com.sahil.groceryapp.model.Category

class CategoriesActivity : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_categories)


        rvCategories = findViewById(R.id.rvCategories)

                val categoryList = listOf(
            Category("Fruits", R.drawable.ic_fruits),
            Category("Vegetables", R.drawable.ic_vegetables),
            Category("Dairy", R.drawable.ic_dairy),
            Category("Snacks", R.drawable.ic_snacks),
            Category("Bakery", R.drawable.ic_bakery),
            Category("Beverages", R.drawable.ic_beverages)
        )


        rvCategories.layoutManager = LinearLayoutManager(this)


        val adapter = CategoryAdapter(categoryList) { category ->
            Toast.makeText(this, "Clicked: ${category.name}", Toast.LENGTH_SHORT).show()


        }

        rvCategories.adapter = adapter
    }
}