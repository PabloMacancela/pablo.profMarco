package com.example.prueba.repository

import com.example.prueba.model.Producto
import org.springframework.data.jpa.repository.JpaRepository

interface ProductoRepository: JpaRepository<Producto,Long> {

    fun findById(id:Long?): Producto?

}