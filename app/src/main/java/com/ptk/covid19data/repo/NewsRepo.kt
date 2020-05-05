package com.ptk.covid19data.repo

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.ptk.covid19data.models.NewsModel
import com.ptk.covid19data.retrofit.RetrofitObj
import com.ptk.covid19data.utils.NewsBaseURl
import com.ptk.covid19data.utils.setToast
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeoutException

class NewsRepo {
    private val apiService = RetrofitObj(NewsBaseURl).apiService
    val newsLiveData = MutableLiveData<NewsModel>()

    @SuppressLint("SimpleDateFormat")
    suspend fun getApiNewsLiveData(context: Context) {
        val c = Calendar.getInstance(Locale.getDefault())


        val df = SimpleDateFormat("yyyy-MM-dd")


        val result = df.format(c.time)

        try {
            val response =
                apiService.getAllCovidNews("Covid 19", result, "e6efa7af141a41238111e8a74f730a0c")
            if (response.isSuccessful) {
                newsLiveData.postValue(response.body())
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
