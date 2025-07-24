package com.example.appfinanzas2

import AuthenticationScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.appfinanzas2.ui.theme.AppFinanzas2Theme // Asegúrate que el nombre de tu tema sea correcto

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama al tema principal de tu aplicación
            AppFinanzas2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Aquí se llama a la pantalla de autenticación que creamos
                    AuthenticationScreen()
                }
            }
        }
    }
}