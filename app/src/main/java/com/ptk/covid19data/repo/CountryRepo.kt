package com.ptk.covid19data.repo

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.ptk.covid19data.models.CountryModel
import com.ptk.covid19data.room.Covid19DataDatabase
import com.ptk.covid19data.room.entities.CountriesEntity
import com.ptk.covid19data.utils.getCountryModel
import com.ptk.covid19data.utils.setToast

class CountryRepo(context: Context) {
    private val countryDao = Covid19DataDatabase.getCovid19DB(context)!!.countriesDao()
    val countryUtilsLiveData = MutableLiveData<List<CountryModel>>()
    val countryDBLiveData = MutableLiveData<CountriesEntity>()

    suspend fun getCountriesFromUtils(context: Context) {
        try {
            countryUtilsLiveData.postValue(getCountryModel())
        } catch (e: Exception) {
            setToast(context, "Error Occurred !!!", Toast.LENGTH_SHORT)
        }
    }

    suspend fun getCountriesFromDatabase() {
        countryDBLiveData.postValue(countryDao.getAllCountries())
    }

    suspend fun insertCountries(countriesEntity: CountriesEntity) {
        countryDao.insertCountry(countriesEntity)
    }

}