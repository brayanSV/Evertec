package com.user.brayan.test.presentation.login

import com.user.brayan.test.data.db.dao.model.UserEntity

interface LoginContract {
    interface View {
        fun showError(msgError: String)
        fun showProgressBar()
        fun hideProgressBar()
        fun navigateToMain()
        fun navigateToRegistrer()
        fun verifyUserExist(userId: String): Long
        fun verifyUserIsOnline(): Boolean
        fun saveUserDataBase(userEntity: UserEntity)
        fun updateUserOnline(isOnline: Boolean, accountId: Long)
        fun signIn()
    }

    interface Presenter {
        fun attachView(view: View)
        fun dettachView()
        fun isViewAttached(): Boolean
        fun singInUser(email: String, password: String)
        fun checkEmptyFields(email: String, password: String): Boolean
    }
}