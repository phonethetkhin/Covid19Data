package com.ptk.covid19data.models

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

    @SerializedName("lastUpdate")
    @Expose
    val lastestUpdate: String


)





