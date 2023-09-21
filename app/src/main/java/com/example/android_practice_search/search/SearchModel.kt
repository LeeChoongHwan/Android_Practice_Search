package com.example.android_practice_search.search

data class SearchModel(
    val imageURL: String,
    val title: String,
    val date: String,
    val isBookmarked: Boolean = false
)
