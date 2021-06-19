package com.example.zapateria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity implements Response.Listener<JSONObject>, Response.ErrorListener{

    Button btnEntrar;
    EditText Usuario;
    EditText Clave;

    RequestQueue rq;
    JsonRequest jrq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rq = Volley.newRequestQueue(MainActivity.this);

        btnEntrar=(Button)findViewById(R.id.btnEntrar);
        Usuario=(EditText)findViewById(R.id.Usuario);
        Clave=(EditText)findViewById(R.id.Clave);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IniciarSesion();
            }
        });
    }

    public void IniciarSesion(){
        if (Usuario.getText().toString().isEmpty() || Clave.getText().toString().isEmpty()){
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_SHORT).show();
        }
        else {
            String url ="https://www.pimentelycampos.com/php/inicio.php?user="+Usuario.getText().toString();
            jrq = new JsonObjectRequest(Request.Method.GET, url, null,this, this);
            rq.add(jrq);
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this, error.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        JSONArray jsonArray = response.optJSONArray("clave");
        JSONObject jsonObject = null;
        String clave = "";
        try {
            jsonObject = jsonArray.getJSONObject(0);
            clave = jsonObject.getString("clave");
            Validar(clave);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void Validar(String clave){
        if (clave.contentEquals(Clave.getText().toString())){
            Intent intent = new Intent(MainActivity.this, MainActivitySolicitudes.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Usuario y contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}