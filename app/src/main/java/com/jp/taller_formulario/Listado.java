package com.jp.taller_formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import models.Persona;

public class Listado extends AppCompatActivity implements View.OnClickListener {

    private ListView lista;
    private FloatingActionButton btnAddList;
    private Button btnConsu;
    private Button btniInic;
    public static ArrayList<Persona> person = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);
        MainActivity main = new MainActivity();
        person = main.personas;
        //Log.d("TAG", "onCreate: "+person.get(0).getName());
         //datos=recorrerLista(person);
        lista = findViewById(R.id.lista);
        btnAddList=findViewById(R.id.btnAddLis);
        btniInic=findViewById(R.id.btnIni);
        btnConsu=findViewById(R.id.btncontas);
        btnConsu.setOnClickListener(this);
        btnAddList.setOnClickListener(this);
        ArrayAdapter<Persona>adapter=new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,recorrerLista(person));
        lista.setAdapter(adapter);
    }

   @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAddLis) {
            Intent intent= new Intent(this,MainActivity.class);
            // intent.putExtra("lista",personas);
            startActivity(intent);
        }
       if (v.getId() == R.id.btncontas) {
           Intent intent= new Intent(this,Comsultas.class);
           // intent.putExtra("lista",personas);
           startActivity(intent);
       }  if (v.getId() == R.id.btnIni) {
           Intent intent= new Intent(this,Inicial.class);
           // intent.putExtra("lista",personas);
           startActivity(intent);
       }

    }
    public List<String> recorrerLista(List<Persona> list){
       ArrayList<String> personcon = new ArrayList();
        for (int i=0;i<list.size();i++){
            personcon.add(list.get(i).getName()+" "+list.get(i).getApellido()+" "+list.get(i).getCargo()+
                    " "+list.get(i).getEdad()+"Años  $ "+list.get(i).getSalario()+" "+list.get(i).getEmail());


        }
    return personcon;
    }

}