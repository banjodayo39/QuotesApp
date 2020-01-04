package com.example.quotesapp.util

import okhttp3.Headers
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.HashMap


class RequestHeaderInterceptor() :
    Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val headers = Headers.of(getHeaders())
        val newRequest = originalRequest.newBuilder()
            .headers(headers)
            .build()
        return chain.proceed(newRequest)
    }

    private fun getHeaders(): Map<String, String> {
        val headers = HashMap<String, String>()
        headers["Content-Type"] = "application/json"
        headers["User-Agent"] = "Android; Mobile"

        return headers
    }
}