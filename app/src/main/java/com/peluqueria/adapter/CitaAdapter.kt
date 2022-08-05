package com.peluqueria.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.peluqueria.databinding.CitaFilaBinding
import com.peluqueria.model.Cita
import com.peluqueria.ui.Cita.CitaFragment

class CitaAdapter : RecyclerView.Adapter<CitaAdapter.CitaViewHolder>() {

    //Se crea una lista para almacenar las citas
    private var lista = emptyList<Cita>()
    inner class CitaViewHolder(private val itemBinding: CitaFilaBinding) :
            RecyclerView.ViewHolder(itemBinding.root){
    fun dibuja(cita: Cita) {
        itemBinding.tvNombre.text = cita.nombre
        itemBinding.tvCorreo.text = cita.correo
        itemBinding.tvTelefono.text = cita.telefono
        itemBinding.tvFecha.text = cita.fecha.toString()
        itemBinding.tvHora.text = cita.hora
        itemBinding.tvEstilista.text = cita.estilista
        itemBinding.tvMonto.text = cita.monto.toString()
        itemBinding.vistaFila.setOnClickListener{
            val accion = CitaFragmentDirections
                .actionNavLugarToUpdateLugarFragment(cita)
            itemView.findNavController().navigate(accion)
        }



    }
    }

    //Acá se va a crear una "cajita" del reciclador...  una fila... sólo la estructura
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitaViewHolder {
        val itemBinding =
            CitaFilaBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false)
        return CitaViewHolder(itemBinding)
    }
    //Acá se va a solicitar "dibujar" una cajita, según el elemento de la lista...
    override fun onBindViewHolder(holder: CitaViewHolder, position: Int) {
        val cita = lista[position]
        holder.dibuja(cita)
    }
    override fun getItemCount(): Int {
        return lista.size
    }

    fun setData(citas: List<Cita>) {
        lista = citas
        notifyDataSetChanged()
    }

}