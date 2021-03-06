package com.user.brayan.test.presentation.cart.presenter

import com.user.brayan.test.domain.interactor.cart.ProductsCartInteractor
import com.user.brayan.test.presentation.cart.CartContract
import com.user.brayan.test.presentation.cart.model.CartModel

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
        this.cartInteractor?.consultProducts(object: ProductsCartInteractor.ProductsCartCallback{
            override fun onProductsSuccess(productsList: List<CartModel>) {
                if (isViewAttached()) {
                    if (productsList.isNotEmpty()) {
                        view?.showProductsCart()
                        view?.loadProductsCart(productsList)
                    } else {
                        view?.hideProductsCart()
                    }
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