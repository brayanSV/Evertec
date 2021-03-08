package com.user.brayan.test.presentation.products

import com.user.brayan.test.data.db.dao.model.ProductsEntity

interface ProductsContract {
    interface View {
        fun loadProducts()
        fun saveProducts(products: List<ProductsEntity>)
        fun veryfiEmptyProducts(): Boolean
        fun showError(msgError: String)
    }

    interface Presenter {
        fun attachView(view: View)
        fun dettachView()
        fun isViewAttached(): Boolean
        fun loadProducts()
    }
}