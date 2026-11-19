package com.example.parcial1_progra3_sebastianarmijo.model

abstract class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    var stock: Int
) {
    abstract fun getDescripcion(): String

    fun hayStock(cantidad: Int): Boolean {
        return stock >= cantidad
    }
}
