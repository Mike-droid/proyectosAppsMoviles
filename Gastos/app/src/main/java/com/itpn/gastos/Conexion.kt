package com.itpn.gastos

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Conexion (
        context: Context?,
        name: String?,
        factory: SQLiteDatabase.CursorFactory?,
        version: Int
):SQLiteOpenHelper(context, name, factory, version){
    override fun onCreate(p0: SQLiteDatabase?) {
        if (p0 != null){
            p0.execSQL("CREATE TABLE GASTOS(id INTEGER, ingreso FLOAT, fuente VARCHAR, gasto FLOAT, usadoen VARCHAR, fecha VARCHAR)")
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

}