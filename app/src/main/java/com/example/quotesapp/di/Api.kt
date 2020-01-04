package com.example.quotesapp.di

import com.example.quotesapp.data.api.QuotesApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    factory { provideQuotesApi(get()) }

}

fun provideQuotesApi(retrofit: Retrofit): QuotesApi {
    return retrofit.create(QuotesApi::class.java)
}
