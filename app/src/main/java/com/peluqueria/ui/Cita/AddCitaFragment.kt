package com.peluqueria.ui.Cita

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.peluqueria.R
import com.peluqueria.databinding.FragmentAddCitaBinding
import com.peluqueria.databinding.FragmentCitaBinding
import com.peluqueria.databinding.FragmentUpdateCitaBinding
import com.peluqueria.model.Cita
import com.peluqueria.viewmodel.CitaViewModel


class AddCitaFragment : Fragment() {
    private var _binding: FragmentAddCitaBinding? = null
    private val binding get() = _binding!!
    private lateinit var citaViewModel: CitaViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        citaViewModel =
            ViewModelProvider(this)[CitaViewModel::class.java]
        _binding = FragmentAddCitaBinding.inflate(inflater, container, false)
        binding.btAgregar.setOnClickListener {
            addCita()
        }
        return binding.root
    }

    private fun addCita(){
        var nombre = binding.etNombre.text.toString()
        var correo = binding.etCorreo.text.toString()
        var telefono = binding.etTelefono.text.toString()
        var fecha = binding.etFecha.text.toString()
        var hora = binding.etHoraCita.text.toString()
        var estilista = binding.etEstilista.toString()
        var monto = binding.etMonto.toString()
        if (nombre.isNotEmpty()) { //Si puedo agregar una cita
            val cita= Cita(id,nombre, correo,telefono,fecha,hora,estilista,monto)
            citaViewModel.addCita(cita)
            Toast.makeText(requireContext(),"Cita agregada exitosamente", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addCitaFragment_to_nav_cita)
        } else {  //Mensaje de error...
            Toast.makeText(requireContext(),"Faltan datos por ingresar ", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }