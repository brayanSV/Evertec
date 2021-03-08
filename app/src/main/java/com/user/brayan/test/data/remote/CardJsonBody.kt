package com.user.brayan.test.data.remote

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import com.user.brayan.test.data.remote.builder.Instrument
import com.user.brayan.test.data.remote.builder.Payment
import org.json.JSONObject
import java.math.BigInteger
import java.security.MessageDigest
import java.security.SecureRandom
import java.text.SimpleDateFormat
import java.util.*

class CardJsonBody {
    fun jsonInformation(instrument: Instrument, payment: Payment): JSONObject {
        val response = JSONObject()
        response.accumulate("auth", authentication())

        response.accumulate("instrument",
            JSONObject().put("card", JSONObject().put("number", instrument.card?.number))
        )

        response.accumulate("payment",
            JSONObject()
                .put("reference", payment.reference)
                .put("amount",
                    JSONObject()
                        .put("total", payment.amount?.total)
                        .put("currency", payment.amount?.currency)
                )
        )

        return response
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun authentication(): JSONObject {
        val tranKey = "024h1IlD"
        val login = "6dd490faf9cb87a9862245da41170ff2"
        val nonce = BigInteger(130, SecureRandom()).toString()
        val seed = SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ", Locale.getDefault()).format(Date())

        val auth = JSONObject()
        auth.put("login", login)
        auth.put("tranKey", base64(SHA_256(nonce + seed + tranKey)))
        auth.put("nonce", base64(nonce.toByteArray()))
        auth.put("seed", seed)
        return auth
    }

    private fun SHA_256(input: String): ByteArray? {
        val mDigest: MessageDigest = MessageDigest.getInstance("SHA-256")
        return mDigest.digest(input.toByteArray())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun base64(input: ByteArray?): String? {
        val encodedBytes = Base64.getEncoder().encode(input)
        return String(encodedBytes)
    }
}