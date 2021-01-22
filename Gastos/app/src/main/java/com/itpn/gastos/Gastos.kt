package com.itpn.gastos

class Gastos {
    var id:Int = 1
    var ingreso:Float= 1.0f
    var fuente:String = ""
    var gasto:Float = 1.0f
    var usadoEn:String = ""
    var fecha:String = ""

    constructor(id:Int,ingreso:Float,fuente:String,gasto:Float,usadoEn:String,fecha:String){
        this.id = id
        this.ingreso = ingreso
        this.fuente = fuente
        this.gasto = gasto
        this.usadoEn = usadoEn
        this.fecha = fecha
    }
}