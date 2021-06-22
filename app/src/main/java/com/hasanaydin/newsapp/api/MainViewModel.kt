package com.hasanaydin.newsapp.api

import androidx.lifecycle.ViewModel
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainViewModel : ViewModel() {

    fun gam() {
        val gson = GsonBuilder().setLenient().create()
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(APIUrl.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
        val apis = retrofit.create(APIService::class.java)
        val call: Call<NewsData> = apis.getNews("d9c0b94025e44775aca56658f264e6a2","news","2021-06-16","popularity")
        call.enqueue(object : Callback<NewsData?> {
            override fun onResponse(call: Call<NewsData?>?, response: Response<NewsData?>?) {
                if (response != null) {
                    println(response.body())
                }
            }

            override fun onFailure(call: Call<NewsData?>?, t: Throwable?) {

            }

        })
    }

}