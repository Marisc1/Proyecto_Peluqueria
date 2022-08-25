package com.peluqueria.repository

import androidx.lifecycle.LiveData
import com.peluqueria.data.CitaDao
import com.peluqueria.model.Cita

class CitaRepository (private val citaDao: CitaDao) {
    val getAllData: LiveData<List<Cita>> = citaDao.getAllData()

    suspend fun addCita (cita: Cita){
citaDao.addCita(cita)
    }
    suspend fun updateCita (cita: Cita){
        citaDao.updateCita(cita)
    }
    suspend fun deleteCita (cita: Cita){
        citaDao.deleteCita(cita)
    }
}