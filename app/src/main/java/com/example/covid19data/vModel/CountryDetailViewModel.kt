package com.example.covid19data.vModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid19data.repo.CountryDetailRepo
import kotlinx.coroutines.launch


class CountryDetailViewModel : ViewModel() {
    val countryDetailRepo = CountryDetailRepo()
    val countryDetailLiveData = countryDetailRepo.countryDetailLiveData

    fun getCountryDetail(name:String) = viewModelScope.launch {
        countryDetailRepo.getSummaryFromAPI(name)
    }
}