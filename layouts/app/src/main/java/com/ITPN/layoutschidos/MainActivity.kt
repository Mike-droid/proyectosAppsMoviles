package com.ITPN.layoutschidos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lineal)

        /*val objectIndicatorRefresh = findViewById<SwipeRefreshLayout>(R.id.indicadorRefresh)
        val objectList = findViewById<ListView>(R.id.lstLista)

        //Declarar arreglo y vaciar de string.xml
        val articulo: Array<String> = resources.getStringArray(R.array.productos)

        //Adaptador para llenar el listView
        objectList.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, articulo)

        //Establecer un listener tipo refresh
        objectIndicatorRefresh.setOnRefreshListener {
            val otros: Array<String> = resources.getStringArray(R.array.cosas)
            objectList.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, otros)
            objectIndicatorRefresh.isRefreshing = false
        }*/
    }

    public fun mensaje(v: View){
        Snackbar.make(v,"Mensaje notificación",Snackbar.LENGTH_LONG)
            .setAction("Texto de la acción", View.OnClickListener {
                @Override
                fun onClick(v: View){
                    Log.i("Snackbar","Hubo click en snackbar")
                }
            })
            .setActionTextColor(resources.getColor(R.color.primaryColor))
            .show()
    }
}