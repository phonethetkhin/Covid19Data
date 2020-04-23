package com.example.covid19data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RecoveredModel(
    @SerializedName("value")
    @Expose
    val totalRecovered: Int

)