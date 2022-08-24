package com.peluqueria.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Ubicacion(
    var id: String,
    val latitud: Double?,
    val longitud: Double?,
    val altura: Double?
) : Parcelable {
    constructor () :
            this("",0.0,0.0,0.0)
}