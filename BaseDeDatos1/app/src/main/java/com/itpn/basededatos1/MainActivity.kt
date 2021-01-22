package com.itpn.basededatos1

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var c : Conexion
    lateinit var edtNombre : EditText //= findViewById(R.id.edtNombre)
    lateinit var edtControl : EditText //= findViewById(R.id.edtControl)
    lateinit var cajaNombre:String //= edtNombre.text.toString()
    lateinit var cajaControl:String //= edtControl.text.toString()
    lateinit var tvComando:TextView //= findViewById(R.id.textView1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.principal)

        c = Conexion(this,"Escolar",null,1)
    }

    fun insertar(v:View){

        val op : SQLiteDatabase = c.writableDatabase
        /*
        op.execSQL("INSERT INTO alumno(id,nombre) VALUES(1,'Miguel Ángel')")
        op.close()
        */

        //Otra forma de insertar datos
        //val cv : ContentValues = ContentValues()
        //cv.put("id",87)
        //cv.put("nombre","Juan Diego")
        //op.insert("alumno",null,cv)

        edtNombre = findViewById(R.id.edtNombre)
        edtControl = findViewById(R.id.edtControl)
        cajaNombre = edtNombre.text.toString()
        cajaControl = edtControl.text.toString()

        tvComando = findViewById(R.id.textView1)

        val instruccion:String = "INSERT INTO alumno VALUES ('$cajaControl' , '$cajaNombre')"
        tvComando.setText(instruccion)

        op.execSQL(instruccion)
        op.close()
        Toast.makeText(this,"Se ha insertado el registro",Toast.LENGTH_SHORT).show()
    }

    fun consultar(v:View){
        //Los cursores son objetos que almacenan el resultado de una consulta
        val op:SQLiteDatabase = c.readableDatabase
        val cursor:Cursor = op.rawQuery("SELECT * FROM alumno",null)
        var resultado:String = ""
        if (cursor.moveToFirst()){
            do {
                resultado += "${cursor.getString(0)} , ${cursor.getString(1)} - "
            }while (cursor.moveToNext())
        }
        Toast.makeText(this,resultado,Toast.LENGTH_LONG).show()
        op.close()
    }

    fun actualizar(v:View){
        val op : SQLiteDatabase = c.writableDatabase
        op.execSQL("UPDATE alumno SET nombre = 'William' WHERE nombre='Miguel Ángel'")
        op.close()
        Toast.makeText(this,"Registro modificado",Toast.LENGTH_LONG).show()
    }

    fun borrar(v:View){
        val op : SQLiteDatabase = c.writableDatabase
        op.execSQL("DELETE FROM alumno WHERE nombre = 'Miguel Ángel'")
        op.close()
        Toast.makeText(this,"Registro eliminado",Toast.LENGTH_LONG).show()
    }
}