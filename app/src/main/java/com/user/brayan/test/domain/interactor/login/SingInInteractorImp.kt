package com.user.brayan.test.domain.interactor.login

import com.google.firebase.auth.FirebaseAuth
import com.user.brayan.test.presentation.login.exceptions.FirebaseLoginException
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

class SingInInteractorImp: SingInInteractor {
     override suspend fun singInUser(email: String, password: String): Unit = suspendCancellableCoroutine { continuation ->
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                continuation.resume(Unit)
            } else {
                continuation.resumeWithException(FirebaseLoginException(it.exception?.message.toString()))
            }
        }
    }
}