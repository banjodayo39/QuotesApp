package com.example.quotesapp.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ApiResponse<T> {
    @SerializedName("code")
    @Expose
    var code: Int = 0

    @SerializedName("data")
    @Expose
    var data: T? = null

    @SerializedName("error")
    @Expose
    var error: ApiError? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

}

data class ApiError(
    @SerializedName("code")
    @Expose
    var code: Int? = 0,
    @SerializedName("message")
    @Expose
    var message: String? = ""
)

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}