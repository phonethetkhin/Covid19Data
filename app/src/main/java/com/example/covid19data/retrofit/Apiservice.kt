package com.example.covid19data.retrofit

import com.example.covid19data.models.CountryModel
import com.example.covid19data.models.NewsModel
import com.example.covid19data.models.SummaryModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface Apiservice {
    @GET("api")
    suspend fun getSummary() : Response<SummaryModel>

    @GET("api/countries")
    suspend fun getAllCountries() : Response<CountryModel>

    @GET
    suspend fun getCountyData(@Url url:String) : Response<SummaryModel>

    //------------------------------------------------------------------------- Covid 19 ends here

    @GET("everything")
    suspend fun getAllCovidNews(
        @Query("q")  keyword:String,
        @Query("apiKey") apikey:String
    ) : Response<NewsModel>
}