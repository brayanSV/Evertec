package com.user.brayan.test.data.db.dao.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account")
data class UserEntity(
    @ColumnInfo(name = "account_id")
    @PrimaryKey(autoGenerate = true)
    var accountId: Long = 0,
    @ColumnInfo(name = "user_id")
    var userId: String,
    @ColumnInfo(name = "user_name")
    var name: String,
    @ColumnInfo(name = "user_email")
    var email: String,
    @ColumnInfo(name = "user_is_online")
    var isOnline: Int
)