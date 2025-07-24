package com.example.appfinanzas2.pantallas

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class PantallaNavegacionActivity : AppCompatActivity() {

    private lateinit var contenedorFragmentos: FrameLayout
    private lateinit var barraInferior: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Crear contenedor principal
        val contenedorPrincipal = FrameLayout(this).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        // Crear contenedor para los fragmentos
        contenedorFragmentos = FrameLayout(this).apply {
            id = View.generateViewId()
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        }

        // Crear barra inferior
        barraInferior = BottomNavigationView(this).apply {
            id = View.generateViewId()
            layoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = android.view.Gravity.BOTTOM
            }

            // Añadir ítems directamente
            menu.add(0, 1, 0, "Inicio").setIcon(android.R.drawable.ic_menu_view)
            menu.add(0, 2, 1, "Buscar").setIcon(android.R.drawable.ic_menu_search)
            menu.add(0, 3, 2, "Perfil").setIcon(android.R.drawable.ic_menu_myplaces)
        }

        // Agregar vistas al contenedor principal
        contenedorPrincipal.addView(contenedorFragmentos)
        contenedorPrincipal.addView(barraInferior)

        // Establecer vista principal
        setContentView(contenedorPrincipal)

        // Cargar fragmento por defecto
        reemplazarFragmento(InicioFragment())

        // Manejador de selección
        barraInferior.setOnItemSelectedListener {
            val fragmento = when (it.itemId) {
                1 -> InicioFragment()
                2 -> BuscarFragment()
                3 -> PerfilFragment()
                else -> null
            }
            fragmento?.let { reemplazarFragmento(it) }
            true
        }
    }

    private fun reemplazarFragmento(fragmento: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(contenedorFragmentos.id, fragmento)
            .commit()
    }
}