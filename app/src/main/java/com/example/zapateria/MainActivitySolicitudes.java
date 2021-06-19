package com.example.zapateria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivitySolicitudes extends AppCompatActivity {

    FragmentTransaction transaction;
    Fragment fragmentSolicitudes, fragmentClientes, fragmentReportes;
    Button btnClientes;
    Button btnSolicitudes;
    Button btnReportes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_solicitudes);

        btnClientes=(Button)findViewById(R.id.btnClientes);
        btnSolicitudes=(Button)findViewById(R.id.btnSolicitudes);
        btnReportes=(Button)findViewById(R.id.btnReportes);

        fragmentClientes=new FragmentClientes();
        fragmentSolicitudes=new FragmentSolicitudes();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor,fragmentSolicitudes).commit();
        //transaction=getSupportFragmentManager().beginTransaction();

        btnClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //transaction.replace(R.id.contenedor,fragmentClientes).commit();
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragmentClientes).commit();
            }
        });

        btnSolicitudes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragmentSolicitudes).commit();
            }
        });

        btnReportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor,fragmentReportes).commit();
            }
        });
    }
}