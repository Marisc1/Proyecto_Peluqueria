package com.peluqueria.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.peluqueria.model.Cita
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Delete
import kotlinx.coroutines.selects.select


@Dao
    interface CitaDao {
//Ayuda con el select
        @Query ("SELECT*FROM CITA" )
        fun getAllData() :LiveData<List<Cita>>

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun addCita(cita: Cita)

        @Update(onConflict = OnConflictStrategy.IGNORE)
        suspend fun updateCita(cita: Cita)

        @Delete
        suspend fun deleteCita(cita: Cita)

    }
