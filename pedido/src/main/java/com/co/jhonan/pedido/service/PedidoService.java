package com.co.jhonan.pedido.service;

import java.util.List;

import com.co.jhonan.pedido.entity.Pedido;

public interface PedidoService {
	 List<Pedido> obtenerTodosLosPedidos();
	 Pedido obtenerPedidoPorId(String id);
	 Pedido guardarPedido(Pedido pedido);
	 void eliminarPedido(String id);
}
