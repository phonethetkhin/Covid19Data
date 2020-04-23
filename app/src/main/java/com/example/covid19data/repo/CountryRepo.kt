package com.example.covid19data.repo

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.covid19data.models.CountryModel
import com.example.covid19data.retrofit.RetrofitObj
import com.example.covid19data.room.Covid19DataDatabase
import com.example.covid19data.room.entities.CountriesEntity
import com.example.covid19data.utils.CovidDataBaseURL

class CountryRepo(context: Context) {
    private val countryDao = Covid19DataDatabase.getCovid19DB(context)!!.countriesDao()
    private val apiService = RetrofitObj(CovidDataBaseURL).apiService
    val countryAPILiveData = MutableLiveData<CountryModel>()
    val countryDBLiveData = MutableLiveData<CountriesEntity>()

    suspend fun getCountriesFromAPI() {
        val response = apiService.getAllCountries()
        if (response.isSuccessful) {
            countryAPILiveData.postValue(response.body())
        }
    }

    suspend fun getCountriesFromDatabase() {
        countryDBLiveData.postValue(countryDao.getAllCountries())
    }

    suspend fun insertCountries(countriesEntity: CountriesEntity) {
        countryDao.insertCountry(countriesEntity)
    }

}