package com.co.jhonan.pedido.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.co.jhonan.pedido.entity.Pedido;
import com.co.jhonan.pedido.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;

    @GetMapping
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidoService.obtenerTodosLosPedidos();
    }

    @GetMapping("/{id}")
    public Pedido obtenerPedidoPorId(@PathVariable String id) {
        return pedidoService.obtenerPedidoPorId(id);
    }

    @PostMapping
    public Pedido guardarPedido(@RequestBody Pedido pedido) {
        return pedidoService.guardarPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public void eliminarPedido(@PathVariable String id) {
        pedidoService.eliminarPedido(id);
    }
    
    @GetMapping("/productos")
	public CompletableFuture<List<Object>> getProductos() throws Exception {
	    return pedidoService.getProductos();
	}
}
