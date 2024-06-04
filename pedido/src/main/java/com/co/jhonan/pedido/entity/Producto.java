package com.co.jhonan.pedido.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "productos")
public class Producto {

	@Id
    private String idProducto;
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidadEnStock;
    
    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String id) {
        this.idProducto = id;
    }

    public String getNombreProducto() {
        return nombre;
    }

    public void setNombreProducto(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadEnStock() {
        return cantidadEnStock;
    }

    public void setCantidadEnStock(int cantidadEnStock) {
        this.cantidadEnStock = cantidadEnStock;
    }
}
