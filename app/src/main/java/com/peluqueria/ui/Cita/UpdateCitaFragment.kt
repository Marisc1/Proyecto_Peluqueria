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
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.peluqueria.R
import com.peluqueria.databinding.FragmentAddCitaBinding
import com.peluqueria.databinding.FragmentCitaBinding
import com.peluqueria.databinding.FragmentUpdateCitaBinding
import com.peluqueria.model.Cita
import com.peluqueria.viewmodel.CitaViewModel


class UpdateCitaFragment : Fragment() {

    //Se reciben parametros pasados por argumentos
    private val args by navArgs<UpdateCitaFragmentArgs>()

    private var _binding: FragmentUpdateCitaBinding? = null
    private val binding get() = _binding!!
    private lateinit var citaViewModel: CitaViewModel;


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ViewModelProvider(this).get(CitaViewModel::class.java)
        _binding = FragmentUpdateCitaBinding.inflate(inflater,container,false)
        //Se coloca la info de la cita en el fragmento.
        binding.etNombre.setText(args.cita.nombre)
        binding.etCorreo.setText(args.cita.correo)
        binding.etTelefono.setText(args.cita.telefono)
        binding.etFecha.setText(args.cita.fecha)
        binding.etHoraCita.setText(args.cita.hora)
        binding.etEstilista.setText(args.cita.estilista)
        binding.etMonto.setText(args.cita.monto)


        binding.btActualizar.setOnClickListener {
            updateCita()
        }

        return binding.root
    }
    private fun updateCita(){
        var nombre = binding.etNombre.text.toString()
        if (nombre.isEmpty()){ //Se hace el insert de la cita
            var correo = binding.etCorreo.text.toString()
            var telefono = binding.etTelefono.text.toString()
            var fecha = binding.etFecha.text.toString()
            var hora = binding.etHoraCita.text.toString()
            var estilista = binding.etEstilista.toString()
            var monto = binding.etMonto.toString()
            val cita = Cita(args.cita.id,nombre,correo,telefono,0,hora,estilista,0)

            citaViewModel.updateCita(cita)

            Toast.makeText(requireContext(),getString(R.string.msg_cita_added),Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_updateCitaFragment_to_nav_cita)
        }else{ // Mensaje de error
            Toast.makeText(requireContext(),getString(R.string.msg_data),Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}