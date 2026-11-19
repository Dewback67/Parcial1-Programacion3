package com.example.parcial1_progra3_sebastianarmijo.service

class DescuentoPorVolumen(
    val umbral: Double,
    val porcentaje: Double
) : IDescuento {

    override fun aplicar(total: Double): Double {
        return if (total >= umbral) {
            val factorDescuento = if (porcentaje > 1.0) porcentaje / 100.0 else porcentaje
            total * (1.0 - factorDescuento)
        } else {
            total
        }
    }
}
