package com.user.brayan.test.domain.interactor.singup

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.user.brayan.test.presentation.signup.exceptions.FirebaseSingUpException
import com.user.brayan.test.presentation.signup.model.UserSingUp
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class SingUpInteractorImp: SingUpInteractor {
    override suspend fun singUp(userSingUp: UserSingUp): Unit = suspendCancellableCoroutine { continuation ->
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(userSingUp.email, userSingUp.password).addOnCompleteListener { itSingUp ->
            if (itSingUp.isSuccessful) {
                val profileUpdate = UserProfileChangeRequest.Builder().setDisplayName(userSingUp.fullName).build()

                FirebaseAuth.getInstance().currentUser?.updateProfile(profileUpdate)?.addOnCompleteListener {
                    if (it.isSuccessful) {
                        continuation.resume(Unit)
                    } else {
                        continuation.resumeWithException(FirebaseSingUpException(it.exception?.message.toString()))
                    }
                }
            } else {
                continuation.resumeWithException(FirebaseSingUpException(itSingUp.exception?.message.toString()))
            }
        }
    }
}