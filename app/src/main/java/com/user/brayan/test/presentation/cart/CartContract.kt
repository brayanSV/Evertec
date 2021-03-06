package com.user.brayan.test.presentation.cart

import com.user.brayan.test.presentation.cart.model.CartModel


interface CartContract {
    interface View {
        fun showProductsCart()
        fun hideProductsCart()
        fun loadProductsCart(productsList: List<CartModel>)
        fun showError(msgError: String)
    }

    interface Presenter {
        fun attachView(view: View)
        fun dettachView()
        fun isViewAttached(): Boolean
        fun loadProducts()
    }
}