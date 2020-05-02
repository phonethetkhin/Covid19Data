package com.example.covid19data.vModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid19data.repo.CountryRepo
import com.example.covid19data.room.entities.CountriesEntity
import kotlinx.coroutines.launch

class CountryViewModel(application: Application) : AndroidViewModel(application) {
    private val countryRepo = CountryRepo(application)
    val countryUtilsLiveData = countryRepo.countryUtilsLiveData
    val countryDBLiveData = countryRepo.countryDBLiveData

    fun getCountryUtilsLiveData() = viewModelScope.launch {
countryRepo.getCountriesFromUtils()
    }

    fun getCountryDBLiveData() = viewModelScope.launch {
        countryRepo.getCountriesFromDatabase()
    }

    fun insertCountries(countriesEntity: CountriesEntity) {
        viewModelScope.launch {
            countryRepo.insertCountries(countriesEntity)
        }
    }

}