package com.example.parcial1_progra3_sebastianarmijo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.parcial1_progra3_sebastianarmijo.repository.ClienteRepositorio
import com.example.parcial1_progra3_sebastianarmijo.repository.ProductoRepositorio
import com.example.parcial1_progra3_sebastianarmijo.ui.AppNavigation
import com.example.parcial1_progra3_sebastianarmijo.ui.theme.Parcial1Progra3SebastianArmijoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val productoRepositorio = ProductoRepositorio()
        val clienteRepositorio = ClienteRepositorio()

        setContent {
            Parcial1Progra3SebastianArmijoTheme {
                AppNavigation(
                    productoRepositorio = productoRepositorio,
                    clienteRepositorio = clienteRepositorio
                )
            }
        }
    }
}
