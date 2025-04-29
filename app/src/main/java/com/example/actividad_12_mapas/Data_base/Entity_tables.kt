package com.example.actividad_12_mapas.Data_base

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Direcciones")
data class Direccion(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val direccion: String, // Nombre que se guarda la dirrecion
    val tipo: String, // "Casa" o "Negocio"
    val latitud: Double,
    val longitud: Double,
)