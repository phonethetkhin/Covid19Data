package com.ptk.covid19data.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ptk.covid19data.models.CountryModel

@Entity(tableName = "tbl_countries")
data class CountriesEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "country_id")
    val countryID: Int,

    @ColumnInfo(name = "countries_list")
    val countriesList: List<CountryModel>


)
