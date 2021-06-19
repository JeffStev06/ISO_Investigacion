package com.example.zapateria;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FragmentReportes extends Fragment {

    TextView txtTotal;
    TextView txtServicio;
    TextView txtCantidad;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vista =  inflater.inflate(R.layout.fragment_reportes, container, false);

        txtTotal=(TextView)vista.findViewById(R.id.txtTotal);
        txtServicio=(TextView)vista.findViewById(R.id.txtServicio);
        txtCantidad=(TextView)vista.findViewById(R.id.txtCantidad);

        txtTotal.setText("$31.10");
        txtCantidad.setText("Solicitudes: 4");
        txtServicio.setText("Cambio de suela");

        return vista;
    }
}