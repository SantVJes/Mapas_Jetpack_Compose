package com.example.actividad_12_mapas.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.actividad_12_mapas.Data_base.Direccion
import com.example.actividad_12_mapas.Data_base.DireccionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class DirrecionesViewModel(private val direccionRepository: DireccionRepository) : ViewModel() {
    val dirreciones : Flow<List<Direccion>> = direccionRepository.getAllDireccionesStream()

    fun incertDirrecion(direccion: Direccion){
        viewModelScope.launch{
            direccionRepository.insertDireccion(direccion)
        }
    }
    
}