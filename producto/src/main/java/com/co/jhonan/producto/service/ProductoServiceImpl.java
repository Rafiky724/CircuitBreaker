package com.co.jhonan.producto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.jhonan.producto.entity.Producto;
import com.co.jhonan.producto.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	ProductoRepository productoRepository;

    @Override
    public List<Producto> obtenerTodosLosProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerProductoPorId(String id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        return productoOptional.orElse(null);
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto(String id) {
        productoRepository.deleteById(id);
    }

}
