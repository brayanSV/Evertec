package com.user.brayan.test.domain.interactor.singup

import com.user.brayan.test.data.db.dao.model.UserEntity
import com.user.brayan.test.presentation.signup.model.UserSingUp

interface SingUpInteractor {
    interface SingUpCallback {
        fun onSuccess(userEntity: UserEntity)
        fun onFailure(errorMsg:String)
    }

    fun singUp(userSingUp: UserSingUp, listener: SingUpCallback)
}