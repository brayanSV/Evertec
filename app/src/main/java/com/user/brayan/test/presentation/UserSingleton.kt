package com.user.brayan.test.presentation

import android.content.Context
import com.user.brayan.test.data.db.ApplicationDatabase
import com.user.brayan.test.data.db.dao.model.UserEntity

class UserSingleton {
    fun onlineUser(context: Context): UserEntity {
        return ApplicationDatabase.getAppDataBase(context)?.getUserDao()?.userIsOnline() as UserEntity
    }

    companion object {
        private var instance: UserSingleton? = null

        fun getInstance(): UserSingleton {
            if (instance == null) {
                instance = UserSingleton()
            }

            return  instance as UserSingleton
        }
    }
}