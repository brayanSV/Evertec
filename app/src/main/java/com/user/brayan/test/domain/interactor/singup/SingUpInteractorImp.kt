package com.user.brayan.test.domain.interactor.singup

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.user.brayan.test.data.db.dao.model.UserEntity
import com.user.brayan.test.presentation.signup.model.UserSingUp

class SingUpInteractorImp: SingUpInteractor {
    override fun singUp(userSingUp: UserSingUp, listener: SingUpInteractor.SingUpCallback) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(userSingUp.email, userSingUp.password).addOnCompleteListener { itSingUp ->
            if (itSingUp.isSuccessful) {
                val profileUpdate = UserProfileChangeRequest.Builder().setDisplayName(userSingUp.fullName).build()

                FirebaseAuth.getInstance().currentUser?.updateProfile(profileUpdate)?.addOnCompleteListener {
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
            } else {
                listener.onFailure(itSingUp.exception?.message.toString())
            }
        }
    }
}