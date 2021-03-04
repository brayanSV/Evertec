package com.user.brayan.test.domain.interactor.singup

import com.user.brayan.test.presentation.signup.model.UserSingUp

interface SingUpInteractor {
    suspend fun singUp(userSingUp: UserSingUp)
}