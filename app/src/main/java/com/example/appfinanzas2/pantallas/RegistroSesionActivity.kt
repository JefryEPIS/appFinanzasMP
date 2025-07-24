package com.example.appfinanzas2.pantallas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.appfinanzas2.ui.theme.AppFinanzas2Theme // Asegúrate de que esta sea la ruta correcta a tu tema

class RegistroSesionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppFinanzas2Theme { // Usa el tema de tu aplicación aquí
                RegistrationScreen() // Llama a tu función Composable
            }
        }
    }
}