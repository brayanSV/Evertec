package com.user.brayan.test.domain.interactor.cart

import com.user.brayan.test.presentation.cart.model.CartModel

interface ProductsCartInteractor {
    interface ProductsCartCallback {
        fun onProductsSuccess(productsList: List<CartModel>)
        fun onProductsFailure(msgError: String)
    }

    fun consultProducts(listener: ProductsCartCallback)
}