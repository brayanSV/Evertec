package com.user.brayan.test.presentation.signup

import com.user.brayan.test.presentation.signup.model.UserSingUp

interface SingUpContract {
    interface View {
        fun singUp()
        fun navigateToMain()
        fun navigateToLogin()
        fun showProgressBar()
        fun hideProgressBar()
        fun showError(msgError: String)
    }

    interface Presenter {
        fun attachView(view: View)
        fun dettachView()
        fun isViewAttached(): Boolean
        fun checkEmptyName(fullName: String): Boolean
        fun checkValidEmail(email: String): Boolean
        fun checkEmptyPasswordsMatch(pw1: String, pw2: String): Boolean
        fun singUp(userSingUp: UserSingUp)
    }
}