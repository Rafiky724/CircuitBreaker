package com.co.jhonan.producto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.co.jhonan.producto.entity.Producto;
import com.co.jhonan.producto.repository.ProductoRepository;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ProductoServiceImpl implements ProductoService{

	private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    @CircuitBreaker(name = "servicio-circuit-breaker", fallbackMethod = "manejarErrorCircuitBreaker")
    public List<Producto> obtenerTodosLosProductos() {
    	if (Math.random() < 0.5) {
            throw new RuntimeException("Error simulado al obtener todos los productos");
        }
        return productoRepository.findAll();
    }

    @Override
    @CircuitBreaker(name = "servicio-circuit-breaker", fallbackMethod = "manejarErrorCircuitBreaker")
    public Producto obtenerProductoPorId(String id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        return productoOptional.orElse(null);
    }

    @Override
    @CircuitBreaker(name = "servicio-circuit-breaker", fallbackMethod = "manejarErrorCircuitBreaker")
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    @CircuitBreaker(name = "servicio-circuit-breaker", fallbackMethod = "manejarErrorCircuitBreaker")
    public void eliminarProducto(String id) {
        productoRepository.deleteById(id);
    }

    public Object manejarErrorCircuitBreaker(Exception e) {
        
        return "Se produjo un error al procesar la solicitud a este servicio: ";
    }
}
