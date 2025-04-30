package com.example.actividad_12_mapas.Data_base

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
                    .addCallback(DatabaseCallback())
                    .build()
                    .also { instance = it }
            }
        }

    }
    private class DatabaseCallback : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            CoroutineScope(Dispatchers.IO).launch {
                val dao = instance?.direccionDao() // Corrected to direccionDao()
                // Guadalajara, Jalisco, Mexico
                dao?.insertDirrecion(
                    Direccion(
                        direccion = "uno",
                        tipo = "Negocio",
                        latitud = 21.6736,
                        longitud = -104.344
                    )
                )
                dao?.insertDirrecion(
                    Direccion(
                        direccion = "dos",
                        tipo = "Negocio",
                        latitud = 21.6736,
                        longitud = -105.344
                    )
                )
                dao?.insertDirrecion(
                    Direccion(
                        direccion = "Avenida Vallarta 1250, Americana, Guadalajara",
                        tipo = "Negocio",
                        latitud = 24.6736,
                        longitud = -108.344
                    )
                )
                dao?.insertDirrecion(
                    Direccion(
                        direccion = "Calle Morelos 100, Centro, Guadalajara",
                        tipo = "Casa residencial",
                        latitud = 21.6736,
                        longitud = -103.344
                    )
                )
                dao?.insertDirrecion(
                    Direccion(
                        direccion = "Calle López Cotilla 1000, Americana, Guadalajara",
                        tipo = "Casa residencial",
                        latitud = 20.6736,
                        longitud = -103.344
                    )
                )
            }
        }
    }
}





