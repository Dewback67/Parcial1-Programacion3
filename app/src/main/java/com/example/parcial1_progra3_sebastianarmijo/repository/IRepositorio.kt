package com.example.parcial1_progra3_sebastianarmijo.repository

interface IRepositorio<T> {
    fun agregar(item: T)
    fun obtenerTodos(): List<T>
    fun buscarPorId(id: Int): T?
}
