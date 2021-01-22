package com.itpn.videosplash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed(object : Runnable {
            override fun run() {
                startActivity(Intent(this@MainActivity, MainActivity2::class.java))
                finish()
            }
        }, 5000)
    }
}