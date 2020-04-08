package com.example.covid19data.retrofit

import com.example.covid19data.utils.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObj {

        val apiservice:Apiservice

        init {
            val client= OkHttpClient.Builder().build()

            apiservice= Retrofit.Builder().baseUrl(BASE_URL)

                .addConverterFactory(GsonConverterFactory.create())

                .client(client)

                .build()

                .create(Apiservice::class.java)

        }




}