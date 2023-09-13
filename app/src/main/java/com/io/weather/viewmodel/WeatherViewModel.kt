package com.io.weather.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.io.weather.network.Weather
import kotlinx.coroutines.launch
import com.io.weather.model.Weather as WeatherModel

class WeatherViewModel : ViewModel() {
    val responseWeather: MutableLiveData<WeatherModel> = MutableLiveData()

    fun fetchData() {
        viewModelScope.launch {
            responseWeather.value = Weather.retrofit.getDepokWeather()
        }
    }
}