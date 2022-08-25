package com.peluqueria.ui.Cita

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController

import com.peluqueria.R
import com.peluqueria.databinding.FragmentAddCitaBinding
import com.peluqueria.databinding.FragmentCitaBinding
import com.peluqueria.model.Cita
import com.peluqueria.viewmodel.CitaViewModel


class AddCitaFragment : Fragment() {
    private var _binding: FragmentAddCitaBinding? = null
    private val binding get() = _binding!!

    private lateinit var citaViewModel: CitaViewModel;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        ViewModelProvider(this).get(CitaViewModel::class.java)
        _binding = FragmentAddCitaBinding.inflate(inflater, container, false)
        binding.btAgregar.setOnClickListener {
            addCita()
        }

        _binding = FragmentAddCitaBinding.inflate(inflater, container, false)


        return binding.root
    }

    private fun addCita() {
        var nombre = binding.etNombre.text.toString()
        if (nombre.isEmpty()) { //Se hace el insert de la cita
            var correo = binding.etCorreo.text.toString()
            var telefono = binding.etTelefono.text.toString()
            var fecha = binding.etFecha.text.toString()
            var hora = binding.etHoraCita.text.toString()
            var estilista = binding.etEstilista.toString()
            var monto = binding.etMonto.toString()
            val cita = Cita(0, nombre, correo, telefono, 0, hora, estilista, 0)

            citaViewModel.saveCita(cita)
            Toast.makeText(requireContext(), getString(R.string.msg_cita_added), Toast.LENGTH_LONG)
                .show()
            findNavController().navigate(R.id.action_addCitaFragment_to_nav_cita)
        } else { // Mensaje de error
            Toast.makeText(requireContext(), getString(R.string.msg_data), Toast.LENGTH_SHORT)
                .show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

