package com.user.brayan.test.domain.interactor.cart

interface ProductsCartInteractor {
    interface ProductsCartCallback {
        fun onProductsSuccess()
        fun onProductsFailure(msgError: String)
    }

    fun consultProducts(listener: ProductsCartCallback)
}