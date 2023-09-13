package com.io.weather.repository

import com.io.weather.model.Weather
import retrofit2.http.GET

interface WeatherApi {
    @GET("/v1/current.json?key=63eeb0eaf1d240b596f135255231309&q=Depok&aqi=no")
    suspend fun getDepokWeather() : Weather
}