package com.user.brayan.test.domain.interactor.cart

import com.user.brayan.test.presentation.cart.model.CartModel

class ProductsCartInteractorImp: ProductsCartInteractor {
    override fun consultProducts(listener: ProductsCartInteractor.ProductsCartCallback) {
        val productsCart = ArrayList<CartModel>()

        productsCart.add(
            CartModel (
                1,
                "Vino sauvignon pionero  morande x 750ml",
                31710.0,
                1
            )
        )

        productsCart.add(
            CartModel (
                2,
                "Nesquik vainilla bolsa x 200 gr",
                3336.0,
                3
            )
        )

        productsCart.add(
            CartModel (
                3,
                "Alim lacteo ferm vainilla yox 800 gr",
                10520.0,
                5
            )
        )

        listener.onProductsSuccess(productsCart)
    }
}