package com.ptk.covid19data.repo

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.ptk.covid19data.models.SummaryModel
import com.ptk.covid19data.retrofit.RetrofitObj
import com.ptk.covid19data.utils.CovidDataBaseURL
import com.ptk.covid19data.utils.setToast
import java.util.concurrent.TimeoutException


class CountryDetailRepo {
    private val apiService = RetrofitObj(CovidDataBaseURL).apiService
    val countryDetailLiveData = MutableLiveData<SummaryModel>()

    suspend fun getSummaryFromAPI(context: Context, name: String?) {
        try {
            val response = apiService.getCountyData("api/countries/$name")
            if (response.isSuccessful) {
                countryDetailLiveData.postValue(response.body())
            }
        } catch (e: Exception) {
            if (e is TimeoutException) {
                setToast(
                    context,
                    "Connection Timeout, Check your connection !!!",
                    Toast.LENGTH_SHORT
                )

            }
            setToast(context, "Error Occurred !!!", Toast.LENGTH_SHORT)

        }
    }

}