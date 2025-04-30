@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.actividad_12_mapas.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.actividad_12_mapas.Data_base.AppContainer
import com.example.actividad_12_mapas.Data_base.Direccion
import com.example.actividad_12_mapas.ui.theme.DirrecionesViewModel
import kotlinx.coroutines.flow.Flow
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button

import androidx.compose.material3.DropdownMenuItem

import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField

import androidx.compose.material3.TextField

import androidx.compose.runtime.getValue

import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties

import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

import androidx.compose.runtime.setValue
import com.example.actividad_12_mapas.Nav.Directorio
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun Map_App(navController: NavHostController, appContainer: AppContainer) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = Color(0xFF4CAF50),
                    titleContentColor = Color.White,
                ),
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Mapa de los provedores ",
                            style = TextStyle(
                                fontSize = 25.sp,
                                textAlign = TextAlign.Center
                            )
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color(0xFF4CAF50),
                contentColor = Color.Black
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Creado Por Jesus Santiago Velasco ",
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            Body_Map(navController, appContainer)
        }
    }

}






@Composable
fun Body_Map(navController: NavHostController, appContainer: AppContainer) {
    val viewModel = DirrecionesViewModel(appContainer.provideDirrecionRepositoy())
    var userInput by remember { mutableStateOf("") }
    var selectedMapType by remember { mutableStateOf(MapType.NORMAL) }
    val todoUbicacion: Flow<List<Direccion>> = viewModel.getAllDirreciones()
    val busqueda by remember(userInput) {
        viewModel.getdirrecionString(userInput)
    }.collectAsState(initial = null)
    val context = LocalContext.current
    val ubicaciones by todoUbicacion.collectAsState(initial = emptyList())
    var expanded by remember { mutableStateOf(false) }
    val options = listOf("Normal", "Satelital", "Relieve")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = userInput,
            onValueChange = { userInput = it },
            label = { Text("Buscar dirección") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {navController.navigate(Directorio.menuApp)}) {
            Text("Regresar al menu")
        }
        Spacer(modifier = Modifier.height(16.dp))
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            TextField(
                value = selectedMapType.toString(),
                onValueChange = { },
                readOnly = true,
                label = { Text("Tipo de Mapa") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor().fillMaxWidth()
            )




            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            selectedMapType = when (selectionOption) {
                                "Satelital" -> MapType.SATELLITE
                                "Relieve" -> MapType.TERRAIN
                                else -> MapType.NORMAL
                            }
                            expanded = false
                        }
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(LatLng(20.6736, -103.344), 10f)
        }
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
            properties = MapProperties(mapType = selectedMapType),
            uiSettings = MapUiSettings(zoomControlsEnabled = true)
        ) {
           if (busqueda == null) {
               ubicaciones.forEach { ubicacion ->
                   val latLng = LatLng(ubicacion.latitud, ubicacion.longitud)
                   Marker(
                       state = MarkerState(position = latLng),
                       title = ubicacion.direccion,
                       snippet = ubicacion.tipo
                   )
               }
           }else{
               busqueda!!.forEach { ubicacion ->
                   val latLng = LatLng(ubicacion.latitud, ubicacion.longitud)
                   Marker(
                       state = MarkerState(position = latLng),
                       title = ubicacion.direccion,
                       snippet = ubicacion.tipo
                   )
               }
           }


        }


    }
}


//Vista previa de la pantalla de menu de la App
@Preview(showBackground = true)
@Composable
fun GreetingPreview_Map() {

    val appContainer = AppContainer(LocalContext.current)
    val navController = rememberNavController()
    Map_App(navController, appContainer)

}
