package com.example.covid19data.repo

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.covid19data.models.SummaryModel
import com.example.covid19data.retrofit.RetrofitObj
import com.example.covid19data.utils.CovidDataBaseURL
import com.example.covid19data.utils.setToast

class SummaryRepo {
    private val apiService = RetrofitObj(CovidDataBaseURL).apiService
    val summaryLiveData = MutableLiveData<SummaryModel>()

    suspend fun getSummaryFromAPI(context:Context) {
        try {
            val response = apiService.getSummary()
            if (response.isSuccessful) {
                summaryLiveData.postValue(response.body())
            }
        } catch (e: Exception) {
            setToast(context,"Error Occurred !!!",Toast.LENGTH_SHORT)
        }


    }
}