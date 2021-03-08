package com.user.brayan.test.domain.interactor.login

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.user.brayan.test.data.db.dao.model.UserEntity

class SingInInteractorImp: SingInInteractor {
    override fun singInUser(email: String, password: String, listener: SingInInteractor.LoginCallback) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                val user = Firebase.auth.currentUser

                listener.onSuccess(
                    UserEntity(
                        userId = user?.uid!!,
                        name = user?.displayName!!,
                        email = user?.email!!,
                        isOnline = 1
                    )
                )
            } else {
                listener.onFailure(it.exception?.message.toString())
            }
        }
    }
}