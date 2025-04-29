package com.example.actividad_12_mapas.Data_base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Direccion::class], version = 1, exportSchema = false)
abstract class DirreccionDatabase : RoomDatabase() {
    abstract fun direccionDao(): DirrecionDao

    companion object {
        @Volatile
        private var instance: DirreccionDatabase? = null

        fun getDatabase(context: Context): DirreccionDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    DirreccionDatabase::class.java,
                    "Dirrecion_database"
                )
                    .build()
                    .also { instance = it }
            }
        }
    }
}





