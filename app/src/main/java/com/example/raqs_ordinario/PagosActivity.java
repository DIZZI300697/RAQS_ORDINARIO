package com.example.raqs_ordinario;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.raqs_ordinario.CarritoSingleton;
import com.example.raqs_ordinario.Producto;
import com.example.raqs_ordinario.R;

import java.util.List;

public class PagosActivity extends AppCompatActivity {

    private List<Producto> carrito;
    private TextView totalTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagos);

        carrito = CarritoSingleton.getInstance().getCarrito();

        totalTextView = findViewById(R.id.totalTextView);
        double total = calcularTotal();
        totalTextView.setText("Total a pagar: $" + total);

        Button pagarButton = findViewById(R.id.pagarButton);
        pagarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarAgradecimiento();
            }
        });
    }

    private double calcularTotal() {
        double total = 0;
        for (Producto producto : carrito) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }

    private void mostrarAgradecimiento() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("¡Gracias por su compra!")
                .setMessage("Su compra ha sido procesada exitosamente.")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                        // Aquí puedes realizar alguna acción adicional si es necesario
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

