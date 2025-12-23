package com.example.groceryapp

object Cart {
    private val items = ArrayList<Product>()

    fun addItem(product: Product) {
        // If product exists, increase quantity
        val existing = items.find { it.name == product.name }
        if (existing != null) {
            existing.quantity += 1
        } else {
            items.add(product.copy()) // add a copy to avoid reference issues
        }
    }

    fun removeItem(product: Product) {
        items.remove(product)
    }

    fun getItems(): List<Product> = items

    fun clear() {
        items.clear()
    }

    fun getTotal(): Int = items.sumOf { it.price * it.quantity }
}