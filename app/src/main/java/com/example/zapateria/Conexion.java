package com.example.zapateria;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

import java.util.List;

public class Conexion implements Response.Listener<JSONObject>, Response.ErrorListener{

    Context contexto;

    public Conexion(Context contexto, List<String> lista, List<String> listasub) {
        this.contexto = contexto;
        //Lista = lista;
        //ListaSub=listasub;
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
