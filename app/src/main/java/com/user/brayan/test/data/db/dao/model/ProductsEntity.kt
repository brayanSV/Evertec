package com.user.brayan.test.data.db.dao.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductsEntity (
    @ColumnInfo(name = "product_id")
    @PrimaryKey(autoGenerate = true)
    var productId: Long = 0,
    var title: String,
    var price: Double,
    var photo: String
)