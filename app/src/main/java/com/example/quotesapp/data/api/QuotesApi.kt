package com.example.quotesapp.data.api

import com.example.quotesapp.model.ApiResponse
import com.example.quotesapp.model.KutipanQuotes
import retrofit2.http.GET
import retrofit2.http.Path

interface QuotesApi {

    @GET("https://kutip.p.rapidapi.com/api/quote/random")
    suspend fun getQuotes(): ApiResponse<KutipanQuotes>
}