package com.example.raqs_ordinario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SillasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sillas);

        // Obtener referencias a las ImageView de los productos
        ImageView product1Image = findViewById(R.id.product1Image);
        ImageView product2Image = findViewById(R.id.product2Image);
        ImageView product3Image = findViewById(R.id.product3Image);

        // Establecer onClickListeners para cada imagen de producto
        product1Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a InfoActivity pasando el tipo de producto
                openInfoActivity("Silla 1", 3999.0, "Silla Gamer Munfrost Nova / Color Negro / Reclinable /Con Soporte Lumbar / Hasta 180kg / Ruedas Tipo Patín / MFMSIL1B");
            }
        });

        product2Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a InfoActivity pasando el tipo de producto
                openInfoActivity("Silla 2", 6799.0, "Silla Gamer Munfrost NASH / Color Blanco / Reclinable / Con Soporte Lumbar / Hasta 180kg / Ruedas Tipo Patín / Brazos 3D");
            }
        });

        product3Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a InfoActivity pasando el tipo de producto
                openInfoActivity("Silla 3", 8999.0, "Silla Gamer Asus SL400 ROG DESTRIER / Black / 360° / Clase 4 / Ajustes de Asientos Versátiles / Malla Transpirable / SL400 ROG DESTRIER BK/WW");
            }
        });

        // Obtener referencia al botón de regresar
        Button returnButton = findViewById(R.id.returnButton);

        // Establecer OnClickListener para el botón de regresar
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresar a MainActivity2
                Intent intent = new Intent(SillasActivity.this, MainActivity2.class);
                startActivity(intent);
                finish(); // Terminar la actividad actual
            }
        });
    }

    // Método para abrir InfoActivity y pasar el tipo de producto como extra
    private void openInfoActivity(String productType, double price, String description) {
        Intent intent = new Intent(SillasActivity.this, InfoActivity.class);
        intent.putExtra("product_type", productType);
        intent.putExtra("product_price", price);
        intent.putExtra("product_description", description);
        startActivity(intent);
    }
}

