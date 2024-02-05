package com.aspire.shopapp

import retrofit2.Call
import retrofit2.http.GET

interface ResponceInterface {
    @GET("/users/1")
    fun getData(): Call<UserData>

}