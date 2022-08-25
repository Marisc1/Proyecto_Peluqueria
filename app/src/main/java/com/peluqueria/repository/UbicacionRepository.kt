package com.peluqueria.repository

import androidx.lifecycle.LiveData
import com.peluqueria.data.UbicacionDao
import com.peluqueria.model.Ubicacion

class UbicacionRepository (private val ubicacionDao: UbicacionDao) {
    val getAllData: LiveData<List<Ubicacion>> = ubicacionDao.getAllData()

    suspend fun addUbicacion (ubicacion: Ubicacion){
        ubicacionDao.addUbicacion(ubicacion)
    }

}