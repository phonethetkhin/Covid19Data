package com.example.covid19data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountryModel
    (
    @SerializedName("Country")
    @Expose
    val country: String,

    @SerializedName("CountryCode")
    @Expose
    val countryCode: String,

    @SerializedName("NewConfirmed")
    @Expose
    val newConfirmed: Int,

    @SerializedName("TotalConfirmed")
    @Expose
    val totalConfirmed: Int,

    @SerializedName("NewDeaths")
    @Expose
    val newDeaths : Int,

    @SerializedName("TotalDeaths")
    @Expose
    val totalDeaths : Int,

    @SerializedName("NewRecovered")
    @Expose
    val newRecovered : Int,

    @SerializedName("TotalRecovered")
    @Expose
    val totalRecovered : Int,

    @SerializedName("Date")
    @Expose
    val date : String

    )