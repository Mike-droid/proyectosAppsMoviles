package com.example.covidautodiagnostico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(this,"ON CREATE",Toast.LENGTH_LONG).show()
    }

    fun abrir(v: View){
        val curp = findViewById<EditText>(R.id.editTextCURP)

        if (curp.text.toString().isEmpty()){
            Toast.makeText(this,"El campo de CURP no puede estar vacío",Toast.LENGTH_SHORT).show()
        }else{
            val miIntento = Intent(this,Preguntas::class.java)
            startActivity(miIntento)
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"ON START",Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"ON RESUME",Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"ON PAUSE",Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"ON STOP",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        Toast.makeText(this,"ON DESTROY",Toast.LENGTH_LONG).show()
        super.onDestroy()
    }
}