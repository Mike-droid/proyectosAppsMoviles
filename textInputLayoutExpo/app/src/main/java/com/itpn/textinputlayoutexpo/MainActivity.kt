package com.itpn.textinputlayoutexpo

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

        val password = "android"
        val etPassWord: EditText = findViewById(R.id.etPassword)

        if (password.equals(etPassWord.text.toString())){
            val intento:Intent = Intent(this, UserMainPage::class.java)
            val etUserName: EditText = findViewById(R.id.etUsername)
            val mensaje:String = etUserName.text.toString()
            intento.putExtra("parametroUserName", mensaje)
            startActivity(intento)
        }else{
            Toast.makeText(this,"Contraseña o Username incorrecto",Toast.LENGTH_SHORT).show()
        }
    }
}