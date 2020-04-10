package com.example.covid19data.room

import androidx.room.*
import com.example.covid19data.models.CountryDetailModel
import com.example.covid19data.utils.DataConverter

@Entity(tableName = "tbl_countries")
data class CountriesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "country_id")
    val countryID: Int,

  @ColumnInfo(name = "countries_list")
    val countrieslist : List<CountryDetailModel>

)
