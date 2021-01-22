package com.example.covidautodiagnostico

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Final : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        val intent = intent
        val parametroNombre = intent.getStringExtra("parametroNombre")
        val parametroCorreo = intent.getStringExtra("parametroCorreo")

        val resultado = findViewById<TextView>(R.id.textViewResultado)
        resultado.text = "${parametroNombre} hemos enviado tus resultados a ${parametroCorreo}"
    }
}