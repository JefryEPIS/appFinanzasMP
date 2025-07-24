package com.example.appfinanzas2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appfinanzas2.pantallas.PantallaNavegacionActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ir directamente a la pantalla con barra inferior
        val intent = Intent(this, PantallaNavegacionActivity::class.java)
        startActivity(intent)

        // Finaliza MainActivity si no quieres volver a ella
        finish()
    }
}
