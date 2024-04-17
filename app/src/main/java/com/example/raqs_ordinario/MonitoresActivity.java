package com.example.raqs_ordinario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MonitoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitores);

        // Obtener referencias a las ImageView de los productos
        ImageView product1Image = findViewById(R.id.product1Image);
        ImageView product2Image = findViewById(R.id.product2Image);
        ImageView product3Image = findViewById(R.id.product3Image);

        // Establecer onClickListeners para cada imagen de producto
        product1Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a InfoActivity pasando el tipo de producto
                openInfoActivity("Monitor 1", 8299.0, "Monitor Gamer ASUS VA34VCPSN / Curvo / LED 34 / UltraWide / Quad HD / 100Hz / HDMI / Negro / VA34VCPSN");
            }
        });

        product2Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a InfoActivity pasando el tipo de producto
                openInfoActivity("Monitor 2", 2799.0, "Monitor MSI G255PF E2 / FHD / Rapid IPS / Free Sync / 1ms / 1920x1080 / 180Hz / 25” / G255PF E2");
            }
        });

        product3Image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ir a InfoActivity pasando el tipo de producto
                openInfoActivity("Monitor 3", 12999.0, "Monitor Gigabyte Aorus FI32U Gaming 31.5 / 3840x2160 UHD / 1ms / IPS / 144Hz / 120Hz para Consolas / HDMI 2.1 / DP / AORUS FI32U-SA / FI32U-SA");
            }
        });

        // Obtener referencia al botón de regresar
        Button returnButton = findViewById(R.id.returnButton);

        // Establecer OnClickListener para el botón de regresar
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresar a MainActivity2
                Intent intent = new Intent(MonitoresActivity.this, MainActivity2.class);
                startActivity(intent);
                finish(); // Terminar la actividad actual
            }
        });
    }

    // Método para abrir InfoActivity y pasar el tipo de producto como extra
    private void openInfoActivity(String productType, double price, String description) {
        Intent intent = new Intent(MonitoresActivity.this, InfoActivity.class);
        intent.putExtra("product_type", productType);
        intent.putExtra("product_price", price);
        intent.putExtra("product_description", description);
        startActivity(intent);
    }
}

