package com.example.zapateria;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityNuevoCliente extends AppCompatActivity {
    EditText Nombre, Apellido, Email, Telefono;
    Button btnIngresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nuevo_cliente);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Nombre=(EditText)findViewById(R.id.Nombre);
        Apellido=(EditText)findViewById(R.id.Apellido);
        Email=(EditText)findViewById(R.id.Email);
        Telefono=(EditText)findViewById(R.id.Telefono);
        btnIngresar=(Button)findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivityNuevoCliente.this, "Datos guardados", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }
}