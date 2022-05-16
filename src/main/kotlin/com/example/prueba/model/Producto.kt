package com.example.prueba.model

import javax.persistence.*

@Entity
@Table(name="producto")

class Producto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)

    var id: Long? = null
    var descripcion: String? = null
    var pvp: Long?=null
    var stock: Long?=null
}