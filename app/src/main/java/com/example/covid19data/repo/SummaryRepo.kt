package com.example.covid19data.repo

import androidx.lifecycle.MutableLiveData
import com.example.covid19data.models.SummaryModel
import com.example.covid19data.retrofit.RetrofitObj

class SummaryRepo {
    val apiservice = RetrofitObj.apiservice
    val summaryLiveData = MutableLiveData<SummaryModel> ()

    suspend fun getSummaryFromAPI()
    {
        val response = apiservice.getSummary()
        if(response.isSuccessful)
        {
            summaryLiveData.postValue(response.body())
        }
    }
}