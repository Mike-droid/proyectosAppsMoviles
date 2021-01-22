package com.itpn.gastos

import android.content.Context
import android.content.SharedPreferences
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedReader
import java.io.File
import java.io.FileOutputStream
import java.io.FileReader
import java.lang.Exception
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class Activity2 : AppCompatActivity() {

    var gasto: ArrayList<Gastos> = ArrayList()

    lateinit var c : Conexion
    lateinit var campoID : EditText
    lateinit var campoIngreso : EditText
    lateinit var campoFuente : EditText
    lateinit var campoGasto : EditText
    lateinit var campoUsado : EditText
    lateinit var campoFecha : EditText
    lateinit var nombreUsuario:String
    lateinit var misPreferencias:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)
        val listaGastos : RecyclerView = findViewById(R.id.rvGastos)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        listaGastos.layoutManager = linearLayoutManager
        val adaptador = GastosAdaptador(gasto)
        listaGastos.adapter = adaptador

        c = Conexion(this,"Finanzas",null,1)

        campoID = findViewById(R.id.edID)
        campoIngreso = findViewById(R.id.edIngreso)
        campoFuente = findViewById(R.id.edFuente)
        campoGasto = findViewById(R.id.edGasto)
        campoUsado = findViewById(R.id.edGastadoEn)
        campoFecha = findViewById(R.id.edFecha)

    }

    fun insertarDato(v: View){
        val op: SQLiteDatabase = c.writableDatabase

        val instruccion = "INSERT INTO GASTOS VALUES ('${campoID.text}','${campoIngreso.text}','${campoFuente.text}','${campoGasto.text}','${campoUsado.text}','${campoFecha.text}')"

        op.execSQL(instruccion)
        op.close()
        Toast.makeText(this,"Se ha insertado el registro",Toast.LENGTH_SHORT).show()
        gasto.add(Gastos(campoID.text.toString().toInt(),campoIngreso.text.toString().toFloat(),campoFuente.text.toString(),campoGasto.text.toString().toFloat(),campoUsado.text.toString(),campoFecha.text.toString()))
    }

    fun eliminarDato(v: View){
        val op: SQLiteDatabase = c.writableDatabase
        op.execSQL("DELETE FROM gastos WHERE id = '${campoID.text}'")
        op.close()
        Toast.makeText(this,"Registro eliminado", Toast.LENGTH_LONG).show()
    }

    fun consultarDatos(v: View){
        val op:SQLiteDatabase = c.readableDatabase
        val cursor:Cursor = op.rawQuery("SELECT * FROM gastos",null)
        var resultado = ""
        if (cursor.moveToFirst()){
            do {
                resultado += "${cursor.getString(0)} , ${cursor.getString(1)}, ${cursor.getString(2)}, ${cursor.getString(3)}, ${cursor.getString(4)}, ${cursor.getString(5)} -- "
            }while (cursor.moveToNext())
        }
        Toast.makeText(this,resultado,Toast.LENGTH_LONG).show()
        op.close()
    }

    fun actualizarDato(v: View){
        val op : SQLiteDatabase = c.writableDatabase
        op.execSQL("UPDATE GASTOS SET ingreso = '${campoIngreso.text}' , fuente = '${campoFuente.text}' , gasto = '${campoGasto.text}' , usadoen = '${campoUsado.text}', fecha = '${campoFecha.text}' WHERE id = '${campoID.text}' ")
        op.close()
        Toast.makeText(this,"Registro actualizado", Toast.LENGTH_LONG).show()
    }

    fun guardarArchivo(v:View){
        try {
            val nombreTrans:EditText = findViewById(R.id.NombreTrans)
            val comentarios:EditText = findViewById(R.id.comentarios)
            val outPutStream : FileOutputStream? = openFileOutput("${nombreTrans.text}.txt", Context.MODE_APPEND)
            if (outPutStream != null){
                outPutStream.write("Comentarios: ".toByteArray())
                outPutStream.write(comentarios.text.toString().toByteArray())
                outPutStream.write("\n".toByteArray())

                outPutStream.write("ID Transacción: ".toByteArray())
                outPutStream.write(campoID.text.toString().toByteArray())
                outPutStream.write("\n".toByteArray())
            }
            Toast.makeText(this,"Información almacenada en archivo de texto", Toast.LENGTH_LONG).show()
            nombreTrans.setText("")
            comentarios.setText("")
        } catch (e:Exception){
            Toast.makeText(this,"Error al almacenar",Toast.LENGTH_LONG).show()
        }
    }

    fun verContenido(v:View){
        val caja:TextView = findViewById(R.id.tvTextoPreferencia)
        val nombreTrans:EditText = findViewById(R.id.NombreTrans)
        val path:String = "/data/data/com.itpn.gastos/files/"
        val direccion:File = File("${path}${nombreTrans.text}")
        try {
            val reader:BufferedReader = BufferedReader(FileReader(direccion))
            var linea:String = reader.readLine()
            while (!linea.equals((null))){
                caja.append(linea)
                linea = reader.readLine()
                Toast.makeText(this,"Contenido mostrado",Toast.LENGTH_LONG).show()
            }
        } catch (e:Exception){
            Toast.makeText(this,"Hubo un error al mostrar el contenido: ${e.message}",Toast.LENGTH_LONG).show()
            println("Hubo un error al mostrar el contenido: ${e.message}")
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun guardarPreferencia(v:View){
        misPreferencias = getSharedPreferences("MisPreferencias", MODE_PRIVATE)
        val editor:SharedPreferences.Editor = misPreferencias.edit()
        nombreUsuario = intent.getStringExtra("nombreUsuario").toString()
        val tiempoActual = LocalTime.now()

        editor.putString("NombreUsuario", nombreUsuario)
        editor.putString("HoraAcceso", tiempoActual.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)))
        editor.commit()
        Toast.makeText(this,"$nombreUsuario, tu preferencia almacenada se guardó con hora de ${tiempoActual.format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM))}", Toast.LENGTH_LONG).show()
    }

    fun mostrarPreferencia(v:View){
        val preferencesSharedPreferences = getSharedPreferences("MisPreferencias", MODE_PRIVATE)
        val nombreRecuperado:String? = preferencesSharedPreferences.getString("NombreUsuario","Nombre no encontrado")
        val horaRecuperada:String? = preferencesSharedPreferences.getString("HoraAcceso","Hora no encontrada")
        val tvPreferencia:TextView = findViewById(R.id.tvTextoPreferencia)
        tvPreferencia.setText("Usuairo: ${nombreRecuperado}, Hora de acceso: ${horaRecuperada}")
    }
}
