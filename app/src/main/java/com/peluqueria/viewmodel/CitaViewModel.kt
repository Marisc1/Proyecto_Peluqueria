package com.peluqueria.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.peluqueria.data.CitaDatabase
import com.peluqueria.model.Cita
import com.peluqueria.repository.CitaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class  CitaViewModel(application: Application) :  AndroidViewModel(application) {
    val getAllData: LiveData<List<Cita>>

    private val repository: CitaRepository

    init {
        val citaDao= CitaDatabase.getDatabase(application).citaDao()
        repository= CitaRepository(citaDao)
        getAllData= repository.getAllData
    }
    fun saveCita (cita: Cita){
        viewModelScope.launch(Dispatchers.IO){repository.addCita(cita)}
    }
    fun updateCita (cita: Cita){
        viewModelScope.launch(Dispatchers.IO){repository.updateCita(cita)}
    }
    fun deleteCita (cita: Cita){
        viewModelScope.launch(Dispatchers.IO){repository.deleteCita(cita)}
    }
}