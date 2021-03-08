package com.user.brayan.test.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.user.brayan.test.data.db.dao.model.ProductsEntity
import com.user.brayan.test.presentation.products.model.ProductsViewModel

@Dao
interface ProductsDao {
    @Query("SELECT products.product_id, products.title, products.photo, products.price, NULLIF(cart.cant,0) as cant FROM products LEFT JOIN cart on cart.productId = products.product_id and cart.accountId = :accountId")
    fun getAll(accountId: Long): List<ProductsViewModel>

    @Query("SELECT * FROM products where product_id = :product_id")
    fun findByProduct(product_id: Long): List<ProductsEntity>

    @Insert
    fun saveProducts(products: List<ProductsEntity>)
}