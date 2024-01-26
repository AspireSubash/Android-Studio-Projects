package com.aspire.music.controller

import com.aspire.music.DataModels.MyData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiInterface {
    @Headers(
 // Your api Key
    )
    @GET("search")
    fun getData(@Query("q") query: String): Call<MyData>
}
