package com.itpn.usorecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import java.util.*

class ContactoAdaptador(var contactos: ArrayList<Contacto>): Adapter<ContactoAdaptador.ContactoViewHolder>() {

    inner class ContactoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //Declaración de los objetos del mismo tipo que los views contenidos en CardView
        val imageViewTarjeta:ImageView
        val textViewTarjetaNombre:TextView
        val textViewTarjetaTelefono:TextView
        val textViewTarjetaCorreo:TextView

        init {
            imageViewTarjeta = itemView.findViewById<View>(R.id.ivImagen) as ImageView
            textViewTarjetaNombre = itemView.findViewById<View>(R.id.tvNombre) as TextView
            textViewTarjetaTelefono = itemView.findViewById<View>(R.id.tvTelefono) as TextView
            textViewTarjetaCorreo = itemView.findViewById<View>(R.id.tvCorreo) as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val v:View = LayoutInflater.from(parent.context).inflate(R.layout.activity_lista_contactos,parent,false)
        return ContactoViewHolder(v)
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        val contacto = contactos[position]
        holder.imageViewTarjeta.setImageResource(contacto.imagen)
        holder.textViewTarjetaNombre.text = contacto.nombre
        holder.textViewTarjetaCorreo.text = contacto.email
        holder.textViewTarjetaTelefono.text = contacto.telefono
    }

    override fun getItemCount(): Int {
        return contactos.size
    }
}