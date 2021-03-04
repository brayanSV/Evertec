package com.user.brayan.test.presentation.login

interface LoginContract {
    interface View { //Todas las acciones que tiene la vista
        fun showError(msgError: String)
        fun showProgressBar()
        fun hideProgressBar()
        fun signIn()
        fun navigateToMain()
        fun navigateToRegistrer()
    }

    interface Presenter {
        fun attachView(view: View)
        fun dettachView()
        fun dettachJob()
        fun isViewAttached(): Boolean
        fun singInUser(email: String, password: String)
        fun checkEmptyFields(email: String, password: String): Boolean
    }
}