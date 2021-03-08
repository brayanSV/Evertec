package com.user.brayan.test.domain.interactor.products

import com.user.brayan.test.data.db.dao.model.ProductsEntity

class ProductsInteractorImp: ProductsInteractor {
    override fun consultProducts(listener: ProductsInteractor.ProductsCallback) {
        val products = ArrayList<ProductsEntity>()

        products.add(
            ProductsEntity (
                1,
                "Vino sauvignon pionero  morande x 750ml",
                31710.0,
                "https://exitocol.vtexassets.com/arquivos/ids/1706556-500-auto?width=500&height=auto&aspect=true"
            )
        )

        products.add(
            ProductsEntity (
                2,
                "Nesquik vainilla bolsa x 200 gr",
                3336.0,
                "https://exitocol.vtexassets.com/arquivos/ids/1720940-500-auto?width=500&height=auto&aspect=true"
            )
        )

        products.add(
            ProductsEntity (
                3,
                "Alim lacteo ferm vainilla yox 800 gr",
                10520.0,
                "https://exitocol.vtexassets.com/arquivos/ids/6717833-500-auto?width=500&height=auto&aspect=true"
            )
        )

        products.add(
            ProductsEntity (
                4,
                "Huevo rojo a x 30 insuperable smn 30 unidad",
                6672.0,
                "https://exitocol.vtexassets.com/arquivos/ids/4690157-500-auto?width=500&height=auto&aspect=true"
            )
        )

        products.add(
            ProductsEntity (
                5,
                "Gaseosa duo gratis gaseosa 1.5 coca cola 6000 ml",
                7824.0,
                "https://exitocol.vtexassets.com/arquivos/ids/5777769-500-auto?width=500&height=auto&aspect=true"
            )
        )

        products.add(
            ProductsEntity (
                6,
                "Papel higiénico jardín de primavera x 15 rollos familia 391 mts",
                11990.0,
                "https://exitocol.vtexassets.com/arquivos/ids/6259479-500-auto?width=500&height=auto&aspect=true"
            )
        )

        products.add(
            ProductsEntity (
                7,
                "Arroz vitamor 3k diana 3000g",
                8940.0,
                "https://exitocol.vtexassets.com/arquivos/ids/5564249-500-auto?width=500&height=auto&aspect=true"
            )
        )

        products.add(
            ProductsEntity (
                8,
                "Queso mozzarella tajado x 1000 gr",
                14210.0,
                "https://exitocol.vtexassets.com/arquivos/ids/1975788-500-auto?width=500&height=auto&aspect=true"
            )
        )

        products.add(
            ProductsEntity (
                9,
                "Costilla de res",
                3592.0,
                "https://exitocol.vtexassets.com/arquivos/ids/5788799-500-auto?width=500&height=auto&aspect=true"
            )
        )

        products.add(
            ProductsEntity (
                10,
                "Jamon de cerdo sin conserv pietran 431 gramo",
                10160.0,
                "https://exitocol.vtexassets.com/arquivos/ids/2666912-500-auto?width=500&height=auto&aspect=true"
            )
        )

        listener.onProductsSuccess(products)
    }
}