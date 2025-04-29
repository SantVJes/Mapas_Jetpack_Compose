package com.example.actividad_12_mapas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.actividad_12_mapas.Data_base.AppContainer
import com.example.actividad_12_mapas.Data_base.Direccion
import com.example.actividad_12_mapas.Nav.AppNavigation
import com.example.actividad_12_mapas.ui.theme.Actividad_12_MapasTheme
import com.example.actividad_12_mapas.ui.theme.DirrecionesViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Actividad_12_MapasTheme {
               AppNavigation(appContainer = AppContainer(this))
            }
        }
    }
}



