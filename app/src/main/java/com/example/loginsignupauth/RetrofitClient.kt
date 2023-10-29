package com.example.loginsignupauth

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    private const val BASE_URL = "https://your-api-url.com/" // Replace with your API URL

    val instance: MainActivity.ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(MainActivity.ApiService::class.java)
    }
}