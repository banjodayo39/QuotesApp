package com.example.quotesapp.util

import java.util.concurrent.Executors

private val SINGLE_EXECUTOR = Executors.newSingleThreadExecutor()

fun executeThread(f: () -> Unit) {
    SINGLE_EXECUTOR.execute(f)
}

val LOG_TAG = "com.quote.log"
val RETROFIT_BASE_URL = "http://gateway.marvel.com"

//response codes
val OK = 200
val INVALID_REQUEST = 400
val UNAUTHORIZED = 401
val HTTP_STATUS_403 = 403
val HTTP_STATUS_404 = 404
val SERVER_ERROR = 500
