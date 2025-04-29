package com.example.actividad_12_mapas.Data_base

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface  DirrecionDao {

    // Insertar una nueva Dirreciones
    @Insert
    suspend fun  insertDirrecion( direccion: Direccion)


    // Actualizar un Derreciones
    @Update
    suspend fun updateDirrecion(direccion: Direccion)

    // Eliminar un Dirreciones
    @Delete
    suspend fun deleteDirrecion(direccion: Direccion)

    // Obtener todos los Dirreciones que concidan con el nombre
    @Query("SELECT * FROM Direcciones  WHERE direccion = :direccion")
    suspend fun getAllDirrecionNombre(direccion: String): List<Direccion>


    // Obtener todos los Dirreciones
    @Query("SELECT * FROM Direcciones")
    suspend fun getAllDirrecion(): List<Direccion>


}