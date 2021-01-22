package com.itpn.usowebview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun verWebView(v:View){
        val intent = Intent(this,MainActivity2::class.java)
        startActivity(intent)
    }

    fun verMapa(v:View){
        val intent = Intent(this,MapsActivity::class.java)
        startActivity(intent)
    }
}