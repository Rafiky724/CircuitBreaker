package com.co.jhonan.producto.service;

import java.util.List;

import com.co.jhonan.producto.entity.Producto;

public interface ProductoService {
	
	public List<Producto> obtenerTodosLosProductos();
	public Producto obtenerProductoPorId(String id);
	public Producto guardarProducto(Producto producto);
	public void eliminarProducto(String id);
}
