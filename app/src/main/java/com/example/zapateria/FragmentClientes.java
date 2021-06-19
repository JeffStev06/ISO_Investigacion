package com.example.zapateria;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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
import java.util.List;

public class FragmentClientes extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{

    ListView listView;
    FloatingActionButton btnNuevoCliente;
    ArrayList<String> ListaClientes=new ArrayList<>();
    ArrayList<String> ListaNombres=new ArrayList<>();
    ArrayList<String> ListaClientesInfo=new ArrayList<>();
    ArrayList<String> ListaEstado=new ArrayList<>();
    int p = 0;
    int c = 0;
    RequestQueue rq;
    JsonRequest jrq;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vista =  inflater.inflate(R.layout.fragment_clientes, container, false);
        listView=(ListView)vista.findViewById(R.id.listaClientes);
        btnNuevoCliente=(FloatingActionButton)vista.findViewById(R.id.btnNuevoCliente);

        rq = Volley.newRequestQueue(getContext());

        CargarClientes();

        btnNuevoCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MainActivityNuevoCliente.class);
                startActivity(intent);
            }
        });

        return vista;
    }

    public void CargarClientes(){
        ListaNombres.add("Juan Pérez");
        ListaNombres.add("Fatima Gomez");
        ListaNombres.add("Guillermo Ventura");

        ListaClientesInfo.add("Solicitudes activas: 0  Solicitudes finalizadas: 1");
        ListaClientesInfo.add("Solicitudes activas: 1  Solicitudes finalizadas: 3");
        ListaClientesInfo.add("Solicitudes activas: 0  Solicitudes finalizadas: 2");

        MostrarClientes();
    }

    public void MostrarClientes(){
        ListAdapter adapter = new ListAdapter(getContext(), ListaNombres, ListaClientesInfo);
        listView.setAdapter(adapter);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        /*JSONArray jsonArray = response.optJSONArray("clientes");
        JSONObject jsonObject = null;

        try {
            for (int i=0; i<jsonArray.length(); i++){
                jsonObject = jsonArray.getJSONObject(i);
                ListaClientes.add(jsonObject.getString("id_cliente"));
                ListaNombres.add("nombre");
            }
            CargarInfo();
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }
    public void CargarInfo(){
        /*p=0;
        c=0;
        for (int i = 0; i<ListaClientes.size();i++){
            String url ="https://www.pimentelycampos.com/php/solicitudes.php?cliente="+ListaClientes.get(i);
            jrq = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    JSONArray jsonArray = response.optJSONArray("nombres");
                    JSONObject jsonObject = null;
                    try {
                        for (int i=0; i<jsonArray.length(); i++){
                            jsonObject = jsonArray.getJSONObject(i);
                            ListaEstado.add(jsonObject.getString("estado"));
                            if (ListaEstado.get(i).contentEquals("pendiente")){
                                p++;
                            }else {
                                c++;
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                }
            });
            rq.add(jrq);
        }
        CargarLista();*/
    }
    public void CargarLista(){
        /*for (int i = 0; i < ListaClientes.size(); i++){
            ListaClientesInfo.add("Solicitudes activas: " + p + "  Solicitudes finalizadas: " + c);
        }
        MostrarClientes();*/
    }
}