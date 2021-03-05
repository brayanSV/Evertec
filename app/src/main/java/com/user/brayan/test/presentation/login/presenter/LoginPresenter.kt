package com.user.brayan.test.presentation.login.presenter

import com.user.brayan.test.domain.interactor.login.SingInInteractor
import com.user.brayan.test.presentation.login.exceptions.FirebaseLoginException
import com.user.brayan.test.presentation.login.LoginContract
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class LoginPresenter(singInInteractor: SingInInteractor): LoginContract.Presenter, CoroutineScope {
    var view: LoginContract.View? =  null
    var singInInteractor: SingInInteractor? = null

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    init {
        this.singInInteractor = singInInteractor
    }

    override fun attachView(view: LoginContract.View) {
        this.view = view
    }

    override fun dettachView() {
        this.view = null
    }

    override fun dettachJob() {
        coroutineContext.cancel()
    }

    override fun isViewAttached(): Boolean {
        return this.view != null
    }

    override fun singInUser(email: String, password: String) {
        launch {
            view?.showProgressBar()

            try {
                singInInteractor?.singInUser(email, password)

                if (isViewAttached()) {
                    view?.hideProgressBar()
                    view?.navigateToMain()
                }
            } catch (e: FirebaseLoginException) {
                if (isViewAttached()) {
                    view?.showError(e.message.toString())
                    view?.hideProgressBar()
                }
            }
        }
    }

    override fun checkEmptyFields(email: String, password: String): Boolean {
        return email.isEmpty() || password.isEmpty()
    }

}