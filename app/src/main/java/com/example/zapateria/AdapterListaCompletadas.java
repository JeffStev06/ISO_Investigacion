package com.example.zapateria;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class AdapterListaCompletadas extends BaseAdapter {
    Variables variables = new Variables();
    Context contexto;
    java.util.List<String> ListaSolicitud, ListaFecha, ListaServicio, ListaFechaFacturado, ListaPrecio;

    public AdapterListaCompletadas(Context contexto, List<String> listaSolicitud, List<String> listaFecha, List<String> listaServicio, List<String> listaFechaFacturado, List<String> listaPrecio) {
        this.contexto = contexto;
        ListaSolicitud = listaSolicitud;
        ListaFecha=listaFecha;
        ListaServicio=listaServicio;
        ListaFechaFacturado = listaFechaFacturado;
        ListaPrecio=listaPrecio;
    }
    @Override
    public int getCount() {
        return ListaSolicitud.size();
    }

    @Override
    public Object getItem(int i) {
        return ListaSolicitud.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View vista = view;
        final LayoutInflater inflate = LayoutInflater.from(contexto);
        vista = inflate.inflate(R.layout.listado_solicitudes,null);
        final TextView solicitud = (TextView)vista.findViewById(R.id.txtSolicitud);
        TextView fecha = (TextView)vista.findViewById(R.id.txtFecha);
        TextView servicio = (TextView)vista.findViewById(R.id.txtServicio);
        TextView facturado = (TextView)vista.findViewById(R.id.txtFacturado);
        TextView total = (TextView)vista.findViewById(R.id.txtTotal);
        FloatingActionButton btnDetalle = (FloatingActionButton)vista.findViewById(R.id.detalle);
        solicitud.setText(ListaSolicitud.get(i));
        fecha.setText(ListaFecha.get(i));
        servicio.setText(ListaServicio.get(i));
        facturado.setText(ListaFechaFacturado.get(i));
        total.setText(ListaPrecio.get(i));

        btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                variables.setCodeSolicitud(ListaSolicitud.get(i));
                variables.setFecha(ListaFecha.get(i));
                variables.setFecha(ListaPrecio.get(i));
                Intent intent = new Intent(contexto, MainActivityFactura.class);
                contexto.startActivity(intent);
            }
        });
        return vista;
    }
}
