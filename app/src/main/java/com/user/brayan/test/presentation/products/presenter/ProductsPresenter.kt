package com.user.brayan.test.presentation.products.presenter

import android.util.Log
import com.user.brayan.test.data.db.dao.model.ProductsEntity
import com.user.brayan.test.domain.interactor.products.ProductsInteractor
import com.user.brayan.test.presentation.products.ProductsContract

class ProductsPresenter(productsInteractor: ProductsInteractor): ProductsContract.Presenter {
    var view: ProductsContract.View? = null
    var productsInteractor: ProductsInteractor? = null

    init {
        this.productsInteractor = productsInteractor
    }

    override fun attachView(view: ProductsContract.View) {
        this.view = view
    }

    override fun dettachView() {
        this.view = null
    }

    override fun isViewAttached(): Boolean {
        return this.view != null
    }

    override fun loadProducts() {
        this.productsInteractor?.consultProducts(object: ProductsInteractor.ProductsCallback{
            override fun onProductsSuccess(productsList: List<ProductsEntity>) {
                if (isViewAttached()) {
                    if (view?.veryfiEmptyProducts()!!) {
                        view?.saveProducts(productsList)
                    }

                    view?.loadProducts()
                }
            }

            override fun onProductsFailure(msgError: String) {
                if (isViewAttached()) {
                    view?.showError(msgError)
                }
            }
        })
    }

}