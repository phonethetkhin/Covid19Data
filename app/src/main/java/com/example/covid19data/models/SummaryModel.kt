package com.example.covid19data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SummaryModel(
    @SerializedName("Global")
    @Expose
    val globalModel : GlobalModel,

    @SerializedName("Countries")
    @Expose
    val countryModellist : List<CountryModel>,

    @SerializedName("Date")
    @Expose
    val date : String

)