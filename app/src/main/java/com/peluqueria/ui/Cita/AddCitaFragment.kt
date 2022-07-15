package com.peluqueria.ui.Cita

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import com.peluqueria.databinding.FragmentAddCitaBinding
import com.peluqueria.databinding.FragmentCitaBinding
import com.peluqueria.model.Cita
import com.peluqueria.viewmodel.CitaViewModel


class AddCitaFragment : Fragment() {
    private var _binding: FragmentAddCitaBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddCitaBinding.inflate(inflater,container,false)

        return binding.root
    }
    private fun addCita(){
        var nombre = binding.etNombre.text.toString()
        if (nombre.isEmpty()) //Se hace el insert de la cita
            var correo = binding.etCorreo.text.toString()
            var telefono = binding.etTelefono.text.toString()
            var fecha = binding.etFecha.text.toString()
        var hora = binding.etHoraCita.text.toString()
        var estilista = binding.etEstilista.toString()
        var monto = binding.etMonto.toString()
        val cita = Cita(0,nombre,correo,telefono,0,hora,estilista,0)
        citaViewModel.addCita(cita)
        makeText(requireContext(),"Cita agregada", LENGTH_SHORT).show()
    }else{
        makeText(requireContext(),"Faltan datos ", LENGTH_SHORT).show()
    }
    findNavController().navigate(R.id.action_addCitaFragment_to_nav_cita)
}

    /*companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddCitaFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddCitaFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}