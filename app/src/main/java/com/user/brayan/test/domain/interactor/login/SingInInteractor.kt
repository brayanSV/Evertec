package com.user.brayan.test.domain.interactor.login

import com.user.brayan.test.data.db.dao.model.UserEntity

interface SingInInteractor {
    interface LoginCallback {
        fun onSuccess(userEntity: UserEntity)
        fun onFailure(errorMsg:String)
    }

    fun singInUser(email: String, password: String, listener: LoginCallback)
}
