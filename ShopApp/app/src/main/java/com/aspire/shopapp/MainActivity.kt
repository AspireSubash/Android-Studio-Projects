package com.aspire.shopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Objects

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
//        val text = findViewById<TextView>(R.id.textView)
        val apiInterface = retrofit.create(ResponceInterface::class.java)
        val retrofitData = apiInterface.getData()
        retrofitData.enqueue(object : Callback<UserData?> {
            override fun onResponse(call: Call<UserData?>, response: Response<UserData?>) {
                if (response.isSuccessful) {
                    val myData = response.body()
//                    text.setText(myData.toString())
                    Log.d("TAG : onResponse", "onResponse: $myData")

                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Response received parsing error",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<UserData?>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    "API Call Failure: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}