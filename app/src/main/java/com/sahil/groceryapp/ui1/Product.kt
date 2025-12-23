package com.example.groceryapp

data class Product(
    val name: String,
    val price: Int,
    val image: Int,
    var quantity: Int = 1
)