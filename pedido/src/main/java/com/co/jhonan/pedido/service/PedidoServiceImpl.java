package com.co.jhonan.pedido.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.co.jhonan.pedido.entity.Pedido;
import com.co.jhonan.pedido.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{
	
	private final PedidoRepository pedidoRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

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
    
}
