package com.example.covid19data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SourceModel(
    @SerializedName("name")
    @Expose
    val sourceName: String
    )