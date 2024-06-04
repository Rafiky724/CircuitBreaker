package com.co.jhonan.pedido.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "pedidos")
public class Pedido {

	@Id
    private String id;
	private String idProducto;
    private List<String> productos;
    private List<Integer> cantidades;
    private String direccionEnvio;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
    	this.idProducto = idProducto;
    }

    public List<String> getProductos() {
        return productos;
    }

    public void setProductos(List<String> productos) {
        this.productos = productos;
    }

    public List<Integer> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<Integer> cantidades) {
        this.cantidades = cantidades;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }
}
