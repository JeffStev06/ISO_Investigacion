package com.example.zapateria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    Context contexto;
    java.util.List<String> Lista;
    java.util.List<String> ListaSub;

    public ListAdapter(Context contexto, List<String> lista, List<String> listasub) {
        this.contexto = contexto;
        Lista = lista;
        ListaSub=listasub;
    }
    @Override
    public int getCount() {
        return Lista.size();
    }

    @Override
    public Object getItem(int i) {
        return Lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista = view;
        final LayoutInflater inflate = LayoutInflater.from(contexto);
        vista = inflate.inflate(R.layout.listado,null);
        TextView info = (TextView)vista.findViewById(R.id.txtListado);
        TextView subinfo = (TextView)vista.findViewById(R.id.txtListadoSub);
        info.setText(Lista.get(i));
        subinfo.setText(ListaSub.get(i));
        return vista;
    }
}
