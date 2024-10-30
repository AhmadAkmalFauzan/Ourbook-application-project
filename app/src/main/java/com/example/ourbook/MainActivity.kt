package com.example.ourbook

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val Duration: Long = 3000

        Handler().postDelayed({
            val intent = Intent(this@MainActivity, Utama::class.java)
            startActivity(intent)
            finish()
        }, Duration)


    }
}