package com.example.actividad_12_mapas.Data_base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * Repositorio que proporciona inserción, actualización, eliminación y obtención de [Direccion] desde una fuente de datos.
 */
interface DireccionRepository {

    /**
     * Obtener todas las Direcciones desde la fuente de datos.
     */
    fun getAllDireccionesStream(): Flow<List<Direccion>>

    /**
     * Obtener una Direccion desde la fuente de datos que coincida con el [direccion].
     */
    fun getDireccionStream(direccion: String): Flow<List<Direccion>>

    /**
     * Insertar una direccion en la fuente de datos.
     */
    suspend fun insertDireccion(direccion: Direccion)

    /**
     * Eliminar una direccion de la fuente de datos.
     */
    suspend fun deleteDireccion(direccion: Direccion)

    /**
     * Actualizar una direccion en la fuente de datos.
     */
    suspend fun updateDireccion(direccion: Direccion)
}



class DireccionRepositoryImpl(private val direccionDao: DirrecionDao) : DireccionRepository {

   override fun getAllDireccionesStream(): Flow<List<Direccion>> = flow {
       emit(direccionDao.getAllDirrecion())
   }
    override fun getDireccionStream(direccion: String): Flow<List<Direccion>> = flow {
        emit(direccionDao.getAllDirrecionNombre(direccion))
    }
    override suspend fun insertDireccion(direccion: Direccion) = direccionDao.insertDirrecion(direccion)
    override suspend fun deleteDireccion(direccion: Direccion) = direccionDao.deleteDirrecion(direccion)
    override suspend fun updateDireccion(direccion: Direccion) = direccionDao.updateDirrecion(direccion)
}


