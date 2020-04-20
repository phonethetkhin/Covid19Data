package com.example.covid19data.repo

import androidx.lifecycle.MutableLiveData
import com.example.covid19data.models.SummaryModel
import com.example.covid19data.retrofit.RetrofitObj


class CountryDetailRepo {
    val apiservice = RetrofitObj.apiservice
    val countryDetailLiveData = MutableLiveData<SummaryModel> ()

    suspend fun getSummaryFromAPI(name:String)
    {
        val response = apiservice.getCountyData("api/countries/$name")
        if(response.isSuccessful)
        {
            countryDetailLiveData.postValue(response.body())
        }
    }
}