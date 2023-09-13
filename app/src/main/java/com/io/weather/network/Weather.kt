package com.io.weather.network

import com.io.weather.repository.WeatherApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Weather {
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://api.weatherapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WeatherApi::class.java)
    }
}