package com.example.quotesapp.util.networkUtil

import android.accounts.AccountManager
import android.content.Context
import android.content.Intent
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class AuthenticationInterceptor(val context: Context
) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        if (response.code() == 403) {
        }
        return response
    }

}