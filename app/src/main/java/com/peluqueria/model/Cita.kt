package com.peluqueria.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.parcelize.Parcelize
 import androidx.room.PrimaryKey
@Parcelize
@Entity(tableName = "cita")
data class Cita(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre")
    val nombre: String,
    @ColumnInfo(name = "correo")
    val correo: String?,
    @ColumnInfo(name = "telefono")
    val telefono: String,
    @ColumnInfo(name = "fecha")
    val fecha: Int,
    @ColumnInfo(name = "hora")
    val hora: String,
    @ColumnInfo(name = "estilista")
    val estilista: String,
    @ColumnInfo(name = "monto")
    val monto: Int,
) : Parcelable
