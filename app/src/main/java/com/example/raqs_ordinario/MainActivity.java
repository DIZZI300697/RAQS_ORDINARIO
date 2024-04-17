package com.example.raqs_ordinario;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editTextUser;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextUser = findViewById(R.id.user);
        editTextPassword = findViewById(R.id.password);

        Button Inicio = findViewById(R.id.Inicio);
        Inicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = editTextUser.getText().toString();
                String password = editTextPassword.getText().toString();

                // Recuperar las credenciales almacenadas en SharedPreferences
                SharedPreferences preferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
                String savedUser = preferences.getString("usuario", "");
                String savedPassword = preferences.getString("contraseña", "");

                // Verificar si las credenciales coinciden
                if (user.equals(savedUser) && password.equals(savedPassword)) {
                    // Si las credenciales son correctas, iniciar MainActivity2 y pasar el nombre de usuario
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("username", user);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show();
                }

            }
        });

        // Configuración del OnClickListener para el botón "Crear Cuenta"
        Button crearCuentaButton = findViewById(R.id.crearcuenta);
        crearCuentaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir la actividad de registro (RegistroActivity)
                Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                startActivity(intent);
            }
        });
    }
}


