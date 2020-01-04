package com.example.quotesapp.model

data class KutipanQuotes(
    var author: Author? = null,
    var category: Category? = null,
    var created_at: String? = null,
    var id: Int? = null,
    var language: Language? = null,
    var source: Any? = null,
    var text: String? = null,
    var updated_at: String? = null
)

data class Author(
    var created_at: String? = null,
    var full_image_path: Any? = null,
    var id: Int? = null,
    var name: String? = null,
    var updated_at: String? = null
)

data class Category(
    var created_at: String? = null,
    var id: Int? = null,
    var name: String? = null,
    var updated_at: String? = null
)

data class Language(
    var code: String? = null,
    var created_at: String? = null,
    var id: Int? = null,
    var name: String? = null,
    var native_name: String? = null,
    var updated_at: String? = null
)