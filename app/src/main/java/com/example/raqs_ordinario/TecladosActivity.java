package com.example.raqs_ordinario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TecladosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teclados);

        // Obtener referencias a las ImageView de los productos
        ImageView product1Image = findViewById(R.id.product1Image);
        ImageView product2Image = findViewById(R.id.product2Image);
        ImageView product3Image = findViewById(R.id.product3Image);

        // Establecer onClickListeners para cada imagen de producto
        product1Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a InfoActivity pasando el tipo de producto
                openInfoActivity("Teclado 1", 1279.0, "Teclado Gamer Mecanico ASUS ROG STRIX SCOPE RX / Switch ROG RX BLUE / Aura Sync RGB / Distribución de teclas en Ingles / XA05 ROG STRIX SCOPE RX/BL/US PROMOASUS");
            }
        });

        product2Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a InfoActivity pasando el tipo de producto
                openInfoActivity("Teclado 2", 399.0, "Teclado Gamer Mecanico XPG SUMMONER MINI Switch Blue / 60% / RGB / Español / USB / Negro / SUMMONERMINI61BL-BKCES");
            }
        });

        product3Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a InfoActivity pasando el tipo de producto
                openInfoActivity("Teclado 3", 169.0, "Teclado Logitech K120 / USB / Español /920-004422");
            }
        });

        // Obtener referencia al botón de regresar
        Button returnButton = findViewById(R.id.returnButton);

        // Establecer OnClickListener para el botón de regresar
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresar a MainActivity2
                Intent intent = new Intent(TecladosActivity.this, MainActivity2.class);
                startActivity(intent);
                finish(); // Terminar la actividad actual
            }
        });
    }

    // Método para abrir InfoActivity y pasar el tipo de producto como extra
    private void openInfoActivity(String productType, double price, String description) {
        Intent intent = new Intent(TecladosActivity.this, InfoActivity.class);
        intent.putExtra("product_type", productType);
        intent.putExtra("product_price", price);
        intent.putExtra("product_description", description);
        startActivity(intent);
    }
}
