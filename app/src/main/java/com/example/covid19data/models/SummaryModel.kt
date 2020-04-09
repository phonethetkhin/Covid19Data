package com.example.covid19data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class SummaryModel(

    @SerializedName("confirmed")
    @Expose
    val confirmedModel: ConfirmedModel,

    @SerializedName("recovered")
    @Expose
    val recoveredModel: RecoveredModel,

    @SerializedName("deaths")
    @Expose
    val deathsModel: DeathsModel,

    @SerializedName("image")
    @Expose
    val image : String,

    @SerializedName("lastUpdate")
    @Expose
    val lastestUpdate : String




)





