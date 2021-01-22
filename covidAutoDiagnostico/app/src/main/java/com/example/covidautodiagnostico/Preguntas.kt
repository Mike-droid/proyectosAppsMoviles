package com.example.covidautodiagnostico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

class Preguntas : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preguntas)
    }

    public fun abrir2(v: View){
        val edad = findViewById<EditText>(R.id.edadForm)
        if (edad.text.toString().isEmpty()){
            Toast.makeText(this,"El campo de edad no puede estar vacío",Toast.LENGTH_SHORT).show()
        }else{
            val miIntento2 = Intent(this,Sintomas::class.java)
            startActivity(miIntento2)
        }

    }

}