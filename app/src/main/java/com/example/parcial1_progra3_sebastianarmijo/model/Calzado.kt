package com.example.parcial1_progra3_sebastianarmijo.model

class Calzado(
    id: Int,
    nombre: String,
    precio: Double,
    stock: Int,
    val talla: Int
) : Producto(id, nombre, precio, stock) {

    override fun getDescripcion(): String {
        return "Calzado: $nombre - Talla: $talla - Precio: $$precio - Stock: $stock"
    }
}
