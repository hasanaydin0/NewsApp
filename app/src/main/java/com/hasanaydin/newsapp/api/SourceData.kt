package com.hasanaydin.newsapp.api

import com.google.gson.annotations.SerializedName

data class SourceData(

    @SerializedName("id") val id : String,
    @SerializedName("name") val name : String
)
