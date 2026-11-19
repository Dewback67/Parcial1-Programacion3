package com.example.parcial1_progra3_sebastianarmijo.service

class SinDescuento : IDescuento {
    override fun aplicar(total: Double): Double {
        return total
    }
}
