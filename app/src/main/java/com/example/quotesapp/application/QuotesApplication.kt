package com.example.quotesapp.application

import androidx.multidex.MultiDexApplication
import com.example.quotesapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class QuotesApplication  : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@QuotesApplication)
            modules(
                listOf(
                    preferenceModule,
                    networkModule,
                    apiModule,
                    repositoryModule,
                    viewModelModule,
                    databaseModule
                )
            )
        }
    }
}