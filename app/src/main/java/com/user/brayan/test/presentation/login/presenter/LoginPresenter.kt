package com.user.brayan.test.presentation.login.presenter

import android.util.Log
import com.user.brayan.test.data.db.dao.model.UserEntity
import com.user.brayan.test.domain.interactor.login.SingInInteractor
import com.user.brayan.test.presentation.login.LoginContract

class LoginPresenter(singInInteractor: SingInInteractor): LoginContract.Presenter {
    var view: LoginContract.View? =  null
    var singInInteractor: SingInInteractor? = null

    init {
        this.singInInteractor = singInInteractor
    }

    override fun attachView(view: LoginContract.View) {
        this.view = view
    }

    override fun dettachView() {
        this.view = null
    }

    override fun isViewAttached(): Boolean {
        return this.view != null
    }

    override fun singInUser(email: String, password: String) {
        view?.showProgressBar()

        singInInteractor?.singInUser(email, password, object : SingInInteractor.LoginCallback{
            override fun onSuccess(userEntity: UserEntity) {
                if (isViewAttached()) {
                    val accountId: Long? = view?.verifyUserExist(userEntity.userId)

                    if (accountId == 0L) {
                        view?.saveUserDataBase(userEntity)
                    } else {
                        view?.updateUserOnline(true, accountId!!)
                    }

                    view?.hideProgressBar()
                    view?.navigateToMain()
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

    override fun checkEmptyFields(email: String, password: String): Boolean {
        return email.isEmpty() || password.isEmpty()
    }
}