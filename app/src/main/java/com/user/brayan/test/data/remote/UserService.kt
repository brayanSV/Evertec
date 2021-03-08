package com.user.brayan.test.data.remote

import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.*

interface UserService {
    @Headers("Content-Type: application/json")
    @POST("information")
    fun informationCard(@Body params : String): Call<String>
}