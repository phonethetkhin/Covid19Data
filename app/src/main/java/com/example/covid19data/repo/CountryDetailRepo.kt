package com.example.covid19data.repo

import androidx.lifecycle.MutableLiveData
import com.example.covid19data.models.SummaryModel
import com.example.covid19data.retrofit.RetrofitObj
import com.example.covid19data.utils.CovidDataBaseURL


class CountryDetailRepo {
    private val apiService = RetrofitObj(CovidDataBaseURL).apiService
    val countryDetailLiveData = MutableLiveData<SummaryModel>()

    suspend fun getSummaryFromAPI(name: String) {
        val response = apiService.getCountyData("api/countries/$name")
        if (response.isSuccessful) {
            countryDetailLiveData.postValue(response.body())
        }
    }
}