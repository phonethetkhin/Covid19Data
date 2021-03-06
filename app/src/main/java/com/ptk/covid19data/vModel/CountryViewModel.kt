package com.ptk.covid19data.vModel

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ptk.covid19data.repo.CountryRepo
import com.ptk.covid19data.room.entities.CountriesEntity
import com.ptk.covid19data.utils.setToast
import kotlinx.coroutines.launch
import java.util.concurrent.TimeoutException

class CountryViewModel(application: Application) : AndroidViewModel(application) {
    private val countryRepo = CountryRepo(application)
    val countryUtilsLiveData = countryRepo.countryUtilsLiveData
    val countryDBLiveData = countryRepo.countryDBLiveData

    fun getCountryUtilsLiveData(context: Context) = viewModelScope.launch {
        countryRepo.getCountriesFromUtils(context)
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