package com.co.jhonan.pedido.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.co.jhonan.pedido.entity.Pedido;

public interface PedidoRepository extends MongoRepository<Pedido, String> {

}
