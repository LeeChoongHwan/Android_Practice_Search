package com.example.android_practice_search.retrofit

import com.google.gson.annotations.SerializedName

data class Image(val response : ImageResponse)

data class ImageResponse(
    @SerializedName("meta")
    val imageMeta : ImageMeta,
    @SerializedName("documents")
    val imageDocument : List<ImageItem>
)

data class ImageMeta(
    @SerializedName("total_count")
    val totalCount : Int,
    @SerializedName("pageable_count")
    val pageableCount : Int,
    @SerializedName("is_end")
    val isEnd : Boolean
)

data class ImageItem(
    val collection : String,
    @SerializedName("thumbnail_url")
    val thumbnailUrl : String,
    @SerializedName("image_url")
    val imageUrl : String,
    val width : Int,
    val height : Int,
    @SerializedName("display_sitename")
    val displaySiteName : String,
    @SerializedName("doc_url")
    val docUrl : String,
    val datetime : String
)
