package com.itpn.usofirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.properties.Delegates

class Persona : AppCompatActivity() {

    private var nombre:String by Delegates.notNull()
    private var edad:Int by Delegates.notNull()
    private var domicilio:String by Delegates.notNull()

    init {
        this.nombre = nombre
        this.edad = edad
        this.domicilio = domicilio
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_persona)
    }

    @JvmName("getNombre1")
    fun getNombre():String{
        return nombre
    }

    @JvmName("setNombre1")
    fun setNombre(nombre:String){
        this.nombre = nombre
    }

    @JvmName("getEdad1")
    fun getEdad():Int{
        return edad
    }

    @JvmName("setEdad1")
    fun setEdad(edad:Int){
        this.edad = edad
    }

    @JvmName("getDomicilio1")
    fun getDomicilio():String{
        return domicilio
    }

    @JvmName("setDomicilio1")
    fun setDomicilio(domicilio:String){
        this.domicilio = domicilio
    }

}