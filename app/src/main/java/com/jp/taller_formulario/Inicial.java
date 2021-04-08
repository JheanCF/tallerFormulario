package com.jp.taller_formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Inicial extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton btnAgregar;
    private Button btnListar;
    private Button btnConsultas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);
        btnAgregar=findViewById(R.id.btnAgregar);
        btnListar=findViewById(R.id.btnListar);
        btnConsultas=findViewById(R.id.btnConsultas);
        btnAgregar.setOnClickListener(this);
        btnListar.setOnClickListener(this);
        btnConsultas.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAgregar){
            Intent intent= new Intent(this,MainActivity.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.btnListar){
            Intent intent= new Intent(this,Listado.class);
            startActivity(intent);
        }
        if(v.getId() == R.id.btnConsultas){
            Intent intent= new Intent(this,Comsultas.class);
            startActivity(intent);
        }
    }
}