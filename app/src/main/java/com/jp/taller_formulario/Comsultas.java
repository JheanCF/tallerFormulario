package com.jp.taller_formulario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import models.Persona;

public class Comsultas extends AppCompatActivity implements View.OnClickListener {
private Button btnJoven;
private Button btnVieja;
private Button btnSalario;
private Button btnCargo;
private Button btnInicioCon;
private FloatingActionButton btnAddCon;
private TextView txtResult;
    public static ArrayList<Persona> personCon = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comsultas);
        btnJoven=findViewById(R.id.btnJoven);
        btnVieja=findViewById(R.id.btnViejo);
        btnSalario=findViewById(R.id.btnSalarios);
        btnCargo=findViewById(R.id.btnCargo);
        btnInicioCon=findViewById(R.id.btnInicioCon);
        btnAddCon=findViewById(R.id.btnAddCon);
        txtResult=findViewById(R.id.txtResult);
        btnJoven.setOnClickListener(this);
        btnVieja.setOnClickListener(this);
        btnSalario.setOnClickListener(this);
        btnCargo.setOnClickListener(this);
        btnInicioCon.setOnClickListener(this);
        btnAddCon.setOnClickListener(this);
        Listado main =new Listado();

        personCon=main.person;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnJoven){
           personaJoven(personCon);
        } if(v.getId() == R.id.btnViejo){
           personaVeija(personCon);
        }
        if(v.getId() == R.id.btnSalarios){
           promediosSalario(personCon);
        }
        if(v.getId() == R.id.btnCargo){
          List<String> prueba = new ArrayList();
            prueba=cargos(personCon);
            comparacionCargo(personCon,prueba);
        }
        if (v.getId() == R.id.btnAddCon) {
            Intent intent= new Intent(this,MainActivity.class);
            // intent.putExtra("lista",personas);
            startActivity(intent);
        }
        if (v.getId() == R.id.btnInicioCon) {
            Intent intent= new Intent(this,Inicial.class);
            // intent.putExtra("lista",personas);
            startActivity(intent);
        }
    }
    public void personaJoven(List<Persona> list) {
        int edad = 100;
        String joven = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getEdad() < edad) {
                edad = list.get(i).getEdad();
                joven = "Persona mas Joven\n" + list.get(i).getName() + " " + list.get(i).getApellido() + " " + list.get(i).getCargo() +
                        " " + list.get(i).getEdad() + "Años  $ " + list.get(i).getSalario() + " " + list.get(i).getEmail();
            }

        }
        txtResult.setText(joven);
    }
        public void personaVeija(List<Persona> list){
            int edad=0;
            String joven="";
            for (int i=0;i<list.size();i++){
                if (list.get(i).getEdad()>edad){
                    edad = list.get(i).getEdad();
                    joven="Persona mas Mayor\n"+list.get(i).getName()+" "+list.get(i).getApellido()+" "+list.get(i).getCargo()+
                            " "+list.get(i).getEdad()+"Años  $"+list.get(i).getSalario()+" "+list.get(i).getEmail();
                }

            }
            txtResult.setText(joven);

        }

    public void promediosSalario(List<Persona> list){
        int max=0;
        int min=9999999;
        int sumapromedio=0;
        int promedio=0;
        String mayor="";
        String menor="";
        for (int i=0;i<list.size();i++){
            if (list.get(i).getSalario()>max){
                max = list.get(i).getSalario();
                mayor=" Salario Maximo "+list.get(i).getName()+" "+list.get(i).getApellido()+"   $"+list.get(i).getSalario()+"\n";
            }

            if (list.get(i).getSalario()<min){
                min = list.get(i).getSalario();
                menor=" Salario Minimo "+list.get(i).getName()+" "+list.get(i).getApellido()+"   $"+list.get(i).getSalario()+"\n";
            }
            sumapromedio=sumapromedio+list.get(i).getSalario();
        }
        int size=list.size();
        promedio=sumapromedio/size;
        String result=mayor+menor+"\n"+" Promedio de salarios "+promedio;
        txtResult.setText(result);

    }
    public List<String> cargos(List<Persona> list){
        ArrayList<String> cargos = new ArrayList();
        for (int i=0;i<list.size();i++){
            if(!cargos.contains(list.get(i).getCargo())) {
                cargos.add(list.get(i).getCargo());
            }
        }
     return cargos;

    }
    public void comparacionCargo(List<Persona> list,List<String>cargo) {
        Collections.sort(list,(o1,o2)->o1.getCargo().compareTo(o2.getCargo()));

        for (int j = 0; j < cargo.size(); j++) {
            int contador = 0;
            int sumaC=0;
            String car="";
             for (int i = 0; i < list.size(); i++) {
                if (cargo.get(j).equals(list.get(i).getCargo())) {
                    contador++;
                    car=list.get(i).getCargo();
                    sumaC=sumaC+list.get(i).getSalario();
                }


             }

            Log.d("TAG", car+" "+contador + ""+(sumaC/contador));
             String result=txtResult.getText().toString()+" Cargo: "+car+" N° personas: "+contador + " Promedio Salarial: "+(sumaC/contador);
            txtResult.setText(result);
        }

    }
}