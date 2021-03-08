package com.user.brayan.test.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.user.brayan.test.data.db.dao.model.ShoppingEntity

@Dao
interface ShoppingDao {
    @Query("SELECT * FROM shopping")
    fun getAll(): List<ShoppingEntity>

    @Query("SELECT * FROM shopping where accountId = :accountId")
    fun findByUser(accountId: Long): List<ShoppingEntity>

    @Insert
    fun saveProducts(products: ShoppingEntity)
}