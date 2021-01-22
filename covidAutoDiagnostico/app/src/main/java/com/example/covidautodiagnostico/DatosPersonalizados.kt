package com.example.covidautodiagnostico

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class DatosPersonalizados : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_personalizados)

        val intento = intent
        val mensaje:String = intento.getStringExtra("mensaje")
        val resultado = Toast.makeText(this,mensaje,Toast.LENGTH_LONG).show()

    }

    fun enviar(v: View){
        val correo = findViewById<EditText>(R.id.editTextEmail)
        val nombre = findViewById<EditText>(R.id.nombrePersona)
        val telefono = findViewById<EditText>(R.id.editTextPhone)

        if (correo.text.toString().isEmpty() || nombre.text.toString().isEmpty() || telefono.text.toString().isEmpty()){
            Toast.makeText(this,"Ningun campo debe estar vacío",Toast.LENGTH_SHORT).show()
        }else{
            val audio = MediaPlayer.create(this, R.raw.heart)
            audio.start()
            val intento4 = Intent(this,Final::class.java)

            val editTextoNombre:TextView = findViewById(R.id.nombrePersona)
            val mensaje1:String = editTextoNombre.text.toString()
            intento4.putExtra("parametroNombre",mensaje1)

            val editTextoCorreo:TextView = findViewById(R.id.editTextEmail)
            val mensaje2:String = editTextoCorreo.text.toString()
            intento4.putExtra("parametroCorreo",mensaje2)

            startActivity(intento4)
        }
    }
}