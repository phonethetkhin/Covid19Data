package com.example.covid19data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NewsDetailModel(
    @SerializedName("source")
    @Expose
    val source: SourceModel,

    @SerializedName("author")
    @Expose
    val author: String,

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("urlToImage")
    @Expose
    val ImageURl: String,

    @SerializedName("content")
    @Expose
    val content: String
    )