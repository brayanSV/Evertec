package com.user.brayan.test.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.user.brayan.test.data.db.dao.model.CartEntity
import com.user.brayan.test.presentation.cart.model.CartViewModel

@Dao
interface CartDao {
    @Query("SELECT cart.cartId, products.title, products.price, cart.cant, cart.productId FROM cart INNER JOIN products on products.product_id = cart.productId where accountId = :accountId")
    fun getAll(accountId: Long): MutableList<CartViewModel>

    @Query("SELECT cart.cartId, products.title, products.price, cart.cant, cart.productId FROM cart INNER JOIN products on products.product_id = cart.productId where productId = :product_id and accountId = :accountId")
    fun findByProduct(product_id: Long, accountId: Long): CartViewModel

    @Insert
    fun saveProducts(products: CartEntity)

    @Query("UPDATE cart SET cant = :cant WHERE productId = :productId and accountId = :accountId")
    fun updateCantProduct(cant: Int, productId: Long, accountId: Long)

    @Delete
    fun deleteAll(products: CartEntity)

    @Query("DELETE FROM cart WHERE productId = :productId and accountId = :accountId")
    fun deletefindByProduct(productId: Long, accountId: Long)

    @Query("DELETE FROM cart WHERE cartId = :cartId")
    fun deletefindByProduct(cartId: Long)
}