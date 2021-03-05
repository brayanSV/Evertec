package com.user.brayan.test.domain.interactor.products

import com.user.brayan.test.presentation.products.model.ProductsModel

interface ProductsInteractor {
    interface ProductsCallback {
        fun onProductsSuccess(productsList: List<ProductsModel>)
        fun onProductsFailure(msgError: String)
    }

    fun consultProducts(listener: ProductsCallback)
}