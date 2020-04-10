package com.example.covid19data.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountryDetailModel(

@SerializedName("name")
@Expose
val name: String,

@SerializedName("iso2")
@Expose
val iso2 : String


)
