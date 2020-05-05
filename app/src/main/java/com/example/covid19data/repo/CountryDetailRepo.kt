package com.example.covid19data.repo

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.covid19data.models.SummaryModel
import com.example.covid19data.retrofit.RetrofitObj
import com.example.covid19data.utils.CovidDataBaseURL
import com.example.covid19data.utils.setToast


class CountryDetailRepo {
    private val apiService = RetrofitObj(CovidDataBaseURL).apiService
    val countryDetailLiveData = MutableLiveData<SummaryModel>()

    suspend fun getSummaryFromAPI(context: Context, name: String) {
        try {
            val response = apiService.getCountyData("api/countries/$name")
            if (response.isSuccessful) {
                countryDetailLiveData.postValue(response.body())
            }
        } catch (e: Exception) {
            setToast(context, "Error Occurred !!!", Toast.LENGTH_SHORT)

        }
    }
}