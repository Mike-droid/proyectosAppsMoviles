package com.itpn.usofirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class MainActivity : AppCompatActivity() {

    lateinit var mAuth:FirebaseAuth
    lateinit var correo:EditText
    lateinit var contrasenia:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mAuth = FirebaseAuth.getInstance()
    }

    override fun onStart() {
        super.onStart()
        var currentUser: FirebaseUser? = mAuth.currentUser
        //updateUI(currentUser)
    }

    fun registrarUsuario(v:View){
        val intent = Intent(this,Registrar::class.java)
        startActivity(intent)
    }

    fun iniciar(v:View){
        correo = findViewById(R.id.textoCorreo)
        contrasenia = findViewById(R.id.textoContrasena)
        mAuth.signInWithEmailAndPassword(correo.text.toString(), contrasenia.text.toString())
            .addOnCompleteListener(this, OnCompleteListener { task: Task<AuthResult> ->
                if (task.isSuccessful){
                    //Toast.makeText(this,"Autenticación EXITOSA",Toast.LENGTH_LONG).show()
                    val user: FirebaseUser? = mAuth.currentUser
                    val intent = Intent(this,Principal::class.java)
                    startActivity(intent)
                    //Contrasñea para mikes.rock.lol101@gmailcom = megustaleer
                }else{
                    Toast.makeText(this,"Autenticación fallida :(",Toast.LENGTH_LONG).show()
                }
            })
    }

}