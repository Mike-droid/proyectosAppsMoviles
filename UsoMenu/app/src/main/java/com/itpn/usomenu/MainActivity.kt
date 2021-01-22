package com.itpn.usomenu

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Sólo para el menu contexto
        val textView: TextView = findViewById(R.id.textView)
        registerForContextMenu(textView)
    }

    //Menu de opciones
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.opciones,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intentoRojo = Intent(this,Rojo::class.java)
        val intentoAzul = Intent(this,Azul::class.java)
        when(item.itemId){
            R.id.item1 -> startActivity(intentoRojo)
            R.id.item2 -> startActivity(intentoAzul)
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.contexto,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.itemContexto1 -> Toast.makeText(this,"Presionando el 1",Toast.LENGTH_LONG).show()
            R.id.itemContexto2 -> Toast.makeText(this,"Presionando el 2",Toast.LENGTH_LONG).show()
        }
        return super.onContextItemSelected(item)
    }

    fun menuPopUp(v:View){
        val popupMenu = PopupMenu(this,v)
        popupMenu.menuInflater.inflate(R.menu.popup,popupMenu.menu)
        popupMenu.show()

        //Para que reaccione cuando se elige una opción del menu

        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.puItemH -> Toast.makeText(this, "Hombres", Toast.LENGTH_SHORT).show()
                R.id.puItemM -> Toast.makeText(this, "Mujeres", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }
}