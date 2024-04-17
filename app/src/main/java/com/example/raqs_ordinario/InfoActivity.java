package com.example.raqs_ordinario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity {

    private ImageView productImage;
    private TextView productDescription;
    private TextView quantityText;
    private TextView totalPriceText;
    private int quantity = 0;
    private double price; // Precio del producto

    // Lista para mantener los productos en el carrito
    private List<com.example.ordinario_randyquijano.Producto> carritoProductos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        // Referencias a los elementos de la interfaz
        productImage = findViewById(R.id.productImage);
        productDescription = findViewById(R.id.productDescription);
        quantityText = findViewById(R.id.quantityText);
        totalPriceText = findViewById(R.id.totalPriceText);
        Button decreaseButton = findViewById(R.id.decreaseButton);
        Button increaseButton = findViewById(R.id.increaseButton);
        Button returnButton = findViewById(R.id.returnButton);
        Button payButton = findViewById(R.id.pagarButton);
        Button addToCartButton = findViewById(R.id.addToCartButton);

        // Obtener datos del producto de los extras del intent
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String productType = extras.getString("product_type");
            price = extras.getDouble("product_price");
            String description = extras.getString("product_description");
            // Usar los datos del producto para establecer la imagen, descripción y precio
            setProductData(productType, description);
        }

        // Manejador de eventos para disminuir la cantidad
        decreaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (quantity > 0) {
                    quantity--;
                    updateQuantityAndTotalPrice();
                }
            }
        });

        // Manejador de eventos para aumentar la cantidad
        increaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity++;
                updateQuantityAndTotalPrice();
            }
        });

        // Manejador de eventos para el botón de regresar
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Regresar a la actividad anterior
            }
        });

        // Manejador de eventos para el botón de pagar
        payButton.setOnClickListener(new View.OnClickListener() {
            class PagosActivity {
            }

            @Override
            public void onClick(View v) {
                // Ir a PagosActivity
                Intent intent = new Intent(InfoActivity.this, PagosActivity.class);
                startActivity(intent);
            }
        });

        // Manejador de eventos para el botón de agregar al carrito
        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Agregar el producto al carrito
                carritoProductos.add(new com.example.ordinario_randyquijano.Producto(productDescription.getText().toString(), quantity, price));
            }
        });
    }

    // Método para actualizar el texto de cantidad y el precio total
    private void updateQuantityAndTotalPrice() {
        quantityText.setText("Cantidad: " + quantity);
        double totalPrice = quantity * price;
        totalPriceText.setText("Precio Total: $" + totalPrice);
    }

    // Método para establecer los datos del producto
    private void setProductData(String productType, String description) {
        int imageResource = 0;

        // Establecer la imagen y la descripción según el tipo de producto
        switch (productType) {
            case "Monitor 1":
                imageResource = R.drawable.logoasus;
                break;
            case "Monitor 2":
                imageResource = R.drawable.logogygabite;
                break;
            case "Monitor 3":
                imageResource = R.drawable.logomsi;
                break;
            case "Teclado 1":
                imageResource = R.drawable.logotasus;
                break;
            case "Teclado 2":
                imageResource = R.drawable.logotlogitech;
                break;
            case "Teclado 3":
                imageResource = R.drawable.logotxpg;
                break;
            case "Silla 1":
                imageResource = R.drawable.logosnash;
                break;
            case "Silla 2":
                imageResource = R.drawable.logosnova;
                break;
            case "Silla 3":
                imageResource = R.drawable.logosrog;
                break;
        }

        // Establecer la imagen, descripción y precio en los elementos de la interfaz
        productImage.setImageResource(imageResource);
        productDescription.setText(description);
        totalPriceText.setText("Precio: $" + price);
    }
}

