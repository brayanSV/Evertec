package com.user.brayan.test.presentation.cart.presenter

import android.util.Log
import com.user.brayan.test.domain.interactor.cart.ProductsCartInteractor
import com.user.brayan.test.presentation.cart.CartContract

class CartPresenter(cartInteractor: ProductsCartInteractor): CartContract.Presenter {
    var view: CartContract.View? = null
    var cartInteractor: ProductsCartInteractor? = null

    init {
        this. cartInteractor = cartInteractor
    }

    override fun attachView(view: CartContract.View) {
        this.view = view
    }

    override fun dettachView() {
        this.view = null
    }

    override fun isViewAttached(): Boolean {
        return this.view != null
    }

    override fun loadProducts() {
        if (isViewAttached()) {
            if (!view?.veryfiEmptyProducts()!!) {
                view?.showProductsCart()
                view?.loadProductsCart()
            } else {
                view?.hideProductsCart()
            }
        }
    }

}