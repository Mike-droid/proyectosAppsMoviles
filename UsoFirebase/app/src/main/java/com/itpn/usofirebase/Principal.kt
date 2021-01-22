package com.itpn.usofirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Principal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
    }

    fun abrirProductos(v: View){
        val intent = Intent(this,Productos::class.java)
        startActivity(intent)
    }

    fun abrirClientes(v: View){
        val intent = Intent(this,Clientes::class.java)
        startActivity(intent)
    }

    fun abrirVentas(v: View){
        val intent = Intent(this,Ventas::class.java)
        startActivity(intent)
    }
}