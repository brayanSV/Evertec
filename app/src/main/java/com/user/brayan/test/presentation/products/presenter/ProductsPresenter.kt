package com.user.brayan.test.presentation.products.presenter

import android.util.Log
import com.user.brayan.test.domain.interactor.products.ProductsInteractor
import com.user.brayan.test.presentation.login.LoginContract
import com.user.brayan.test.presentation.login.exceptions.FirebaseLoginException
import com.user.brayan.test.presentation.products.ProductsContract
import com.user.brayan.test.presentation.products.model.ProductsModel
import kotlinx.coroutines.*
import java.util.*
import kotlin.coroutines.CoroutineContext

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
            override fun onProductsSuccess(productsList: List<ProductsModel>) {
                view?.loadProducts(productsList)
            }

            override fun onProductsFailure(msgError: String) {
                view?.showError(msgError)
            }
        })
    }

}