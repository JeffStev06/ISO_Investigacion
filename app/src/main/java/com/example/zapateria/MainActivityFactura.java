package com.example.zapateria;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivityFactura extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    ListView listaDetalle;
    TextView Solicitud;
    TextView txtCliente;
    TextView txtFecha;
    TextView txtTotal;
    ArrayList<String> ListaDetalle=new ArrayList<>();
    ArrayList<String> ListaAux=new ArrayList<>();
    Variables variables = new Variables();

    RequestQueue rq;
    JsonRequest jrq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_factura);

        listaDetalle=(ListView)findViewById(R.id.listaDetalle);
        Solicitud=(TextView)findViewById(R.id.txtSolicitud);
        txtFecha=(TextView)findViewById(R.id.txtFecha);
        txtTotal=(TextView)findViewById(R.id.txtTotal);
        Solicitud.setText(variables.getCodeSolicitud());
        txtFecha.setText(variables.getFecha());
        txtTotal.setText(variables.getNombre());

        rq = Volley.newRequestQueue(MainActivityFactura.this);

        CargarDetalle();
    }

    public void CargarDetalle(){
        /*String url ="https://www.pimentelycampos.com/php/factura.php?id="+variables.getCodeSolicitud();
        jrq = new JsonObjectRequest(Request.Method.GET, url, null,this, this);
        rq.add(jrq);*/

        ListaDetalle.add("Servicio de zapateria");
        ListaAux.add("");

        MostrarDetalle();
    }

    public void MostrarDetalle(){
        ListAdapter adapter = new ListAdapter(MainActivityFactura.this, ListaDetalle, ListaAux);
        listaDetalle.setAdapter(adapter);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        /*JSONArray jsonArray = response.optJSONArray("factura");
        JSONObject jsonObject = null;
        String clave = "";
        try {
            jsonObject = jsonArray.getJSONObject(0);
            txtCliente.setText(jsonObject.getString("cliente"));
            txtFecha.setText(jsonObject.getString("fecha_fin"));
            txtTotal.setText(jsonObject.getString("total"));
            ListaAux.add("");
            ListaDetalle.add(jsonObject.getString("servicio"));

            MostrarDetalle();
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }
}