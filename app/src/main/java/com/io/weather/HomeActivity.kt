package com.io.weather

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import com.io.weather.viewmodel.WeatherViewModel

class HomeActivity: AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        val bundle: Bundle? = intent.extras
//        val username = bundle?.getString("username")
//        val locationManager: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        Get City
        val weatherVM = ViewModelProvider(this)[WeatherViewModel::class.java]
        weatherVM.fetchData()
//        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1)
//        } else {
//            val location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
//            val cityName = findViewById<TextView>(R.id.text_city)
//            cityName.text= "City: " + location?.latitude.toString() + " " + location?.longitude.toString()
//        }
        weatherVM.responseWeather.observe(this) {
            Log.d("HomeActivity", it.toString())
            val weather = findViewById<TextView>(R.id.text_city)
            weather.text = "Weather: " + it.current.condition.text

            val temp = findViewById<TextView>(R.id.text_temp)
            temp.text = "Temperature: " + it.current.temp_c.toString() + "°C"

        }

    }
}