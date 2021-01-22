package com.example.holamundo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    public fun enviarMensaje(v: View){
        //Crear el intento
        val Intento = Intent(this, MainActivity3::class.java)

        //Vincular los componentes con objetos del mismo tipo
        val editTexto1: TextView = findViewById(R.id.editText1) //nombre Miguel
        val editTexto2: TextView = findViewById(R.id.editText2) //correo blabla@gmail.com

        //Obtener el contenido del componente y guardarlo en una variable
        val mensaje1: String = editTexto1.text.toString()
        val mensaje2: String = editTexto2.text.toString()

        //Asociar los parametros al intento
        Intento.putExtra("parametrosNombre",mensaje1)
        Intento.putExtra("parametrosCorreo",mensaje2)

        //Lanzar el intento
        startActivity(Intento)
    }
}