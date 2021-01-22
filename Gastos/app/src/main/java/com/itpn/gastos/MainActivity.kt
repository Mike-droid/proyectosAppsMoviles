package com.itpn.gastos

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
    }

    fun acceder(v: View){
        val campoNombreUsuario:EditText = findViewById(R.id.etUserName)
        val campoContraseña:EditText = findViewById(R.id.etPassword)
        val password:String = "android"

        if (password.equals(campoContraseña.text.toString())){
            val intent:Intent = Intent(this,Activity2::class.java)
            intent.putExtra("nombreUsuario", campoNombreUsuario.text.toString())
            startActivity(intent)
            Toast.makeText(this,"Bienvenido ${campoNombreUsuario.text.toString()}",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(this,"Contraseña o nombre de usuario incorrecto",Toast.LENGTH_LONG).show()
        }
    }
}