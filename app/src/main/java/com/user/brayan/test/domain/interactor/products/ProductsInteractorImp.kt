package com.user.brayan.test.domain.interactor.products

import com.user.brayan.test.presentation.products.model.ProductsModel
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class ProductsInteractorImp: ProductsInteractor {
    override fun consultProducts(listener: ProductsInteractor.ProductsCallback) {
        val products = ArrayList<ProductsModel>()

        products.add(
            ProductsModel (
                1,
                "https://exitocol.vtexassets.com/arquivos/ids/1706556-500-auto?width=500&height=auto&aspect=true",
                "Vino sauvignon pionero  morande x 750ml",
                31710.0
            )
        )

        products.add(
            ProductsModel (
                2,
                "https://exitocol.vtexassets.com/arquivos/ids/1720940-500-auto?width=500&height=auto&aspect=true",
                "Nesquik vainilla bolsa x 200 gr",
                3336.0
            )
        )

        products.add(
            ProductsModel (
                3,
                "https://exitocol.vtexassets.com/arquivos/ids/6717833-500-auto?width=500&height=auto&aspect=true",
                "Alim lacteo ferm vainilla yox 800 gr",
                10520.0
            )
        )

        products.add(
            ProductsModel (
                4,
                "https://exitocol.vtexassets.com/arquivos/ids/4690157-500-auto?width=500&height=auto&aspect=true",
                "Huevo rojo a x 30 insuperable smn 30 unidad",
                6672.0
            )
        )

        products.add(
            ProductsModel (
                5,
                "https://exitocol.vtexassets.com/arquivos/ids/5777769-500-auto?width=500&height=auto&aspect=true",
                "Gaseosa duo gratis gaseosa 1.5 coca cola 6000 ml",
                7824.0
            )
        )

        products.add(
            ProductsModel (
                6,
                "https://exitocol.vtexassets.com/arquivos/ids/6259479-500-auto?width=500&height=auto&aspect=true",
                "Papel higiénico jardín de primavera x 15 rollos familia 391 mts",
                11990.0
            )
        )

        products.add(
            ProductsModel (
                7,
                "https://exitocol.vtexassets.com/arquivos/ids/5564249-500-auto?width=500&height=auto&aspect=true",
                "Arroz vitamor 3k diana 3000g",
                8940.0
            )
        )

        products.add(
            ProductsModel (
                8,
                "https://exitocol.vtexassets.com/arquivos/ids/1975788-500-auto?width=500&height=auto&aspect=true",
                "Queso mozzarella tajado x 1000 gr",
                14210.0
            )
        )

        products.add(
            ProductsModel (
                9,
                "https://exitocol.vtexassets.com/arquivos/ids/5788799-500-auto?width=500&height=auto&aspect=true",
                "Costilla de res",
                3592.0
            )
        )

        products.add(
            ProductsModel (
                10,
                "https://exitocol.vtexassets.com/arquivos/ids/2666912-500-auto?width=500&height=auto&aspect=true",
                "Jamon de cerdo sin conserv pietran 431 gramo",
                10160.0
            )
        )

        listener.onProductsSuccess(products)
    }
}