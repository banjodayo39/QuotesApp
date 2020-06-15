package com.example.quotesapp.data.local

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.quotesapp.model.Category
import com.example.quotesapp.model.Quotes

@Dao
interface QuoteDAO {

    @Query("SELECT * from category ORDER BY category ASC")
    fun getCategory(): List<Category>

    @Query("SELECT * from quote ORDER BY name ASC")
    fun getQuote(): DataSource.Factory<Int, Quotes>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCategory(category: Category)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insertQuote(quotes: Quotes)

    @Query("DELETE FROM quote")
    suspend fun deleteAll()

}