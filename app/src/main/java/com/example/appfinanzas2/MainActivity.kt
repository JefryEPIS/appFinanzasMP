package com.example.appfinanzas2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appfinanzas2.pantallas.PantallaNavegacionActivity // Importa tu PantallaNavegacionActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // No hay setContentView aquí porque esta actividad ya no es la principal del launcher.
        // Si necesitas que haga algo, lo harías aquí.
        // Por ejemplo, si decides que esta Activity debe lanzar PantallaNavegacionActivity
        // después de alguna verificación, podrías mantener el código de abajo.
        // Sin embargo, si RegistroSesionActivity es el punto de entrada, este código no se ejecutará al inicio.

        // Ejemplo: Si quieres que MainActivity lance PantallaNavegacionActivity
        // después de que el usuario ya haya iniciado sesión (lógica de sesión simulada)
        // val intent = Intent(this, PantallaNavegacionActivity::class.java)
        // startActivity(intent)
        // finish()
    }
}
