package com.example.quotesapp.data.api

import com.example.quotesapp.model.KutipanQuotes
import com.example.quotesapp.model.Resource
import com.example.quotesapp.util.networkUtil.ResponseHandler

class QuotesRepository(private val quotesApi: QuotesApi,
                       private val responseHandler: ResponseHandler ) {


    suspend fun getAllQuote(): Resource<KutipanQuotes> {
        return try {
            val response =
                quotesApi.getQuotes()
            return responseHandler.handleSuccess(response.data!!)
        } catch (e: Exception) {
            responseHandler.handleException(e)
        }
    }
}