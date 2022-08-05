package com.peluqueria.ui.Cita

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.navigation.fragment.findNavController
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.peluqueria.R
import com.peluqueria.databinding.FragmentUpdateCitaBinding
import com.peluqueria.model.Cita
import com.peluqueria.viewmodel.CitaViewModel


class UpdateCitaFragment : Fragment() {

    //Se deciden los parametros pasados por argumento
    private val args by navArgs<UpdateCitaFragmentArgs>()

    private var _binding: FragmentUpdateCitaBinding? = null
    private val binding get() = _binding!!
    private lateinit var citaViewModel: CitaViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        citaViewModel =
            ViewModelProvider(this)[CitaViewModel::class.java]
        _binding = FragmentUpdateCitaBinding.inflate(inflater, container, false)
        binding.etNombre.setText(args.cita.nombre)
        binding.etCorreo.setText(args.cita.correo)
        binding.etTelefono.setText(args.cita.telefono)
        binding.etFecha.setText(args.cita.fecha)
        binding.etHoraCita.setText(args.cita.horaCita)
        binding.etEstilista.setText(args.cita.estilista)
        binding.etMonto.setText(args.cita.monto)
        binding.btActualizar.setOnClickListener {
            updateCita()
        }
        return binding.root
    }

    private fun updateCita(){
            var nombre = binding.etNombre.text.toString()
            var correo = binding.etCorreo.text.toString()
            var telefono = binding.etTelefono.text.toString()
            var fecha = binding.etFecha.text.toString()
            var hora = binding.etHoraCita.text.toString()
            var estilista = binding.etEstilista.toString()
            var monto = binding.etMonto.toString()
        if (nombre.isNotEmpty()) { //Si puedo actualizar una cita
            val cita= Cita(args.cita.id,nombre, correo,telefono,fecha,hora,estilista,monto,)

            citaViewModel.updateCita(cita)

            Toast.makeText(requireContext(),"Cita actualizada", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateCitaFragment_to_nav_cita)
        } else {  //Mensaje de error...
            Toast.makeText(requireContext(),"Faltan datos por ingresar ", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}