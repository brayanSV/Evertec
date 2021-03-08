package com.user.brayan.test.data.db.dao.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class CartEntity (
    @PrimaryKey(autoGenerate = true)
    var cartId: Long = 0,
    var productId: Long,
    var cant: Int,
    var accountId: Long
)
