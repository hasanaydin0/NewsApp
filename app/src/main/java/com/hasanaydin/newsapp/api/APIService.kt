package com.hasanaydin.newsapp.api


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("/v2/everything")
    fun getNews(
        @Query("apiKey") apiKey: String,
        @Query("q") q: String,
        @Query("from") from:String,
        @Query("sortBy") sortBy: String
    ): Call<NewsData>
}