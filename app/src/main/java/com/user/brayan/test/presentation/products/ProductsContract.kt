package com.user.brayan.test.presentation.products

import com.user.brayan.test.presentation.products.model.ProductsModel

interface ProductsContract {
    interface View {
        fun loadProducts(productsList: List<ProductsModel>)
        fun showError(msgError: String)
    }

    interface Presenter {
        fun attachView(view: View)
        fun dettachView()
        fun isViewAttached(): Boolean
        fun loadProducts()
    }
}