package com.peluqueria.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.peluqueria.model.Ubicacion
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.selects.select


@Dao
    interface UbicacionDao {
//Ayuda con el select
        @Query ("SELECT * FROM UBICACION")
        fun getAllData() :LiveData<List<Ubicacion>>

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun addUbicacion(ubicacion: Ubicacion)

    }
