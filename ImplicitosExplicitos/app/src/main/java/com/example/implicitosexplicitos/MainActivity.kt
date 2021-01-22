package com.example.implicitosexplicitos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_detalle.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    val listaContactos = ArrayList<Contacto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaContactos.add(Contacto("Miguel","8787908628","miguelreyesmoreno@hotmail.com"))
        listaContactos.add(Contacto("Daniel","8787000951","daniel@gmail.com"))
        listaContactos.add(Contacto("Arlin","16121417535","arlin@gmail.com"))
        listaContactos.add(Contacto("Elsa","8781154800","elsa@gmail.com"))

        //Pasar la lista de contactos a otro ArrayList que tenga solo los nombres de los contactos
        val listaNombres:ArrayList<String> = ArrayList()

        //For para recorrer el array list
        for (contacto in listaContactos){
            listaNombres.add(contacto.nombre)
        }

        val lstContactos:ListView = findViewById(R.id.listaContactos)
        lstContactos.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listaNombres)

        lstContactos.setOnItemClickListener(AdapterView.OnItemClickListener()
        { _: AdapterView<*>, _: View, i: Int, l: Long ->
            val intent = Intent(this, Detalle::class.java)
            intent.putExtra("nombre", listaContactos[i].nombre)
            intent.putExtra("telefono", listaContactos[i].telefono)
            intent.putExtra("email", listaContactos[i].email)
            startActivity(intent)
            finish()
        })
    }
}