package com.example.quotesapp.di


import android.app.Application
import androidx.room.Room
import com.example.quotesapp.data.local.AppDatabase
import com.example.quotesapp.data.local.QuoteDAO

import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val databaseModule = module {
    single { provideApplicationDatabase(androidApplication()) }
    //single { provideBattleDao(get())}
}

fun provideApplicationDatabase(context: Application): AppDatabase {
    return Room.databaseBuilder(context, AppDatabase::class.java, "quotedb")
        .fallbackToDestructiveMigration()
        .build()
}

//fun provideBattleDao(database: AppDatabase):QuoteDAO = database.quoteDAO

