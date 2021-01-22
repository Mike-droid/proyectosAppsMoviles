package com.itpn.usofirebase

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

class Registrar : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth
    lateinit var edMail : EditText
    lateinit var edPassword1 : EditText
    lateinit var edPassword2 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser
    }

    fun almacenarUsuario(v:View){
        edMail = findViewById(R.id.edEmail)
        edPassword1 = findViewById(R.id.edPassword)
        edPassword2 = findViewById(R.id.edPassword2)

        if (edPassword1.text.toString() == edPassword2.text.toString()){
            mAuth.createUserWithEmailAndPassword(edMail.text.toString(),edPassword1.text.toString())
                .addOnCompleteListener(this, OnCompleteListener { task: Task<AuthResult> ->
                    if (task.isSuccessful){
                        val user = mAuth.currentUser
                        Toast.makeText(applicationContext,"Usuario registrado exitosamente",Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(applicationContext,"Usuario no registrado",Toast.LENGTH_LONG).show()
                    }
                })
        }else{
            Toast.makeText(applicationContext,"Las contraseñas deben coindidir",Toast.LENGTH_LONG).show()
        }

    }
}