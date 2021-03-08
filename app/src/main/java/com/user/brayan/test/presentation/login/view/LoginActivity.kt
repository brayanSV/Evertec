package com.user.brayan.test.presentation.login.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.room.Database
import com.user.brayan.test.R
import com.user.brayan.test.base.BaseActivity
import com.user.brayan.test.data.db.ApplicationDatabase
import com.user.brayan.test.data.db.dao.model.UserEntity
import com.user.brayan.test.domain.interactor.login.SingInInteractorImp
import com.user.brayan.test.presentation.UserSingleton
import com.user.brayan.test.presentation.login.LoginContract
import com.user.brayan.test.presentation.login.presenter.LoginPresenter
import com.user.brayan.test.presentation.main.view.MainActivity
import com.user.brayan.test.presentation.signup.view.SingUpActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : BaseActivity(), LoginContract.View {
    lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = LoginPresenter(SingInInteractorImp())
        presenter.attachView(this)

        btnSingIn.setOnClickListener {
            signIn()
        }

        tvSingUp.setOnClickListener {
            navigateToRegistrer()
        }
    }

    override fun onResume() {
        super.onResume()

        if (verifyUserIsOnline()) {
            navigateToMain()
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_login
    }

    override fun getToolbar(): Int {
        return 0
    }

    override fun showError(msgError: String) {
        showToast(this, msgError)
    }

    override fun showProgressBar() {
        progressBarSingIn.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        progressBarSingIn.visibility = View.GONE
    }

    override fun signIn() {
        val email: String = etEmail.text.toString().trim()
        val password: String = etPassword.text.toString().trim()

        if (presenter.checkEmptyFields(email, password)) {
            showToast(this, "Uno o mas campos están vacios")
        } else {
            presenter.singInUser(email, password)
        }
    }

    override fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun verifyUserExist(userId: String): Long {
        val user = ApplicationDatabase.getAppDataBase(this)?.getUserDao()?.findByUser(userId)

        if (user?.isEmpty() == false) {
           return user[0].accountId
        }

        return 0
    }

    override fun verifyUserIsOnline(): Boolean {
        return ApplicationDatabase.getAppDataBase(this)?.getUserDao()?.userIsOnline() != null
    }

    override fun saveUserDataBase(userEntity: UserEntity) {
        ApplicationDatabase.getAppDataBase(this)?.getUserDao()?.saveUser(userEntity)
    }

    override fun updateUserOnline(isOnline: Boolean, accountId: Long) {
        ApplicationDatabase.getAppDataBase(this)?.getUserDao()?.updateOnlineUser(isOnline, accountId)
    }

    override fun navigateToRegistrer() {
        val intent = Intent(this, SingUpActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.dettachView()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dettachView()
    }
}