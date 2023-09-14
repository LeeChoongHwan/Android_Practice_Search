package com.example.android_practice_search.search

import java.net.URL

data class SearchModel(
    val imageURL: URL?,
    val type : String,
    val title : String,
    val date : String
)
