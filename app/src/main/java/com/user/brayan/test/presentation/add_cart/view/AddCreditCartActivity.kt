package com.user.brayan.test.presentation.add_cart.view

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.user.brayan.test.R
import com.user.brayan.test.base.BaseActivity
import com.user.brayan.test.data.remote.ApiUtils
import com.user.brayan.test.data.remote.CardJsonBody
import com.user.brayan.test.data.remote.UserService
import com.user.brayan.test.data.remote.builder.*
import com.user.brayan.test.tools.FormatDateCard
import com.user.brayan.test.tools.FormatNumberCard
import kotlinx.android.synthetic.main.activity_add_credit_cart.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AddCreditCartActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        etCardDate.addTextChangedListener(FormatDateCard(etCardDate))
        etCardNumber.addTextChangedListener(FormatNumberCard(etCardNumber))

        btnAddCard.setOnClickListener {
            val cart = Card.Builder().setNumber("4005580000000040").build()
            val instrument = Instrument.Builder().setCard(cart).build()
            val amount = Amount.Builder().setTotal(12.10).setCurrency("USD").build()
            val payment = Payment.Builder().setReference("prueba_123").setAmount(amount).build()
            val cardInformationBody = CardJsonBody().jsonInformation(instrument, payment)

            val service: UserService = ApiUtils.getService()
            val call = service.informationCard(cardInformationBody.toString())

            call?.enqueue(object : Callback<String> {
                override fun onResponse(call: Call<String>, response: Response<String>) {
                    if (response.isSuccessful) {
                        Log.e("datos", "${response.body()}")
                    }
                }

                override fun onFailure(call: Call<String>, t: Throwable) {
                    Log.e("datos", "${t.message.toString()}")
                }
            })
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_add_credit_cart
    }

    override fun getToolbar(): Int {
        return R.id.toolbar
    }
}