package com.example.covid19data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountryModel(
    @SerializedName("countries")
    @Expose
    val countryList: List<CountryDetailModel>

)