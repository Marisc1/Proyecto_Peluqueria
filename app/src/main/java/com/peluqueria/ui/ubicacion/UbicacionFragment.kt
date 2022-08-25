package com.peluqueria.ui.ubicacion

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.peluqueria.R
import com.peluqueria.adapter.UbicacionAdapter
import com.peluqueria.databinding.FragmentUbicacionBinding
import com.peluqueria.viewmodel.UbicacionViewModel

class UbicacionFragment : Fragment() {

    private var _binding: FragmentUbicacionBinding? = null
    private val binding get() = _binding!!

    private lateinit var ubicacionViewModel: UbicacionViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        ubicacionViewModel =
            ViewModelProvider(this).get(UbicacionViewModel::class.java)

        _binding = FragmentUbicacionBinding.inflate(inflater, container, false)

        binding.btLocation.setOnClickListener { verMapa() }

        binding.addUbicacion.setOnClickListener{
            findNavController().navigate(R.id.action_nav_Ubicacion_to_addUbicacionFragment)
        }

        //Activar el reciclador...
        val lugarAdapter=UbicacionAdapter()
        val reciclador = binding.reciclador
        reciclador.adapter = ubicacionAdapter
        reciclador.layoutManager = LinearLayoutManager(requireContext())
        ubicacionViewModel.getAllData.observe(viewLifecycleOwner) {
            ubicacionAdapter.setData(it)
        }

        return binding.root
    }

    private fun verMapa() {
        val latitud=binding.tvLatitud.text.toString().toDouble()
        val longitud=binding.tvLongitud.text.toString().toDouble()
        if (latitud.isFinite() && longitud.isFinite()) {
            val location = Uri.parse("geo:$latitud,$longitud?z=18")
            val intent = Intent(Intent.ACTION_VIEW,location)
            startActivity(intent)
        } else {
            Toast.makeText(requireContext(),getString(R.string.msg_datos),
                Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}