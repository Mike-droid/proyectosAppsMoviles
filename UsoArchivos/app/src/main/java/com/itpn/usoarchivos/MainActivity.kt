package com.itpn.usoarchivos

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.File
import java.io.FileOutputStream
import java.io.FileReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun almacenarAchivo(v:View){
        try {
            val edName:EditText = findViewById(R.id.edNombre)
            val nombre:String = edName.text.toString()
            //Manejo del archivo
            //val outputstream : FileOutputStream? = openFileOutput("ArchivoTexto.txt" , Context.MODE_APPEND) //Agrega el texto nuevo
            val outputstream : FileOutputStream? = openFileOutput("ArchivoTexto.txt" , Context.MODE_PRIVATE) //Sobre escribe el texto
            if (outputstream != null) {
                outputstream.write(nombre.toByteArray())
                outputstream.close()
            }
            Toast.makeText(this,"Información almacenada", Toast.LENGTH_LONG).show()
            edName.setText("")
        } catch (e:Exception){
            Toast.makeText(this,"Error al almacenar",Toast.LENGTH_LONG).show()
        }
    }

    fun recuperarArchivo(v:View){
        val caja:EditText = findViewById(R.id.edContenido)
        //Modo fijo
        //val direccion:File = File("/data/data/com.itpn.usoarchivos/files/ArchivoTexto.txt")
        val direccion:File = File(this.filesDir.path + "/ArchivoTexto.txt")
        try {
            val reader:BufferedReader = BufferedReader(FileReader(direccion))
            var linea:String = reader.readLine()
            while (!linea.equals(null)){
                caja.append(linea)
                linea = reader.readLine()
                Toast.makeText(this,"Contenido mostrado",Toast.LENGTH_LONG).show()
            }
        }catch (e:Exception){

        }
    }

    fun guardarPreferencia(v:View){
        val miPreferencia:SharedPreferences = getSharedPreferences("MisPreferencias" , MODE_PRIVATE)
        val editor:SharedPreferences.Editor = miPreferencia.edit()
        val edName:EditText = findViewById(R.id.edNombre)
        val edCorreo:EditText = findViewById(R.id.edEmail)
        val nombre:String = edName.text.toString()
        val correo:String = edCorreo.text.toString()

        editor.putString("varNombre",nombre)
        editor.putString("varCorreo",correo)
        editor.commit()
        Toast.makeText(this,"Preferencia almacenada",Toast.LENGTH_LONG).show()
        edName.setText("")
        edCorreo.setText("")
    }

    fun mostrarPreferencia(v:View){
        val preferences:SharedPreferences = getSharedPreferences("MisPreferencias", MODE_PRIVATE)
        val nombreRecuperado:String? = preferences.getString("varNombre","Nombre no encontrado")
        val correoRecuperado:String? = preferences.getString("varCorreo", "Correo no encontrado")
        val edContenido:EditText = findViewById(R.id.edContenido)
        edContenido.setText("Nombre: $nombreRecuperado, Correo: $correoRecuperado")
    }
}