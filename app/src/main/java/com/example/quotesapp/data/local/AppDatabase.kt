package com.example.quotesapp.data.local

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quotesapp.model.Category
import com.example.quotesapp.model.Quotes

@Database(
    entities = [Category::class,
        Quotes::class],
    version = 0,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun quoteDao(): QuoteDAO

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "quotedb"
                ).addCallback(StartingQuotes(context.applicationContext))
                    .build()
                INSTANCE = instance
                return instance

            }
        }
    }
}