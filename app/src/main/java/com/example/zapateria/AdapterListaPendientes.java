package com.example.zapateria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterListaPendientes extends BaseAdapter {
    Context contexto;
    java.util.List<String> ListaSolicitud, ListaFecha, ListaServicio;

    public AdapterListaPendientes(Context contexto, List<String> listaSolicitud, List<String> listaFecha, List<String> listaServicio) {
        this.contexto = contexto;
        ListaSolicitud = listaSolicitud;
        ListaFecha=listaFecha;
        ListaServicio=listaServicio;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista = view;
        final LayoutInflater inflate = LayoutInflater.from(contexto);
        vista = inflate.inflate(R.layout.listado_pendientes,null);
        TextView solicitud = (TextView)vista.findViewById(R.id.txtSolicitud);
        TextView fecha = (TextView)vista.findViewById(R.id.txtFecha);
        TextView servicio = (TextView)vista.findViewById(R.id.txtServicio);
        solicitud.setText(ListaSolicitud.get(i));
        fecha.setText(ListaFecha.get(i));
        servicio.setText(ListaServicio.get(i));
        return vista;
    }
}
