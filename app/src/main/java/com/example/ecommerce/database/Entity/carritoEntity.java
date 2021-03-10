package com.example.ecommerce.database.Entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "Carrito", primaryKeys = {"id"})
public class carritoEntity {

    @NonNull
    String id;
    String nombre;
    String descripcion;
    int cantidad;
    double valor;

    public carritoEntity(@NonNull String id,String nombre,String descripcion,int cantidad,double valor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
