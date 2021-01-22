package com.example.holamundo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import org.w3c.dom.Text

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        //Obtener el conjunto de parametros contenido en el intento
        val intent = intent
        val parametro1 = intent.getStringExtra("parametrosNombre")
        val parametro2 = intent.getStringExtra("parametrosCorreo")

        //Crear dos componentes para visualizar lo que llegó como parametro
        val resultadoTv = findViewById<TextView>(R.id.textView3)
        resultadoTv.setTextSize(30.0f)
        resultadoTv.text = "Hola ${parametro1} tu correo es ${parametro2}"

        //Mostrar el textview en el layout
        //setContentView(resultadoTv)
    }
}