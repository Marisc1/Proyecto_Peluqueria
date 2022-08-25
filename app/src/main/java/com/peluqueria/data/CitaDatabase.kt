package com.peluqueria.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.peluqueria.model.Cita

//Este codigo es para contruir la base de datos, si no existe la contruye y si existe devuelve la referencia a la base de datos.
@Database(entities = [Cita::class], version = 1, exportSchema = false)
abstract class CitaDatabase: RoomDatabase() {
    abstract fun citaDao():CitaDao

    companion object{
        @Volatile
        private var INSTANCE: CitaDatabase?=null

        fun getDatabase(context: android.content.Context):CitaDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CitaDatabase::class.java,
                    "cita_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}