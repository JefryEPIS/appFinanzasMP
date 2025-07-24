import androidx.compose.animation.*
import androidx.compose.animation.core.tween
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
import com.example.appfinanzas2.R // Asegúrate de que este import sea correcto

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AuthenticationScreen() {
    // 1. Un estado para controlar todo. Si es true, muestra Login. Si es false, muestra Registro.
    var showLogin by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // --- Parte Superior Estática (nunca cambia) ---
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(painter = painterResource(id = R.drawable.logo_unap), contentDescription = "Logo 1", modifier = Modifier.size(80.dp))
            Image(painter = painterResource(id = R.drawable.logo_sis), contentDescription = "Logo 2", modifier = Modifier.size(80.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("FinanzasMP", fontSize = 20.sp, style = MaterialTheme.typography.titleLarge)
        Text("Monetiza tu vida", fontSize = 14.sp, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(16.dp))

        // 2. Pestañas que cambian el estado `showLogin`
        TabRow(
            selectedTabIndex = if (showLogin) 0 else 1,
            containerColor = Color.Transparent
        ) {
            Tab(
                selected = showLogin,
                onClick = { showLogin = true },
                text = { Text("Ingresar") }
            )
            Tab(
                selected = !showLogin,
                onClick = { showLogin = false },
                text = { Text("Registrarse") }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 3. AnimatedContent: El Animador
        AnimatedContent(
            targetState = showLogin,
            transitionSpec = {
                if (targetState) {
                    // Animación para cuando aparece el Login (viene de la izquierda)
                    slideInHorizontally(initialOffsetX = { -it }, animationSpec = tween(300)) togetherWith
                            slideOutHorizontally(targetOffsetX = { it }, animationSpec = tween(300))
                } else {
                    // Animación para cuando aparece el Registro (viene de la derecha)
                    slideInHorizontally(initialOffsetX = { it }, animationSpec = tween(300)) togetherWith
                            slideOutHorizontally(targetOffsetX = { -it }, animationSpec = tween(300))
                }
            }, label = "Formulario animado"
        ) { isLoginScreen ->
            if (isLoginScreen) {
                LoginForm()
            } else {
                RegistrationForm()
            }
        }
    }
}


@Composable
fun LoginForm() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        var usuario by remember { mutableStateOf("") }
        var codigo by remember { mutableStateOf("") }
        var contrasena by remember { mutableStateOf("") }
        var contrasenaVisible by remember { mutableStateOf(false) }

        OutlinedTextField(value = usuario, onValueChange = { usuario = it }, label = { Text("Usuario") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = codigo, onValueChange = { codigo = it }, label = { Text("Código") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (contrasenaVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (contrasenaVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton(onClick = { contrasenaVisible = !contrasenaVisible }) { Icon(imageVector = image, contentDescription = null) }
            }
        )
        Button(onClick = { /*TODO: Lógica de Login*/ }, modifier = Modifier.fillMaxWidth()) {
            Text("Ingresar")
        }
    }
}


@Composable
fun RegistrationForm() {
    // Este es el formulario de 4 filas que hicimos antes, simplificado.
    // Puedes copiar el código completo de la respuesta anterior si quieres todos los campos.
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        var usuario by remember { mutableStateOf("") }
        var contrasena by remember { mutableStateOf("") }
        var confirmarContrasena by remember { mutableStateOf("") }

        OutlinedTextField(value = usuario, onValueChange = { usuario = it }, label = { Text("Usuario") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = contrasena, onValueChange = { contrasena = it }, label = { Text("Contraseña") }, modifier = Modifier.fillMaxWidth())
        OutlinedTextField(value = confirmarContrasena, onValueChange = { confirmarContrasena = it }, label = { Text("Confirmar Contraseña") }, modifier = Modifier.fillMaxWidth())

        Button(onClick = { /*TODO: Lógica de Registro*/ }, modifier = Modifier.fillMaxWidth()) {
            Text("Registrarse")
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewAuthenticationScreen() {
    AuthenticationScreen()
}