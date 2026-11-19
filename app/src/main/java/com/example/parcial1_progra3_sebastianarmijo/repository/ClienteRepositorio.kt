package com.example.parcial1_progra3_sebastianarmijo.repository

import com.example.parcial1_progra3_sebastianarmijo.model.Cliente

class ClienteRepositorio : IRepositorio<Cliente> {
    private val clientes: MutableList<Cliente> = mutableListOf(
        Cliente(id = 1, nombre = "Juan Pérez", telefono = "555-0101"),
        Cliente(id = 2, nombre = "María Gómez", telefono = "555-0102"),
        Cliente(id = 3, nombre = "Carlos López", telefono = "555-0103"),
        Cliente(id = 4, nombre = "Ana Martínez", telefono = "555-0104"),
        Cliente(id = 5, nombre = "Luis Rodríguez", telefono = "555-0105")
    )

    override fun agregar(item: Cliente) {
        clientes.add(item)
    }

    override fun obtenerTodos(): List<Cliente> {
        return clientes.toList()
    }

    override fun buscarPorId(id: Int): Cliente? {
        return clientes.find { it.id == id }
    }
}
