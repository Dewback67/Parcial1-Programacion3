package com.example.parcial1_progra3_sebastianarmijo.repository

import com.example.parcial1_progra3_sebastianarmijo.model.Calzado
import com.example.parcial1_progra3_sebastianarmijo.model.Producto
import com.example.parcial1_progra3_sebastianarmijo.model.Ropa

class ProductoRepositorio : IRepositorio<Producto> {
    private val productos: MutableList<Producto> = mutableListOf(
        Calzado(id = 1, nombre = "Zapatillas Running Nike Air", precio = 120.0, stock = 15, talla = 42),
        Calzado(id = 2, nombre = "Tenis Baloncesto Adidas Pro", precio = 140.0, stock = 8, talla = 44),
        Ropa(id = 3, nombre = "Camiseta Fútbol Real Madrid", precio = 85.0, stock = 20, talla = "M", deporte = "Fútbol"),
        Ropa(id = 4, nombre = "Pantalón Sudador Nike Training", precio = 60.0, stock = 12, talla = "L", deporte = "Gimnasio"),
        Calzado(id = 5, nombre = "Zapatillas Tennis Puma Smash", precio = 75.0, stock = 10, talla = 40)
    )

    override fun agregar(item: Producto) {
        productos.add(item)
    }

    override fun obtenerTodos(): List<Producto> {
        return productos.toList()
    }

    override fun buscarPorId(id: Int): Producto? {
        return productos.find { it.id == id }
    }
}
