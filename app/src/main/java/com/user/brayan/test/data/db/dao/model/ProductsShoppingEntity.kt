package com.user.brayan.test.data.db.dao.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(tableName = "products_shopping")
data class ProductsShoppingEntity (
    @ColumnInfo(name = "product_id")
    @PrimaryKey(autoGenerate = true)
    var productId: Long = 0,
    var product: String,
    var price: Double,
    var cant: Int,
    var shoppingId: Long = 0,
)
