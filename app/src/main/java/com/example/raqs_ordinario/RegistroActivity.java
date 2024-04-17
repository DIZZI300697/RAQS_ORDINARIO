package com.example.raqs_ordinario;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroActivity extends AppCompatActivity {
    EditText editTextUsuario;
    EditText editTextContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        editTextUsuario = findViewById(R.id.usuario);
        editTextContraseña = findViewById(R.id.contraseña);

        Button registroButton = findViewById(R.id.crearcuenta);
        registroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = editTextUsuario.getText().toString();
                String contraseña = editTextContraseña.getText().toString();

                // Guardar las credenciales en SharedPreferences
                SharedPreferences preferences = getSharedPreferences("my_preferences", MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("usuario", usuario);
                editor.putString("contraseña", contraseña);
                editor.apply();

                // Informar al usuario que la cuenta se ha creado
                Toast.makeText(RegistroActivity.this, "Cuenta creada exitosamente", Toast.LENGTH_SHORT).show();

                // Abrir MainActivity y finalizar esta actividad
                Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finalizar RegistroActivity para volver a MainActivity
            }
        });

        // Configuración del OnClickListener para el botón "Regresar"
        Button regresarButton = findViewById(R.id.regresar);
        regresarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finalizar esta actividad (RegistroActivity) y volver a MainActivity
                finish();
            }
        });
    }
}
