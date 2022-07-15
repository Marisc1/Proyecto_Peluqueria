package com.peluqueria.ui.Cita

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.peluqueria.R
import com.peluqueria.databinding.FragmentCitaBinding

import com.peluqueria.viewmodel.CitaViewModel

class CitaFragment : Fragment() {

    private lateinit var citaViewModel: CitaViewModel
    private var _binding: FragmentCitaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val citaViewModel =
            ViewModelProvider(this).get(CitaViewModel::class.java)

        _binding = FragmentCitaBinding.inflate(inflater, container, false)
        binding.fbAgregar.setOnClickListener {
            findNavController().navigate(R.id.action_nav_cita_to_addCitaFragment)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}