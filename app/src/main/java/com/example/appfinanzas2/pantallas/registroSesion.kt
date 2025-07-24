package com.example.appfinanzas2.pantallas

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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

// Reemplaza com.example.appfinanzas2.R con la ruta de tu paquete
// import com.example.appfinanzas2.R

@Composable
fun RegistrationScreen(){

    // Estados para guardar lo que el usuario escribe en cada campo
    var nombreCompleto by remember { mutableStateOf("") }
    var usuario by remember { mutableStateOf("") }
    var codigo by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var contrasena by rememberSaveable { mutableStateOf("") }
    var confirmarContrasena by rememberSaveable { mutableStateOf("") }
    var contrasenaVisible by rememberSaveable { mutableStateOf(false) }
    var confirmarContrasenaVisible by rememberSaveable { mutableStateOf(false) }


    Scaffold(
        containerColor = Color(0xFFE0F7FA) // Un color de fondo azul claro similar al de tu imagen
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()), // Para que la pantalla se pueda deslizar si no cabe
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // --- Logos ---
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // TODO: Reemplaza R.drawable.logo1 con tu propio recurso de imagen
                Image(
                    painter = painterResource(id = android.R.drawable.ic_menu_camera), // Placeholder
                    contentDescription = "Logo 1",
                    modifier = Modifier.size(80.dp)
                )
                // TODO: Reemplaza R.drawable.logo2 con tu propio recurso de imagen
                Image(
                    painter = painterResource(id = android.R.drawable.ic_dialog_map), // Placeholder
                    contentDescription = "Logo 2",
                    modifier = Modifier.size(80.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // --- Textos del Equipo ---
            Text("<Team>", fontSize = 20.sp, style = MaterialTheme.typography.titleLarge)
            Text("<Frase frase frase frase>", fontSize = 14.sp, textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(24.dp))

            // --- Tabs de Ingresar / Registrarse ---
            TabRow(
                selectedTabIndex = 1, // El índice 1 corresponde a "Registrarse"
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Tab(selected = false, onClick = { /* TODO: Navegar a Login */ }, text = { Text("Ingresar") })
                Tab(selected = true, onClick = { }, text = { Text("Registrarse") })
            }

            Spacer(modifier = Modifier.height(16.dp))

            // --- Campos del Formulario de Registro ---
            OutlinedTextField(
                value = nombreCompleto,
                onValueChange = { nombreCompleto = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Nombre Completo") },
                leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Usuario") },
                leadingIcon = { Icon(Icons.Default.AccountCircle, contentDescription = null) },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = correo,
                onValueChange = { correo = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Correo Electrónico") },
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = null) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = codigo,
                onValueChange = { codigo = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Código (Opcional)") },
                leadingIcon = { Icon(Icons.Default.QrCodeScanner, contentDescription = null) },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = contrasena,
                onValueChange = { contrasena = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Contraseña") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                visualTransformation = if (contrasenaVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (contrasenaVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    IconButton(onClick = { contrasenaVisible = !contrasenaVisible }) {
                        Icon(imageVector = image, contentDescription = "Mostrar/Ocultar contraseña")
                    }
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = confirmarContrasena,
                onValueChange = { confirmarContrasena = it },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Confirmar Contraseña") },
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
                visualTransformation = if (confirmarContrasenaVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    val image = if (confirmarContrasenaVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                    IconButton(onClick = { confirmarContrasenaVisible = !confirmarContrasenaVisible }) {
                        Icon(imageVector = image, contentDescription = "Mostrar/Ocultar contraseña")
                    }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            // --- Botón de Registro ---
            Button(
                onClick = {
                    // TODO: Aquí va la lógica para registrar al usuario
                },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00695C)) // Color verde/teal
            ) {
                Text("Registrarse", Modifier.padding(vertical = 8.dp))
            }
        }
    }
}

// --- Vista Previa para ver el diseño en Android Studio ---
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewRegistrationScreen() {
    // Es buena práctica envolver la preview en tu tema de la app
    // AppFinanzasTheme {
    RegistrationScreen()
    // }
}