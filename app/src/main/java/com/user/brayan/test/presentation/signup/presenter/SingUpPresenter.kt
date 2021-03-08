package com.user.brayan.test.presentation.signup.presenter

import androidx.core.util.PatternsCompat
import com.user.brayan.test.data.db.dao.model.UserEntity
import com.user.brayan.test.domain.interactor.singup.SingUpInteractor
import com.user.brayan.test.presentation.signup.SingUpContract
import com.user.brayan.test.presentation.signup.model.UserSingUp

class SingUpPresenter(singUpInteractor: SingUpInteractor): SingUpContract.Presenter {
    var view: SingUpContract.View? = null
    var singUpInteractor: SingUpInteractor? = null

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
        view?.showProgressBar()

        singUpInteractor?.singUp(userSingUp, object: SingUpInteractor.SingUpCallback {
            override fun onSuccess(userEntity: UserEntity) {
                if (isViewAttached()) {
                    view?.saveUserDataBase(userEntity)

                    view?.navigateToMain()
                    view?.hideProgressBar()
                }
            }

            override fun onFailure(errorMsg: String) {
                if (isViewAttached()) {
                    view?.showError(errorMsg)
                    view?.hideProgressBar()
                }
            }
        })
    }
}