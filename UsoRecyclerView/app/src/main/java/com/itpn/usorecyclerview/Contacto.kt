package com.itpn.usorecyclerview

class Contacto {
    var imagen:Int = 0
    var nombre:String = ""
    var telefono:String = ""
    var email:String = ""

    constructor(imagen: Int, nombre: String, telefono: String, email: String) {
        this.imagen = imagen
        this.nombre = nombre
        this.telefono = telefono
        this.email = email
    }
}