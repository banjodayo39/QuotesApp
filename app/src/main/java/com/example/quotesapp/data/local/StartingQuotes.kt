package com.example.quotesapp.data.local

import android.content.Context
import androidx.annotation.WorkerThread
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.quotesapp.R
import com.example.quotesapp.model.Category
import com.example.quotesapp.model.Quotes
import com.example.quotesapp.util.executeThread
import org.json.JSONArray
import org.json.JSONException
import java.io.BufferedReader
import java.util.*

class StartingQuotes (private val context: Context) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) = executeThread {
            fillWithStartingData(context)
        }

        @WorkerThread
        private fun fillWithStartingData(context: Context) {
            val dao = AppDatabase.getInstance(context).quoteDao()

            try {
                val category = loadJsonArray(context)
                if (category != null) {
                    for (i in 0 until category.length()) {
                        val item = category.getJSONObject(i)
                        val category_item = item.getJSONArray("category_item")
                        val category_name = item.getString("category_name")
                        val id = item.getInt("id")
                         for (i in 0 until  category_item.length()){
                             val sub_item = category_item.getJSONObject(i)
                             val message = sub_item.getString("message")
                             val reply = sub_item.getString("reply")
                             val name = sub_item.getString("name")

                             val quote = Quotes(id=i,
                             name = name,
                             message = message,
                             reply = reply
                             )
                             dao.insertQuote(quote)
                         }
                        val category = Category(
                            id = i,
                            name = category_name
                        )
                        dao.insertCategory(category)
                    }
                }
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }

        private fun loadJsonArray(context: Context): JSONArray? {
            val inputStream = context.resources.openRawResource(R.raw.sample_json)
            BufferedReader(inputStream.reader()).use {
                return JSONArray(it.readText())
            }
        }


}