package com.io.weather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSignIn: Button = findViewById(R.id.sign_inbtn)
        val usernameInput: EditText = findViewById(R.id.username)
        val passwordInput: EditText = findViewById(R.id.password)
        btnSignIn.setOnClickListener {
//            if(usernameInput.text.isEmpty() || passwordInput.text.isEmpty()) {
//                usernameInput.error = "Please enter username"
//                passwordInput.error = "Please enter password"
//            } else {
//                usernameInput.error = null
//                passwordInput.error = null
//
//            }
            var intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("username", "test dulu")
            startActivity(intent)
        }



    }
}