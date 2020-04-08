package com.example.covid19data.retrofit

import com.example.covid19data.models.SummaryModel
import retrofit2.Response
import retrofit2.http.GET

interface Apiservice {
    @GET("summary")
    suspend fun getSummary() : Response<SummaryModel>


}