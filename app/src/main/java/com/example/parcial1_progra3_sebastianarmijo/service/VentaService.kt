package com.example.parcial1_progra3_sebastianarmijo.service

import com.example.parcial1_progra3_sebastianarmijo.model.Cliente
import com.example.parcial1_progra3_sebastianarmijo.model.DetalleVenta
import com.example.parcial1_progra3_sebastianarmijo.model.Producto
import com.example.parcial1_progra3_sebastianarmijo.model.Venta
import com.example.parcial1_progra3_sebastianarmijo.repository.IRepositorio
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class VentaService(
    private val productoRepositorio: IRepositorio<Producto>,
    private val descuento: IDescuento
) {
    private var contadorVentaId: Int = 1

    fun registrarVenta(cliente: Cliente, detalles: List<DetalleVenta>): Venta {
        for (detalle in detalles) {
            if (!detalle.producto.hayStock(detalle.cantidad)) {
                throw IllegalArgumentException("Stock insuficiente para el producto: ${detalle.producto.nombre}")
            }
        }

        for (detalle in detalles) {
            detalle.producto.stock -= detalle.cantidad
        }

        val fechaActual = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
        val ventaId = contadorVentaId++

        return Venta(
            id = ventaId,
            fecha = fechaActual,
            cliente = cliente,
            detalles = detalles
        )
    }

    fun calcularTotalConDescuento(venta: Venta): Double {
        val total = venta.calcularTotal()
        return descuento.aplicar(total)
    }
}
