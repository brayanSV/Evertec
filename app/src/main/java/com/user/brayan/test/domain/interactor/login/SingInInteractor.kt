package com.user.brayan.test.domain.interactor.login

interface SingInInteractor {
    suspend fun singInUser(email: String, password: String)
}
