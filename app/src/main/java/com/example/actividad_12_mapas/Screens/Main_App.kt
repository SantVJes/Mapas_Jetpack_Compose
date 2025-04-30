package com.example.actividad_12_mapas.Screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.actividad_12_mapas.Data_base.AppContainer

//Pantalla de menu de la App
fun menu_App(navController: NavHostController, appContainer: AppContainer) {

}

//cuerpo de la pantalla de menu de la App
fun Body_menu(navController: NavHostController, appContainer: AppContainer){

}


//Vista previa de la pantalla de menu de la App
@Preview(showBackground = true)
@Composable
fun GreetingPreview_Menu() {
    val appContainer = AppContainer(LocalContext.current)
    val navController = rememberNavController()
    menu_App(navController, appContainer)


}
