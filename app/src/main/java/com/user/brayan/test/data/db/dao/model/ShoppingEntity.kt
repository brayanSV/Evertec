package com.user.brayan.test.data.db.dao.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping")
data class ShoppingEntity (
    @PrimaryKey(autoGenerate = true)
    var shoppingId: Long = 0,
    var name: String,
    var lastCart: String,
    var transaction: String,
    var dateTransaction: String,
    var accountId: Long
)