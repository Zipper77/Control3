package com.example.control3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityRegistrar extends AppCompatActivity {

    TextView usuario, contraseña, nombre, apellido, genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        usuario = (TextView) findViewById(R.id.usuario);
        contraseña = (TextView) findViewById(R.id.contrasena);
        nombre = (TextView) findViewById(R.id.nombre);
        apellido = (TextView) findViewById(R.id.apellido);
        genero = (TextView) findViewById(R.id.genero);
    }

    public void guardarUsuario(View view){

    }
}