package com.peluqueria.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.peluqueria.databinding.CitaFilaBinding
import com.peluqueria.model.Cita

class CitaAdapter : RecyclerView.Adapter<CitaAdapter.CitaViewHolder>() {

    inner class CitaViewHolder(private val itemBinding: CitaFilaBinding) :
            RecyclerView.ViewHolder(itemBinding.root)
    fun bind(cita: Cita){
        itemBinding.tvTelefono.text
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitaViewHolder {
        TODO("Not yet implemented")
    }
}