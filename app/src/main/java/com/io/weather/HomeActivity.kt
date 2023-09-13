package com.io.weather

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class HomeActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        val bundle: Bundle? = intent.extras
        val username = bundle?.getString("username")
        val locationManager: LocationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
//        Get City
        val location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        
        val city = location?.latitude.toString() + "," + location?.longitude.toString()
        val cityTextView: TextView = findViewById(R.id.text_city)
        cityTextView.text = city

    }
}