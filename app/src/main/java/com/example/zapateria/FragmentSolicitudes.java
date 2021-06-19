package com.example.zapateria;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentSolicitudes extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{

    ListView listaPendientes, listaCompletadas;
    FloatingActionButton btnNuevaSolicitud;
    ArrayList<String> ListaSolicitudC=new ArrayList<>();
    ArrayList<String> ListaFechaC=new ArrayList<>();
    ArrayList<String> ListaServicioC=new ArrayList<>();
    ArrayList<String> ListaFacturadoC=new ArrayList<>();
    ArrayList<String> ListaPrecioC=new ArrayList<>();

    ArrayList<String> ListaSolicitudP=new ArrayList<>();
    ArrayList<String> ListaFechaP=new ArrayList<>();
    ArrayList<String> ListaServicioP=new ArrayList<>();

    RequestQueue rq;
    JsonRequest jrq;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vista =  inflater.inflate(R.layout.fragment_solicitudes, container, false);
        listaPendientes=(ListView)vista.findViewById(R.id.listaPendientes);
        listaCompletadas=(ListView)vista.findViewById(R.id.listaCompletadas);
        btnNuevaSolicitud=(FloatingActionButton)vista.findViewById(R.id.btnNuevaSolicitud);

        rq = Volley.newRequestQueue(getContext());
        CargarSolicitudesPendientes();
        CargarSolicitudesCompletadas();

        btnNuevaSolicitud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivityNuevaSolicitud.class);
                startActivity(intent);
            }
        });

        return vista;
    }


    public void CargarSolicitudesCompletadas(){

        ListaSolicitudC.add("#001 Juan Pérez");
        ListaFechaC.add("15/06/2021");
        ListaServicioC.add("Cambio de suela");
        ListaFacturadoC.add("18/06/2021");
        ListaPrecioC.add("2.50");

        ListaSolicitudC.add("#002 Guillermo Ventura");
        ListaFechaC.add("17/06/2021");
        ListaServicioC.add("Remiendo");
        ListaFacturadoC.add("18/06/2021");
        ListaPrecioC.add("5.20");
        MostrarCompletadas();
        /*String url ="https://www.pimentelycampos.com/php/solicitudes.php?estado=completadas";
        jrq = new JsonObjectRequest(Request.Method.GET, url, null,this, this);
        rq.add(jrq);*/
    }

    public void CargarSolicitudesPendientes(){
        ListaSolicitudP.add("#003 Fatima Gomez");
        ListaFechaP.add("18/06/2021");
        ListaServicioP.add("Cambio de tacón");
        MostrarPendientes();
        /*String url ="https://www.pimentelycampos.com/php/solicitudes.php?estado=pendientes";
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONArray jsonArray = response.optJSONArray("solicitudes");
                JSONObject jsonObject = null;

                try {
                    for (int i=0; i<jsonArray.length(); i++){
                        jsonObject = jsonArray.getJSONObject(i);
                        ListaSolicitudP.add("#" + jsonObject.getString("id_solicitud") + jsonObject.getString("cliente"));
                        ListaFechaP.add("fecha_creacion");
                        ListaServicioP.add("servicio");
                    }
                    MostrarPendientes();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        rq.add(jrq);*/

    }

    public void MostrarPendientes(){
        AdapterListaPendientes adapter = new AdapterListaPendientes(getContext(), ListaSolicitudP, ListaFechaP, ListaServicioP);
        listaPendientes.setAdapter(adapter);
    }
    public void MostrarCompletadas(){
        AdapterListaCompletadas adapter = new AdapterListaCompletadas(getContext(), ListaSolicitudC, ListaFechaC, ListaServicioC, ListaFacturadoC, ListaPrecioC);
        listaCompletadas.setAdapter(adapter);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
    }
}