package com.co.jhonan.pedido.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.co.jhonan.pedido.entity.Pedido;

public interface PedidoService {
	public List<Pedido> obtenerTodosLosPedidos();
	public Pedido obtenerPedidoPorId(String id);
	public Pedido guardarPedido(Pedido pedido);
	public void eliminarPedido(String id);
	public CompletableFuture<List<Object>> getProductos() throws Exception;
}
