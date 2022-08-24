package com.peluqueria.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.peluqueria.model.Ubicacion


//Este codigo es para contruir la base de datos, si no existe la contruye y si existe devuelve la referencia a la base de datos.
@Database(entities = [Ubicacion::class], version = 1, exportSchema = false)
abstract class UbicacionDatabase: RoomDatabase() {
    abstract fun ubicacionDao():UbicacionDao

    companion object{
        @Volatile
        private var INSTANCE: UbicacionDatabase?=null

        fun getDatabase(context: android.content.Context):UbicacionDatabase{
            val tempInstance= INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UbicacionDatabase::class.java,
                    "ubicacion_database"
                ).build()
                INSTANCE = instance
                return instance
            }

        }
    }
}