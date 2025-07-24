package com.example.appfinanzas2.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appfinanzas2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {
    // Variables para guardar los datos de cada campo
    var usuario by remember { mutableStateOf("") }
    var codigo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }

    // Variable para mostrar/ocultar contraseña
    var contrasenaVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Permite deslizar si el contenido es mucho
        verticalArrangement = Arrangement.spacedBy(16.dp), // Espacio entre cada fila
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // --- Parte Superior ---
        Spacer(modifier = Modifier.weight(1f)) // Espaciador para centrar verticalmente

        // Logos
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.logo_unap), contentDescription = "Logo 1", modifier = Modifier.size(80.dp))
            Image(painter = painterResource(id = R.drawable.logo_sis), contentDescription = "Logo 2", modifier = Modifier.size(80.dp))
        }

        // Textos del Equipo
        Text("FinanzasMP", fontSize = 20.sp, style = MaterialTheme.typography.titleLarge)
        Text("Monetiza tu vida", fontSize = 14.sp, textAlign = TextAlign.Center)

        // Tabs de Ingresar / Registrarse
        TabRow(selectedTabIndex = 0, containerColor = Color.Transparent) { // Tab "Ingresar" seleccionado
            Tab(selected = true, onClick = {}, text = { Text("Ingresar") })
            Tab(selected = false, onClick = { /* TODO: Navegar a Registro */ }, text = { Text("Registrarse") })
        }

        // --- Formulario de Login de 3 Filas ---

        // 1. Fila: Usuario
        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth()
        )

        // 2. Fila: Código
        OutlinedTextField(
            value = codigo,
            onValueChange = { codigo = it },
            label = { Text("Código") },
            modifier = Modifier.fillMaxWidth()
        )

        // 3. Fila: Contraseña
        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (contrasenaVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (contrasenaVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton(onClick = { contrasenaVisible = !contrasenaVisible }) {
                    Icon(imageVector = image, contentDescription = "Mostrar/Ocultar contraseña")
                }
            }
        )

        // Botón para ingresar
        Button(
            onClick = { /* TODO: Lógica de Login aquí */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ingresar")
        }

        Spacer(modifier = Modifier.weight(1f)) // Espaciador para centrar verticalmente
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen()
}