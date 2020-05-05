package com.example.covid19data.vModel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid19data.repo.CountryDetailRepo
import kotlinx.coroutines.launch


class CountryDetailViewModel : ViewModel() {
    private val countryDetailRepo = CountryDetailRepo()
    val countryDetailLiveData = countryDetailRepo.countryDetailLiveData

    fun getCountryDetail(context: Context, name: String) = viewModelScope.launch {
        countryDetailRepo.getSummaryFromAPI(context, name)
    }
}