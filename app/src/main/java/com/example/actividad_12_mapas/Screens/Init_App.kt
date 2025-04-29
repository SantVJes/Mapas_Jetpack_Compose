@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.actividad_12_mapas.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
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
import com.example.actividad_12_mapas.Data_base.AppContainer
import kotlinx.coroutines.launch

//Pantalla de inicio de la App
@Composable
 fun Inicio_App(navController: NavHostController, appContainer: AppContainer) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            Boby_Inicio(appContainer, navController)
        }
    }
}



//Cuerpo de la pantalla de inicio de la App
@Composable
fun Boby_Inicio(appContainer: AppContainer , navController: NavHostController) {


}




//Vista previa de la pantalla de inicio de la App
@Preview(showBackground = true)
@Composable
fun GreetingPreview_Inicio() {

    Inicio_App(navController = NavHostController(LocalContext.current), appContainer = AppContainer(LocalContext.current))

}

