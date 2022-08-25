package com.peluqueria.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.peluqueria.databinding.UbicacionFilaBinding
import com.peluqueria.model.Ubicacion
import com.peluqueria.ui.ubicacion.UbicacionFragmentDirections

class UbicacionAdapter : RecyclerView.Adapter<UbicacionAdapter.UbicacionViewHolder>() {

    //Se crea una lista para almacenar la ubicacion
    private var listaUbicaciones = emptyList<Ubicacion>()

    inner class CitaViewHolder(private val itemBinding: UbicacionFilaBinding) :
        RecyclerView.ViewHolder(itemBinding.root){
        fun dibuja(ubicacion: Ubicacion) {
            itemBinding.tvLatitud.text = ubicacion.latitud
            itemBinding.tvLongitud.text = ubicacion.longitud
            itemBinding.tvAltura.text = ubicacion.altura
            itemBinding.vistaFila.setOnClickListener {
                val accion= UbicacionFragmentDirections
                    .actionNavUbicacionToAddUbicacionFragment(ubicacion)
                itemView.findNavController().navigate(accion)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UbicacionViewHolder {
        val itemBinding = UbicacionFilaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UbicacionViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CitaViewHolder, position: Int) {
        val ubicacionActual = listaUbicaciones[position]
        holder.dibuja(ubicacionActual)
    }

    override fun getItemCount(): Int {
        return listaUbicaciones.size
    }
    fun setData (ubicaciones: List<Ubicacion>){
        this.listaUbicaciones = ubicaciones
        notifyDataSetChanged()
        //Hace que se redibuje la lista


    }
}


