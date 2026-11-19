package com.example.parcial1_progra3_sebastianarmijo.model

class Venta(
    val id: Int,
    val fecha: String,
    val cliente: Cliente,
    val detalles: List<DetalleVenta>
) {
    fun calcularTotal(): Double {
        return detalles.sumOf { it.calcularSubtotal() }
    }
}
