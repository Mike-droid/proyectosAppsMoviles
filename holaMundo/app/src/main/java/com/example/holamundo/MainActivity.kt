package com.example.holamundo

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    public fun internet(v: View){
        val miIntento = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
        startActivity(miIntento)
    }

    public fun contactos(v: View){
        val miIntento2 = Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"))
        startActivity(miIntento2)
    }

    public fun abrir(v: View){
        val miIntento3 = Intent(this, MainActivity2::class.java)
        startActivity(miIntento3)
    }

}