package com.co.jhonan.pedido.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.co.jhonan.pedido.controller.PedidoController;
import com.co.jhonan.pedido.entity.Pedido;
import com.co.jhonan.pedido.entity.Producto;
import com.co.jhonan.pedido.repository.PedidoRepository;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.circuitbreaker.CircuitBreaker.State;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
    CircuitBreakerRegistry circuitBreakerRegistry;
	 private static final Logger logger = LoggerFactory.getLogger(PedidoController.class);
	 RestTemplate restTemplate = new RestTemplate();

    @Override
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido obtenerPedidoPorId(String id) {
        Optional<Pedido> pedidoOptional = pedidoRepository.findById(id);
        return pedidoOptional.orElse(null);
    }

    @Override
    public Pedido guardarPedido(Pedido pedido) {
    	return pedidoRepository.save(pedido);
    }

   
    
    @Override
    public void eliminarPedido(String id) {
        pedidoRepository.deleteById(id);
    }
    
    @Override
	@CircuitBreaker(name = "productosCircuitBreaker", fallbackMethod = "productosFallido")
	@TimeLimiter(name = "offersTimeLimiter")
	public CompletableFuture<List<Object>> getProductos() throws Exception {
	    return CompletableFuture.supplyAsync(() -> {
	        Object[] productos = null;
	        State estado = circuitBreakerRegistry.circuitBreaker("productosCircuitBreaker").getState();
			logger.info("Circuit Breaker State : {} -> {}", estado);
			circuitBreakerRegistry.circuitBreaker("productosCircuitBreaker").getEventPublisher().onEvent(event -> {
				   logger.info("State change {}", event);
			});
	        try {
	        	throw new RuntimeException("Simulando fallo para abrir el Circuit Breaker");
	        	//productos = restTemplate.getForObject("http://localhost:8080/productos", Object[].class);
	        } catch (Exception e) {
	            throw new RuntimeException("Failed to fetch products", e);
	        }
	        
	        //return Arrays.asList(productos);
	    });
	}
	
    public CompletableFuture<List<Object>> productosFallido(Throwable throwable) {
	    List<Object> fallbackResponse = new ArrayList<>();
	    fallbackResponse.add("El microservicio de productos no está disponible!");
	    State estado = circuitBreakerRegistry.circuitBreaker("productosCircuitBreaker").getState();
		logger.info("Circuit Breaker State : {} -> {}", estado);
		circuitBreakerRegistry.circuitBreaker("productosCircuitBreaker").getEventPublisher().onEvent(event -> {
			   logger.info("State change {}", event);
		});
	    return CompletableFuture.completedFuture(fallbackResponse);
	}
    
}
