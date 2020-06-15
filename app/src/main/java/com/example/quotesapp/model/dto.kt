package com.example.quotesapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class  Category(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "category_name")
    var name: String,
    @ColumnInfo(name = "category_item")
    var category: List<Category>? = null

)

@Entity(tableName = "quote")
data class Quotes(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int,
    @ColumnInfo(name = "name")
    var name: String? = null,
    @ColumnInfo(name = "message")
    var message: String? = null,
    @ColumnInfo(name = "reply")
    var reply: String? = null
)
