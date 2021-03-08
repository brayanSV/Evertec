package com.user.brayan.test.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.user.brayan.test.data.db.dao.model.ProductsShoppingEntity

@Dao
interface ProductsShoppingDao {
    @Query("SELECT * FROM products_shopping")
    fun getAll(): List<ProductsShoppingEntity>

    @Query("SELECT * FROM products_shopping where shoppingId = :shoppingId")
    fun findByShopping(shoppingId: Long): List<ProductsShoppingEntity>

    @Insert
    fun saveProducts(products: ProductsShoppingEntity)
}