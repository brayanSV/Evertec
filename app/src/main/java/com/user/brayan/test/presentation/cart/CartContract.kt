package com.user.brayan.test.presentation.cart


interface CartContract {
    interface View {
        fun showProductsCart()
        fun hideProductsCart()
        fun veryfiEmptyProducts(): Boolean
        fun loadProductsCart()
        fun navigateToAddCard()
        fun showError(msgError: String)
    }

    interface Presenter {
        fun attachView(view: View)
        fun dettachView()
        fun isViewAttached(): Boolean
        fun loadProducts()
    }
}