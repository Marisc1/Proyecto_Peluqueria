package com.peluqueria.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.peluqueria.databinding.CitaFilaBinding
import com.peluqueria.model.Cita

class CitaAdapter : RecyclerView.Adapter<CitaAdapter.CitaViewHolder>() {

    //Se crea una lista para almacenar las citas
    private var listaCitas = emptyList<Cita>()

    inner class CitaViewHolder(private val itemBinding: CitaFilaBinding) :
            RecyclerView.ViewHolder(itemBinding.root){
    fun bind(cita: Cita) {
        itemBinding.tvNombre.text = cita.telefono
        itemBinding.tvCorreo.text = cita.telefono
        itemBinding.tvTelefono.text = cita.telefono
        itemBinding.tvFecha.text = cita.telefono
        itemBinding.tvHora.text = cita.telefono
        itemBinding.tvEstilista.text = cita.telefono
        itemBinding.tvMonto.text = cita.telefono

    }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitaViewHolder {
       val itemBinding = CitaFilaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CitaViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: CitaViewHolder, position: Int) {
        val citaActual = listaCitas[position]
        holder.bind(citaActual)
    }

    override fun getItemCount(): Int {
        return listaCitas.size
    }
    fun setData (citas: List<Cita>){
        this.listaCitas = citas
        notifyDataSetChanged()
    //Hace que se redibuje la lista


    }
}