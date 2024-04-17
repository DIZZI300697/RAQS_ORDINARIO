package com.example.raqs_ordinario;

import com.example.ordinario_randyquijano.Producto;

import java.util.ArrayList;
import java.util.List;

public class CarritoSingleton {
    private static CarritoSingleton instance;
    private List<Producto> carrito;

    private CarritoSingleton() {
        carrito = new ArrayList<>();
    }

    public static synchronized CarritoSingleton getInstance() {
        if (instance == null) {
            instance = new CarritoSingleton();
        }
        return instance;
    }

    public List<Producto> getCarrito() {
        return carrito;
    }

    public void agregarAlCarrito(Producto producto) {
        carrito.add(producto);
    }

    // Otros métodos para manejar el carrito, como eliminar un producto, limpiar el carrito, etc.
}
