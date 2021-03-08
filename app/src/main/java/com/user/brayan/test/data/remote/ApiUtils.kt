package com.user.brayan.test.data.remote

object ApiUtils {
    var url = "https://dev.placetopay.com/rest/gateway/"

    fun getService() : UserService {
        return RetrofitClient.getClient(url).create(UserService::class.java)
    }
}