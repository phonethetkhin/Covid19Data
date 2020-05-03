package com.example.covid19data.repo

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.covid19data.models.CountryModel
import com.example.covid19data.room.Covid19DataDatabase
import com.example.covid19data.room.entities.CountriesEntity
import com.example.covid19data.utils.getCountryModel

class CountryRepo(context: Context) {
    private val countryDao = Covid19DataDatabase.getCovid19DB(context)!!.countriesDao()
    val countryUtilsLiveData = MutableLiveData<List<CountryModel>>()
    val countryDBLiveData = MutableLiveData<CountriesEntity>()

    suspend fun getCountriesFromUtils() {
        countryUtilsLiveData.postValue(getCountryModel())
    }

    suspend fun getCountriesFromDatabase() {
        countryDBLiveData.postValue(countryDao.getAllCountries())
    }

    suspend fun insertCountries(countriesEntity: CountriesEntity) {
        countryDao.insertCountry(countriesEntity)
    }

}