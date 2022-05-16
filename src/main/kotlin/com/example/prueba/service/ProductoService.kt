package com.example.prueba.service

import com.example.prueba.model.Producto
import com.example.prueba.repository.ProductoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service

class ProductoService {
    @Autowired
    lateinit var productoRepository: ProductoRepository

    fun  list(): List<Producto>{
        return productoRepository.findAll()
    }

    fun save(producto: Producto):Producto{
        return productoRepository.save(producto)
    }

    fun update(producto: Producto): Producto {
        try {
            productoRepository.findById(producto.id) ?: throw Exception("El id ${producto.id} del producto no existe")

            return productoRepository.save(producto)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,ex.message,ex)
        }
    }

    fun updateName(producto: Producto): Producto{
        val response=productoRepository.findById(producto.id)
            ?:throw  Exception()
        response.descripcion=producto.descripcion
        return productoRepository.save(response)
    }
    fun delete (id:Long): Boolean{
        productoRepository.deleteById(id)
        return true
    }
    fun getById (id: Long?): Producto?{
        return productoRepository.findById(id)
    }
}