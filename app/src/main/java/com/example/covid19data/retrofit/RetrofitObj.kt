package com.example.covid19data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitObj(BaseURl: String) {

    val apiservice: Apiservice

    init {
        val client = OkHttpClient.Builder().build()

        apiservice = Retrofit.Builder().baseUrl(BaseURl)

            .addConverterFactory(GsonConverterFactory.create())

            .client(client)

            .build()

            .create(Apiservice::class.java)

    }


}