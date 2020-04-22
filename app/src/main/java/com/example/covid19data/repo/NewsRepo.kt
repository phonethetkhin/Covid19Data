package com.example.covid19data.repo

import androidx.lifecycle.MutableLiveData
import com.example.covid19data.models.NewsModel
import com.example.covid19data.retrofit.RetrofitObj
import com.example.covid19data.utils.NewsBaseURl

class NewsRepo {
    val apiservice = RetrofitObj(NewsBaseURl).apiservice
    val newsLiveData = MutableLiveData<NewsModel>()

    suspend fun getApiNewsLiveData() {
        val response = apiservice.getAllCovidNews("Covid 19", "e6efa7af141a41238111e8a74f730a0c")
        if (response.isSuccessful) {
            newsLiveData.postValue(response.body())
        }
    }
}