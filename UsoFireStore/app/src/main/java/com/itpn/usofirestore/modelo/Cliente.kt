package com.itpn.usofirestore.modelo

import kotlin.properties.Delegates

class Cliente {
    lateinit var nombre:String
    lateinit var apellido:String
    var nacido by Delegates.notNull<Int>()

    constructor(nombre: String, apellido: String, nacido: Int) {
        this.nombre = nombre
        this.apellido = apellido
        this.nacido = nacido
    }

    init {
        nombre = ""
        apellido = ""
        nacido = 0
    }

}