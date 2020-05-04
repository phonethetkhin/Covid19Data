package com.example.covid19data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitObj(BaseURl: String) {
    val apiService: ApiService = Retrofit.Builder().baseUrl(BaseURl)

        .addConverterFactory(GsonConverterFactory.create())

        .client(getOkHTTPClient())

        .build()

        .create(ApiService::class.java)
}

fun getOkHTTPClient(): OkHttpClient {
    val client = OkHttpClient()
    val clientBuilder = client.newBuilder()
    clientBuilder.callTimeout(60,TimeUnit.SECONDS)
    clientBuilder.connectTimeout(10, TimeUnit.SECONDS)
    clientBuilder.readTimeout(10, TimeUnit.SECONDS)
    clientBuilder.writeTimeout(10, TimeUnit.SECONDS)
    return clientBuilder.build()
}