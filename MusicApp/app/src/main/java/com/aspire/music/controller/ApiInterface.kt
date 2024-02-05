package com.aspire.music.controller

import com.aspire.music.DataModels.MyData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @Headers(
        "X-RapidAPI-Key: 44e009f6aemshca35e74ec8b77d5p1a1374jsnc7f7b2f3f94d",
        "X-RapidAPI-Host: deezerdevs-deezer.p.rapidapi.com"
    )
    @GET("search")
    fun getData(@Query("q") query: String): Call<MyData>
}
