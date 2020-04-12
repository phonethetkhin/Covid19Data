package com.example.covid19data.repo

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.covid19data.models.CountryModel
import com.example.covid19data.retrofit.RetrofitObj
import com.example.covid19data.room.entities.CountriesEntity
import com.example.covid19data.room.Covid19DataDatabase

class CountryRepo(context: Context) {
    val countryDao = Covid19DataDatabase.getCovid19DB(context)!!.countriesDao()

    val apiservice = RetrofitObj.apiservice
    val countryAPILiveData = MutableLiveData<CountryModel>()
    val countryDBLiveData = MutableLiveData<CountriesEntity>()

    suspend fun getCountriesfromAPI()
    {
        val response = apiservice.getAllCountries()
        if( response.isSuccessful)
        {
            countryAPILiveData.postValue(response.body())
        }
    }

    suspend fun getCountriesFromDatabase()
    {
        countryDBLiveData.postValue(countryDao.getAllCountries())
    }

    suspend fun insertCountries(countriesEntity: CountriesEntity)
    {
        countryDao.insertCountry(countriesEntity)
    }

}