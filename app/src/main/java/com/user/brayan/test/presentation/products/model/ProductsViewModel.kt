package com.user.brayan.test.presentation.products.model

data class ProductsViewModel(
    var product_id: Long,
    var title: String,
    var photo: String,
    var price: Double,
    var cant: Int
)
