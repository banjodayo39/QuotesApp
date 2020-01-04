package com.example.quotesapp.di

import android.util.Log
import com.example.quotesapp.util.RETROFIT_BASE_URL
import com.example.quotesapp.util.RequestHeaderInterceptor
import com.example.quotesapp.util.networkUtil.AuthenticationInterceptor
import com.example.quotesapp.util.networkUtil.OkHttpClientAuthenticator
import com.example.quotesapp.util.networkUtil.ResponseHandler
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single { provideGson() }
    single { provideHttpInterceptorLogger() }
    single { provideHttpLoggingInterceptor(get()) }
    factory { RequestHeaderInterceptor() }
    factory { AuthenticationInterceptor(androidContext()) }
    factory { OkHttpClientAuthenticator(androidContext()) }
    factory { provideOkhttpClient(get(), get(), get()) }
    single { provideRetrofit(get(), get()) }
    factory { ResponseHandler() }
   // single { NetworkUtil(androidContext())}
}

val HTTP_LOG_TAG = "com.quote.http.log"

fun provideGson(): Gson {
    val gsonBuilder = GsonBuilder()
    gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
    return gsonBuilder.create()
}

fun provideHttpInterceptorLogger(): HttpLoggingInterceptor.Logger {

    return HttpLoggingInterceptor.Logger { message -> Log.d(HTTP_LOG_TAG, message) }
}

fun provideHttpLoggingInterceptor(logger: HttpLoggingInterceptor.Logger): HttpLoggingInterceptor {
    val interceptor = HttpLoggingInterceptor(logger)
    interceptor.level = HttpLoggingInterceptor.Level.BODY
    interceptor.redactHeader("Authorization")
    interceptor.redactHeader("Cookie")
    interceptor.redactHeader("X-Auth-Token")
    return interceptor
}

fun provideOkhttpClient(requestHeaderInterceptor: RequestHeaderInterceptor,
                        okHttpClientAuthenticator: OkHttpClientAuthenticator,
                        loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {

    val httpClient = OkHttpClient.Builder()
    httpClient.addInterceptor(loggingInterceptor)
    httpClient.addInterceptor(requestHeaderInterceptor)
    httpClient.authenticator(okHttpClientAuthenticator)
    httpClient.connectTimeout(15, TimeUnit.SECONDS)
    httpClient.readTimeout(30, TimeUnit.SECONDS)
    return httpClient.build()
}

fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(RETROFIT_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .build()
}
