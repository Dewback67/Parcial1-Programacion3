package com.example.parcial1_progra3_sebastianarmijo.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.parcial1_progra3_sebastianarmijo.model.Cliente
import com.example.parcial1_progra3_sebastianarmijo.model.Producto
import com.example.parcial1_progra3_sebastianarmijo.repository.ClienteRepositorio
import com.example.parcial1_progra3_sebastianarmijo.repository.IRepositorio
import com.example.parcial1_progra3_sebastianarmijo.repository.ProductoRepositorio

@Composable
fun AppNavigation(
    productoRepositorio: IRepositorio<Producto>,
    clienteRepositorio: IRepositorio<Cliente>,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                NavigationBarItem(
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Productos") },
                    label = { Text("Productos") },
                    selected = currentDestination?.hierarchy?.any { it.route == "productos" } == true,
                    onClick = {
                        navController.navigate("productos") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )

                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Clientes") },
                    label = { Text("Clientes") },
                    selected = currentDestination?.hierarchy?.any { it.route == "clientes" } == true,
                    onClick = {
                        navController.navigate("clientes") {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "productos",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("productos") {
                ProductosScreen(
                    productoRepositorio = productoRepositorio,
                    modifier = Modifier.fillMaxSize()
                )
            }
            composable("clientes") {
                ClientesScreen(
                    clienteRepositorio = clienteRepositorio,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppNavigationPreview() {
    AppNavigation(
        productoRepositorio = ProductoRepositorio(),
        clienteRepositorio = ClienteRepositorio()
    )
}
