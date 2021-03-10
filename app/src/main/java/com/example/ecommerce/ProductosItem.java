package com.example.ecommerce;

public class ProductosItem {
    String id;
    String Nombre;
    String Descripcion;
    int Cantidad;
    double Valor;

    public ProductosItem(String Id, String nombre, String descripcion, int cantidad, double valor) {
        id = Id;
        Nombre = nombre;
        Descripcion = descripcion;
        Cantidad = cantidad;
        Valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        Valor = valor;
    }
}
