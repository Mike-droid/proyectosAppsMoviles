package com.itpn.usorecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var contacto : ArrayList<Contacto> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listaContactos : RecyclerView = findViewById(R.id.rvContactos)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        listaContactos.layoutManager = linearLayoutManager
        llenarLista()
        val adaptador = ContactoAdaptador(contacto)
        listaContactos.adapter = adaptador
    }

    fun llenarLista(){
        contacto.add(Contacto(R.drawable.ic_baseline_emoji_people_24,"Miguel Ángel","8787908628","miguelreyesmoreno@hotmail.com"))
        contacto.add(Contacto(R.drawable.ic_baseline_emoji_people_24,"Daniel Hernández","8787000951","daniel@hotmail.com"))
        contacto.add(Contacto(R.drawable.ic_baseline_emoji_people_24,"Christian Nielsen","4521229620","calisthenics@hotmail.com"))
        contacto.add(Contacto(R.drawable.ic_baseline_emoji_people_24,"Elsa Morano","8781154800","elsa@hotmail.com"))
        contacto.add(Contacto(R.drawable.ic_baseline_emoji_people_24,"Jose Ángel","8781194310","jose@hotmail.com"))
    }
}