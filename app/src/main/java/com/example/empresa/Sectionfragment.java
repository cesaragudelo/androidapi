package com.example.empresa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;

import org.json.JSONObject;


public class Sectionfragment extends Fragment implements Response.Listener<JSONObject>,Response.ErrorListener  {


    EditText jetcorreo,jetclave;
    Button jbtingresar;
    TextView jtvregistrar;
    RequestQueue rq;
    JsonRequest jrq;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_sectionfragment, container, false);
        //Asociar objetos
        View vista = inflater.inflate(R.layout.fragment_sectionfragment,container,false);
        jetcorreo = vista.findViewById(R.id.etcorreo);
        jetclave = vista.findViewById(R.id.etclave);
        jbtingresar = vista.findViewById(R.id.btingresar);
        jtvregistrar=vista.findViewById(R.id.tvregistrar);
        jbtingresar.setOnClickListener(new  View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }


        });
        return vista;


    }

    public void  Iniciar_sesion(){
        String correo,clave;
        correo=jetcorreo.getText().toString();
        clave=jetclave.getText().toString();
        if (correo.isEmpty() || clave.isEmpty()){
            Toast.makeText(getContext(), "correo y clave son requeridos", Toast.LENGTH_SHORT).show();
            jetcorreo.requestFocus();
        }
        else {
            String url = "http://172.16.58.58/WebServices/Sesion.php/sesion.php?correo=" + correo + "&clave=" + clave;
            jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
            rq.add(jrq);
        }

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "error en inicio de sesion", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getContext(), "mela la vuelta", Toast.LENGTH_SHORT).show();
    }
}