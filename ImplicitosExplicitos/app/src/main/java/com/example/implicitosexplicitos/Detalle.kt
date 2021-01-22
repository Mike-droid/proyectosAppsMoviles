package com.example.implicitosexplicitos

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class Detalle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val nombre:String = intent.getStringExtra("nombre")
        val telefono:String = intent.getStringExtra("telefono")
        val email:String = intent.getStringExtra("email")

        val textNombre:TextView = findViewById(R.id.nombre)
        val textTelefono:TextView = findViewById(R.id.telefono)
        val textCorreo:TextView = findViewById(R.id.correo)

        textNombre.text = nombre
        textTelefono.text = telefono
        textCorreo.text = email
    }

    fun call(v: View){
        val phone:String? = intent.getStringExtra("telefono")
        val intentoLlamada = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone")) //Tiene que ser tel para que funcione

        if (intentoLlamada.resolveActivity(packageManager) != null){
            startActivity(intentoLlamada)
        }
    }

    fun enviarMail(v:View){
        val mail:String = intent.getStringExtra("email")
        val TO:Array<String> = arrayOf("")
        TO[0] = mail
        val intentoCorreo = Intent(Intent.ACTION_SEND, Uri.parse("mailto:$mail")) //Tiene que ser mailto para que funcione
        intentoCorreo.putExtra(Intent.EXTRA_EMAIL, TO)
        intentoCorreo.putExtra(Intent.EXTRA_SUBJECT, "Asunto")
        intentoCorreo.putExtra(Intent.EXTRA_TEXT,"Escribe aquí tu mensaje")
        intentoCorreo.type = "message/rfc822"

        try {
            startActivity(Intent.createChooser(intentoCorreo, "Enviando email..."))
            finish() //Para que no se junten tantos activities 
        }catch (ex: android.content.ActivityNotFoundException){
            Toast.makeText(this, "No hay clientes de emails instalados", Toast.LENGTH_SHORT).show()
        }
    }
}