package com.co.jhonan.producto.service;

import java.util.List;

import com.co.jhonan.producto.entity.Producto;

public interface ProductoService {
	List<Producto> obtenerTodosLosProductos();
    Producto obtenerProductoPorId(String id);
    Producto guardarProducto(Producto producto);
    void eliminarProducto(String id);
}
