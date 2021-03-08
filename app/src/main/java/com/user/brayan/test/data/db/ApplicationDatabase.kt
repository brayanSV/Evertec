package com.user.brayan.test.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.user.brayan.test.data.db.dao.*
import com.user.brayan.test.data.db.dao.model.*

@Database(
    entities = [
        CartEntity::class,
        ProductsEntity::class,
        ProductsShoppingEntity::class,
        ShoppingEntity::class,
        UserEntity::class
    ],
    version = 1)
abstract class ApplicationDatabase: RoomDatabase() {
    abstract fun getUserDao(): UserDao
    abstract fun getProductsDao(): ProductsDao
    abstract fun getShoppingDao(): ShoppingDao
    abstract fun getProductsShoppingDao(): ProductsShoppingDao
    abstract fun getCartDao(): CartDao

    companion object {
        private var INSTANCE: ApplicationDatabase? = null

        fun getAppDataBase(context: Context): ApplicationDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ApplicationDatabase::class.java,
                    "evertec"
                ).allowMainThreadQueries().build()
            }

            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}