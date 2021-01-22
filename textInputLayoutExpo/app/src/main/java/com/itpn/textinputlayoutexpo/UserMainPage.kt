package com.itpn.textinputlayoutexpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserMainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_main_page)

        val intento = intent
        val parametroUserName = intento.getStringExtra("parametroUserName")

        val resultado:TextView = findViewById(R.id.tvResultado)
        resultado.setTextSize(30.0f)
        resultado.text = "Bienvenido ${parametroUserName}"

    }
}