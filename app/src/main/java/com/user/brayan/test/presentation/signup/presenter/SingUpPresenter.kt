package com.user.brayan.test.presentation.signup.presenter

import androidx.core.util.PatternsCompat
import com.user.brayan.test.domain.interactor.singup.SingUpInteractor
import com.user.brayan.test.presentation.signup.SingUpContract
import com.user.brayan.test.presentation.signup.exceptions.FirebaseSingUpException
import com.user.brayan.test.presentation.signup.model.UserSingUp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class SingUpPresenter(singUpInteractor: SingUpInteractor): SingUpContract.Presenter, CoroutineScope {
    var view: SingUpContract.View? = null
    var singUpInteractor: SingUpInteractor? = null

    //corutinas
    private val job = Job()
    override val coroutineContext: CoroutineContext
    get() = Dispatchers.Main + job

    init {
        this.singUpInteractor = singUpInteractor
    }

    override fun attachView(view: SingUpContract.View) {
        this.view = view;
    }

    override fun dettachView() {
        this.view = null
    }

    override fun isViewAttached(): Boolean {
        return this.view != null
    }

    override fun checkEmptyName(fullName: String): Boolean {
        return fullName.isEmpty()
    }

    override fun checkValidEmail(email: String): Boolean {
        return PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
    }

    override fun checkEmptyPasswordsMatch(pw1: String, pw2: String): Boolean {
        if (pw1.isEmpty() or pw2.isEmpty()) {
            return false
        }

        return pw1 == pw2
    }

    override fun singUp(userSingUp: UserSingUp) {
        launch {
            view?.showProgressBar()

            try {
                singUpInteractor?.singUp(userSingUp)

                if (isViewAttached()) {
                    view?.navigateToMain()
                    view?.hideProgressBar()
                }
            } catch (e: FirebaseSingUpException) {
                if (isViewAttached()) {
                    view?.showError(e.message.toString())
                    view?.hideProgressBar()
                }
            }
        }
    }
}