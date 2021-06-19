package com.example.zapateria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivityNuevaSolicitud extends AppCompatActivity {

    Spinner listaClientes, listaServicios;
    EditText Descripcion;

    ArrayList<String> ListaClientes=new ArrayList<>();
    ArrayList<String> ListaServicios=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nueva_solicitud);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaClientes=(Spinner)findViewById(R.id.listaClientes);
        listaServicios=(Spinner)findViewById(R.id.listaServicios);
        Descripcion=(EditText)findViewById(R.id.Descripcion);

        CargarClientes();
        CargarServicios();
    }

    public void CargarClientes(){
        ListaClientes.add("Seleccionar cliente");
        ListaClientes.add("Juan Pérez");
        ListaClientes.add("Guillermo Ventura");
        ListaClientes.add("Fatima Gomez");

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ListaClientes);
        listaClientes.setAdapter(adapter);
    }

    public void CargarServicios(){
        ListaServicios.add("Cambio de suela");
        ListaServicios.add("Remiendo");
        ListaServicios.add("Cambio de tacón");

        ArrayAdapter<CharSequence> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,ListaServicios);
        listaServicios.setAdapter(adapter);
    }
}