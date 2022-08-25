package com.peluqueria.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "ubicacion")
data class Ubicacion(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    val latitud: Double?,
    val longitud: Double?,
    val altura: Double?
) : Parcelable {
    constructor () :
            this(0,0.0,0.0,0.0)
}