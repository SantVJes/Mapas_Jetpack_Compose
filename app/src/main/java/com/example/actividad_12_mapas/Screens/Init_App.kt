@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.actividad_12_mapas.Screens

import android.util.Log
import android.widget.Toast

import androidx.activity.ComponentActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController

import com.example.actividad_12_mapas.Data_base.AppContainer
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.Executor

//Pantalla de inicio de la App
@Composable
 fun Inicio_App(navController: NavHostController, appContainer: AppContainer) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

            Body_Inicio(appContainer, navController)
        }
    }
}


@Composable
fun Body_Inicio(appContainer: AppContainer, navController: NavHostController) {

    val context = LocalContext.current
    val activity = context as FragmentActivity
    val executor: Executor = ContextCompat.getMainExecutor(context)
    val biometricManager = BiometricManager.from(context)

    val promtInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle("title")
        .setSubtitle("subtitle")
        .setAllowedAuthenticators(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)
        .build()


    val biometricPrompt = BiometricPrompt(activity ,executor ,
        object: BiometricPrompt.AuthenticationCallback(){
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                Toast.makeText(
                    context,
                    errString
                    ,Toast.LENGTH_LONG
                ).show()
            }


            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Toast.makeText(
                    context,
                    "succeeded"
                    ,Toast.LENGTH_LONG
                ).show()
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
                Toast.makeText(
                    context,
                    "fallido"
                    ,Toast.LENGTH_LONG
                ).show()
            }


        })


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Inicio de la App",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))


    }
    LaunchedEffect(Unit){
        delay(500)
        biometricPrompt.authenticate(promtInfo)
    }
}


//Vista previa de la pantalla de inicio de la App
@Preview(showBackground = true)
@Composable
fun GreetingPreview_Inicio() {

    Inicio_App(navController = NavHostController(LocalContext.current), appContainer = AppContainer(LocalContext.current))

}

