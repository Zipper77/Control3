package com.example.control3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registrarUsuario(View view){
        Intent intento = new Intent(getApplicationContext(), ActivityRegistrar.class);
        startActivity(intento);
    }

    public void ingresarUsuario(View view){
        Intent intento = new Intent(getApplicationContext(), );
        startActivity(intento);
    }
}