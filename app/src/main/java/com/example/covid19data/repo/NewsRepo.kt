package com.example.covid19data.repo

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.covid19data.models.NewsModel
import com.example.covid19data.retrofit.RetrofitObj
import com.example.covid19data.utils.NewsBaseURl
import com.example.covid19data.utils.setToast
import java.text.SimpleDateFormat
import java.util.*

class NewsRepo {
    private val apiService = RetrofitObj(NewsBaseURl).apiService
    val newsLiveData = MutableLiveData<NewsModel>()

    suspend fun getApiNewsLiveData(context: Context) {
        val c = Calendar.getInstance(Locale.getDefault())



        val df = SimpleDateFormat("yyyy-MM-dd")


        val result =df.format(c.time)

        try {
            val response =
                apiService.getAllCovidNews("Covid 19", result, "e6efa7af141a41238111e8a74f730a0c")
            if (response.isSuccessful) {
                newsLiveData.postValue(response.body())
            }
        } catch (e: Exception) {
            setToast(context,"Error Occurred !!!", Toast.LENGTH_SHORT)

        }
    }
}
