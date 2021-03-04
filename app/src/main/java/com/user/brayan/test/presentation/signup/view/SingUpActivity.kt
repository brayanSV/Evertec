package com.user.brayan.test.presentation.signup.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.user.brayan.test.R
import com.user.brayan.test.base.BaseActivity
import com.user.brayan.test.domain.interactor.singup.SingUpInteractorImp
import com.user.brayan.test.presentation.login.view.LoginActivity
import com.user.brayan.test.presentation.main.view.MainActivity
import com.user.brayan.test.presentation.signup.SingUpContract
import com.user.brayan.test.presentation.signup.model.UserSingUp
import com.user.brayan.test.presentation.signup.presenter.SingUpPresenter
import kotlinx.android.synthetic.main.activity_sing_up.*
import kotlinx.android.synthetic.main.activity_sing_up.etEmail

class SingUpActivity : BaseActivity(), SingUpContract.View {
    lateinit var presenter: SingUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = SingUpPresenter(SingUpInteractorImp())
        presenter.attachView(this)

        btnSingUp.setOnClickListener {
            singUp()
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_sing_up
    }

    override fun singUp() {
        val fullName: String = etFullName.text.toString().trim()
        val email: String = etEmail.text.toString().trim()
        val password1: String = etPassword1.text.toString().trim()
        val password2: String = etPassword2.text.toString().trim()

        if (presenter.checkEmptyName(fullName)) {
            etFullName.error = "El nombre esta vacio"
            return
        }

        if (!presenter.checkValidEmail(email)) {
            etEmail.error = "Email incorrecto"
            return
        }

        if (!presenter.checkEmptyPasswordsMatch(password1, password2)) {
            etPassword1.error = "Las contraseñas no coinciden"
            etPassword2.error = "Las contraseñas no coinciden"
            return
        }

        presenter.singUp(UserSingUp(fullName, email, password1))
    }

    override fun navigateToMain() {
        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun navigateToLogin() {
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun showProgressBar() {
        progressBarSingUp.visibility = View.VISIBLE
        btnSingUp.visibility = View.GONE
    }

    override fun hideProgressBar() {
        progressBarSingUp.visibility = View.GONE
        btnSingUp.visibility = View.VISIBLE
    }

    override fun showError(msgError: String) {
        showToast(this, msgError)
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