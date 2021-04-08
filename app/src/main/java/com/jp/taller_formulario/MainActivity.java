package com.jp.taller_formulario;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ib.custom.toast.CustomToastView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.regex.Pattern;

import models.Persona;

import static java.lang.Integer.parseInt;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Persona persona= new Persona();
    public static ArrayList<Persona> personas=new ArrayList();
    private Button btnAgregar;
    private EditText txtName;
    private EditText txtApellido;
    private EditText txtCargo;
    private EditText txtEdad;
    private EditText txtSalario;
    private EditText txtEmail;
    private FloatingActionButton btnAtras;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAgregar=findViewById(R.id.btnAdd);
        btnAtras=findViewById(R.id.btnAtras);
        txtName=findViewById(R.id.txtName);
        txtApellido=findViewById(R.id.txtApellido);
        txtCargo=findViewById(R.id.txtCargo);
        txtEdad=findViewById(R.id.txtEdad);
        txtSalario=findViewById(R.id.txtSalario);
        txtEmail=findViewById(R.id.txtEmail);
        btnAgregar.setOnClickListener(this);
        btnAtras.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnAdd) {
            String name = txtName.getText().toString();
            String apellido = txtApellido.getText().toString();
            String cargo = txtCargo.getText().toString();
            String salario = (txtSalario.getText().toString());
            String edad = txtEdad.getText().toString();
            String email = txtEmail.getText().toString();

            if (name.isEmpty()) {
                CustomToastView.makeInfoToast(this,"Error al validar nombre",R.layout.custom_toast).show();
                return;
            }
            if (apellido.isEmpty()) {
                CustomToastView.makeInfoToast(this,"Error al validar Apellido",R.layout.custom_toast).show();
                return;
            }
            if (cargo.isEmpty()) {
                CustomToastView.makeInfoToast(this,"Error al validar Cargo",R.layout.custom_toast).show();
                return;
            }
            if (salario.isEmpty()) {
                CustomToastView.makeInfoToast(this,"Error al validar Salario",R.layout.custom_toast).show();
                return;
            }
            if (edad.isEmpty()) {
                CustomToastView.makeInfoToast(this,"Error al validar Edad",R.layout.custom_toast).show();
                return;
            }
            if (!isValidEmail(email)) {
                CustomToastView.makeInfoToast(this,"Error al validar Email",R.layout.custom_toast).show();
                return;
            }

            Persona nperson;
            nperson=new Persona();
            nperson.setName(name);
            nperson.setApellido(apellido);
            nperson.setCargo(cargo);
            nperson.setSalario(parseInt(salario));
            nperson.setEdad(parseInt(edad));
            nperson.setEmail(email);
            personas.add(nperson);
            Intent intent= new Intent(this,Listado.class);
           // intent.putExtra("lista",personas);
            startActivity(intent);



            //intent.putExtra("listapersonas",personas);
            //startActivity(intent);

        }
        if (v.getId() == R.id.btnAtras) {
            Intent intent= new Intent(this,Inicial.class);
            // intent.putExtra("lista",personas);
            startActivity(intent);
        }

    }
    private Boolean isValidEmail(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();

    }
}

