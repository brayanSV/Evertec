package com.user.brayan.test.presentation.cart.model

data class CartViewModel(
    var cartId: Long,
    var title: String,
    var price: Double,
    var cant: Int,
    var productId: Long
)
