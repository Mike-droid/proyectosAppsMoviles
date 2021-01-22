package com.itpn.variosenuno

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

    fun access(v: View){
        val username : EditText = findViewById(R.id.etUsername)
        val password = "android"
        val etPassWord: EditText = findViewById(R.id.etPassword)

        if (password.equals(etPassWord.text.toString())){
            val intento: Intent = Intent(this, UserMainPage::class.java)
            val etUserName: EditText = findViewById(R.id.etUsername)
            val message:String = etUserName.text.toString()
            intento.putExtra("parametroUserName", message)
            Toast.makeText(this,"Welcome ${username.text.toString()}",Toast.LENGTH_SHORT).show()
            startActivity(intento)
        }else{
            Toast.makeText(this,"Password or Username incorrect",Toast.LENGTH_SHORT).show()
        }
    }

}