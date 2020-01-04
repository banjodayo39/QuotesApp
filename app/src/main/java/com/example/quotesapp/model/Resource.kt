package com.example.quotesapp.model

import android.icu.text.DateTimePatternGenerator.PatternInfo.OK

data class Resource<out T>(val status: Status, val code: Int?, val data: T?, val message: String?) {

    companion object {
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, OK, data, null)
        }

        fun <T> error(code: Int, msg: String?, data: T?): Resource<T> {
            return Resource(Status.ERROR, code, data, msg)
        }

        fun <T> loading(data: T?): Resource<T> {
            return Resource(Status.LOADING, 0, data, null)
        }
    }
}