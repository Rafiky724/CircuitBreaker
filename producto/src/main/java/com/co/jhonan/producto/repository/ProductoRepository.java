package com.co.jhonan.producto.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.co.jhonan.producto.entity.Producto;

public interface ProductoRepository extends MongoRepository<Producto, String> {

}
