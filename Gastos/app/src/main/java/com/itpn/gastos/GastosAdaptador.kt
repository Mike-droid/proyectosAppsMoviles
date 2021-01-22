package com.itpn.gastos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import kotlin.collections.ArrayList

class GastosAdaptador (var gastos: ArrayList<Gastos>): Adapter<GastosAdaptador.GastosViewHolder>(){

    inner class GastosViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val id:TextView
        val tvIngreso:TextView
        val tvFuente:TextView
        val tvGasto:TextView
        val tvUsadoEn:TextView
        val tvFecha:TextView

        init {
            id = itemView.findViewById<View>(R.id.tvID) as TextView
            tvIngreso = itemView.findViewById<View>(R.id.tvINGRESO) as TextView
            tvFuente = itemView.findViewById<View>(R.id.tvFUENTE) as TextView
            tvGasto = itemView.findViewById<View>(R.id.tvGASTO) as TextView
            tvUsadoEn = itemView.findViewById<View>(R.id.tvUSADOEN) as TextView
            tvFecha = itemView.findViewById<View>(R.id.tvFECHA) as TextView
        }
    }

    override fun getItemCount(): Int {
        return gastos.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GastosViewHolder {
        val v:View = LayoutInflater.from(parent.context).inflate(R.layout.lista_transacciones,parent,false)
        return GastosViewHolder(v)
    }

    override fun onBindViewHolder(holder: GastosViewHolder, position: Int) {
        val gasto:Gastos = gastos[position]
        holder.id.text = gasto.id.toString() //Este es integer, tengo duda que funcione esto
        holder.tvIngreso.text = gasto.ingreso.toString() //Este es float, tengo duda de que funcione
        holder.tvFuente.text = gasto.fuente
        holder.tvGasto.text = gasto.gasto.toString() //Este es float, tengo duda de que funcione
        holder.tvUsadoEn.text = gasto.usadoEn
        holder.tvFecha.text = gasto.fecha
    }
}