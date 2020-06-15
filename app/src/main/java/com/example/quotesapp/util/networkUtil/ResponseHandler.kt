package com.example.quotesapp.util.networkUtil

import com.example.quotesapp.model.ApiError
import com.example.quotesapp.util.SERVER_ERROR
import com.google.gson.Gson
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

enum class ErrorCodes(val code: Int) {
    SocketTimeOut(-1)
}

open class ResponseHandler {
    fun <T : Any> handleSuccess(data: T): Resource<T> {
        return Resource.success(data)
    }

    fun <T : Any> handleException(e: Exception): Resource<T> {
        return when (e) {
            is HttpException -> {
                when (e.code()) {
                    400 -> Resource.error(e.code(), getApiErrorMessage(e), null)
                    else -> Resource.error(e.code(), getErrorMessage(e.code()), null)
                }
            }
            is SocketTimeoutException -> Resource.error(ErrorCodes.SocketTimeOut.code,
                                            getErrorMessage(ErrorCodes.SocketTimeOut.code), null)
            is IOException -> Resource.error(ErrorCodes.SocketTimeOut.code,
                getErrorMessage(ErrorCodes.SocketTimeOut.code), null)
            else -> Resource.error(SERVER_ERROR, getErrorMessage(Int.MAX_VALUE), null)
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            ErrorCodes.SocketTimeOut.code -> "Sorry, your internet connection is currently unavailable!"
            401 -> return "Unauthorized access, you have been logged out"
            403 -> return "Already logged onto another device"
            //404 -> "Not found"
            else -> "Oops!! It seems we are having some difficulties processing your request at the moment. Could you please try again"
        }
    }

    private fun getApiErrorMessage(e: HttpException) : String {
        var errorMessage = "Oops!! It seems we are having some difficulties processing your request at the moment. Could you please try again"

        try {
            val errorBody = e.response()?.errorBody()?.string()
            val error = Gson().fromJson<ApiError>(errorBody, ApiError::class.java)
            if(!error.message.isNullOrEmpty()) {
                errorMessage = error.message!!
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return errorMessage
    }
}