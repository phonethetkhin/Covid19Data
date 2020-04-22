package com.example.covid19data.room.entities

import androidx.room.*
import com.example.covid19data.models.CountryDetailModel

@Entity(tableName = "tbl_countries")
data class CountriesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "country_id")
    val countryID: Int,

    @ColumnInfo(name = "countries_list")
    val countriesList : List<CountryDetailModel>,

    @ColumnInfo(name = "flags_list")
    val flagList : List<String>

)
