package com.example.actividad_12_mapas.Nav

import androidx.compose.runtime.Composable

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.actividad_12_mapas.Data_base.AppContainer
import com.example.actividad_12_mapas.Screens.Inicio_App


//Fusion para controlar la navegacion entre pantallas de la App

@Composable
fun AppNavigation(appContainer: AppContainer){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Directorio.inicioApp){

        composable(Directorio.inicioApp){
            Inicio_App(navController, appContainer)
            }


    }





}




