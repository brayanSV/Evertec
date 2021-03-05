package com.user.brayan.test.presentation.login.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import com.user.brayan.test.R
import com.user.brayan.test.base.BaseActivity
import com.user.brayan.test.domain.interactor.login.SingInInteractorImp
import com.user.brayan.test.presentation.login.LoginContract
import com.user.brayan.test.presentation.login.presenter.LoginPresenter
import com.user.brayan.test.presentation.main.view.MainActivity
import com.user.brayan.test.presentation.signup.view.SingUpActivity
import kotlinx.android.synthetic.main.activity_login.*
import java.math.BigInteger
import java.security.MessageDigest
import java.security.SecureRandom
import java.text.SimpleDateFormat
import java.util.*


class LoginActivity : BaseActivity(),
    LoginContract.View {

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

    @SuppressLint("NewApi")
    override fun onResume() {
        super.onResume()

        val tranKey = "024h1IlD"
        val nonce = BigInteger(130, SecureRandom()).toString()
        val seed = SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ", Locale.getDefault()).format(Date())
        val tranKey2 = base64(SHA_256(nonce + seed + tranKey))

        Log.e("datos", "nonce: ${base64(nonce.toByteArray())} , seed: $seed, tranKey: $tranKey2");
    }


    fun SHA_256(input: String): ByteArray? {
        val mDigest: MessageDigest = MessageDigest.getInstance("SHA-256")
        return mDigest.digest(input.toByteArray())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun base64(input: ByteArray?): String? {
        val encodedBytes = Base64.getEncoder().encode(input)
        return String(encodedBytes)
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

    override fun navigateToRegistrer() {
        val intent = Intent(this, SingUpActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        presenter.dettachView()
        presenter.dettachJob()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dettachView()
        presenter.dettachJob()
    }
}