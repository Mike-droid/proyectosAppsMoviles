package com.example.covidautodiagnostico

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox

class Sintomas : AppCompatActivity() {

    var puntos: Int = 0
    var mensaje:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sintomas)
    }

    fun calculaPuntos(v: View){
        val checkBoxFiebre:CheckBox = findViewById(R.id.checkBoxFiebre)
        val checkBoxCabeza:CheckBox = findViewById(R.id.checkBoxHeadhache)
        val checkBoxTos:CheckBox = findViewById(R.id.checkBoxTos)
        val checkBoxRespiracion:CheckBox = findViewById(R.id.checkBoxRespiracion)
        val checkBoxDolorCuerpo:CheckBox = findViewById(R.id.checkBoxDolorCuerpo)
        val checkBoxCondicionFisica:CheckBox = findViewById(R.id.checkBoxCondicionFisica)
        val checkBoxViajar:CheckBox = findViewById(R.id.checkBoxViajar)
        val checkBoxContacto:CheckBox = findViewById(R.id.checkBoxContacto)

        if (checkBoxFiebre.isChecked){
            puntos+=1
        }
        if(checkBoxCabeza.isChecked){
            puntos+=1
        }
        if(checkBoxTos.isChecked){
            puntos+=1
        }
        if(checkBoxRespiracion.isChecked){
            puntos+=1
        }
        if(checkBoxDolorCuerpo.isChecked){
            puntos+=1
        }
        if(checkBoxCondicionFisica.isChecked){
            puntos+=1
        }
        if(checkBoxViajar.isChecked){
            puntos+=1
        }
        if(checkBoxContacto.isChecked){
            puntos+=1
        }

        if (puntos == 0){
            mensaje="No te preocupes, no tienes covid, por lo pronto quédate en casa."
            puntos=0
        }else if(puntos>=1 && puntos<=4){
            mensaje="Llama a la línea de covid, es posible que estés infectad@."
            puntos=0
        }else if(puntos>=5){
            mensaje="¡Cuidado! Deberías ir al hospotial, es altamente probable que tengas covid."
            puntos=0
        }

        val miIntento3 = Intent(this,DatosPersonalizados::class.java)
        miIntento3.putExtra("mensaje",mensaje)
        startActivity(miIntento3)
    }
}