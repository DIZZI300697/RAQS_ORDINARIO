package com.example.ordinario_randyquijano;

public class Producto {
    private String tipo;
    private int cantidad;
    private double precio;

    public Producto(String tipo, int cantidad, double precio) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }
}

