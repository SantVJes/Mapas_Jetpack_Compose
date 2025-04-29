package com.example.actividad_12_mapas.Data_base

import android.content.Context

class AppContainer (context: Context){
    private  val DirrecionDatabase = DirreccionDatabase.getDatabase(context)
    private  val DirrecionDao = DirrecionDatabase.direccionDao()
    private  val DirrecionRepositoy = DireccionRepositoryImpl(DirrecionDao)

    fun provideDirrecionRepositoy(): DireccionRepository {
        return  DirrecionRepositoy
    }

}

