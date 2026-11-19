package com.example.parcial1_progra3_sebastianarmijo.model

class DetalleVenta(
    val producto: Producto,
    val cantidad: Int
) {
    fun calcularSubtotal(): Double {
        return producto.precio * cantidad
    }
}
