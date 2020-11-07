package com.example.control3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityUbicacion extends AppCompatActivity {

    TextView nombreUbi, latitud, longitud;
    ConexionBD conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubicacion);

        nombreUbi = (TextView) findViewById(R.id.nombreUbicacion);
        latitud = (TextView) findViewById(R.id.latitud);
        longitud = (TextView) findViewById(R.id.longitud);
        conexion = new ConexionBD(this, "BDarica", null, 1);
    }

    public void guardarUbicacion(View view){
        SQLiteDatabase base1 = conexion.getReadableDatabase();
        int cant = (int) DatabaseUtils.queryNumEntries(base1,"ubicacion");
        SQLiteDatabase base2 = conexion.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("id", cant+1);
        valores.put("nombre", nombreUbi.getText().toString());
        valores.put("latitud",latitud.getText().toString());
        valores.put("longitud", longitud.getText().toString());
        long resultado = base2.insert("ubicacion", "id", valores);
        Toast.makeText(this, "Ubicación Registrada", Toast.LENGTH_SHORT).show();
    }

    public void verUbicaciones(View view){
        Intent intento = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intento);
    }
}