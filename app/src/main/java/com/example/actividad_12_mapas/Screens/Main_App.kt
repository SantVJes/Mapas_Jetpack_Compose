@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.actividad_12_mapas.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.actividad_12_mapas.Data_base.AppContainer
import com.example.actividad_12_mapas.Nav.Directorio
import kotlinx.coroutines.launch

//Pantalla de menu de la App
@Composable
fun Menu_App(navController: NavHostController, appContainer: AppContainer) {
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
                            text = "Menu de La App",
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

            Body_menu(navController, appContainer)
        }
    }



}




//cuerpo de la pantalla de menu de la App
@Composable
fun Body_menu(navController: NavHostController, appContainer: AppContainer){


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Add padding around the column
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MenuButton(
            text = "Registrar Proveedor",
            icon = Icons.Filled.AccountBox,
            onClick = {

                navController.navigate(Directorio.registroApp)
            }
        )

        Spacer(modifier = Modifier.height(16.dp)) // Add space between buttons

        MenuButton(
            text = "Mapa de las Ubicación de los  Proveedores",
            icon = Icons.Filled.Home,
            onClick = {
                // Navigate to the map screen
               // navController.navigate("map_screen")
            }
        )
    }
}


@Composable
fun MenuButton(text: String, icon: androidx.compose.ui.graphics.vector.ImageVector, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp), // Add horizontal padding
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF4CAF50), // Green background
            contentColor = Color.White // White text and icon
        ),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp) // Add padding
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

//Vista previa de la pantalla de menu de la App
@Preview(showBackground = true)
@Composable
fun GreetingPreview_Menu() {
    val appContainer = AppContainer(LocalContext.current)
    val navController = rememberNavController()
    Menu_App(navController, appContainer)


}
