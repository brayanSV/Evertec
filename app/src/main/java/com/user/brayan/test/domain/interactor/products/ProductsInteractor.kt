package com.user.brayan.test.domain.interactor.products

import com.user.brayan.test.data.db.dao.model.ProductsEntity

interface ProductsInteractor {
    interface ProductsCallback {
        fun onProductsSuccess(productsList: List<ProductsEntity>)
        fun onProductsFailure(msgError: String)
    }

    fun consultProducts(listener: ProductsCallback)
}