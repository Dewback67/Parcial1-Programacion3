package com.example.parcial1_progra3_sebastianarmijo.model

class Ropa(
    id: Int,
    nombre: String,
    precio: Double,
    stock: Int,
    val talla: String,
    val deporte: String
) : Producto(id, nombre, precio, stock) {

    override fun getDescripcion(): String {
        return "Ropa: $nombre - Deporte: $deporte - Talla: $talla - Precio: $$precio - Stock: $stock"
    }
}
