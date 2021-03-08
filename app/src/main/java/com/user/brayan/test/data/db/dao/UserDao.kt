package com.user.brayan.test.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.user.brayan.test.data.db.dao.model.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM account")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM account WHERE user_id = :userId")
    fun findByUser(userId: String): List<UserEntity>

    @Query("SELECT * FROM account WHERE user_is_online = 1")
    fun userIsOnline(): UserEntity

    @Insert
    fun saveUser(userEntity: UserEntity)

    @Query("UPDATE account SET user_is_online = :isOnline WHERE account_id = :accountId")
    fun updateOnlineUser(isOnline: Boolean, accountId: Long)
}