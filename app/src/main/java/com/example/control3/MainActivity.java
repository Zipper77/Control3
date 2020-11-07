package com.example.control3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView usuario, contraseña, nombre, apellido, genero;
    ArrayList<Usuario> lista;
    ConexionBD conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = (TextView) findViewById(R.id.usuario);
        contraseña = (TextView) findViewById(R.id.contrasena);
        nombre = (TextView) findViewById(R.id.nombre);
        apellido = (TextView) findViewById(R.id.apellido);
        genero = (TextView) findViewById(R.id.genero);
        conexion = new ConexionBD(this, "BDarica", null, 1);
        lista = dbList();
    }

    public void registrarUsuario(View view){
        SQLiteDatabase base1 = conexion.getReadableDatabase();
        int cant = (int) DatabaseUtils.queryNumEntries(base1, "usuario");
        SQLiteDatabase base2 = conexion.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("id", cant+1);
        valores.put("usuario", ""+usuario.getText());
        valores.put("contraseña", ""+contraseña.getText());
        valores.put("nombre", ""+nombre.getText());
        valores.put("apellido", ""+apellido.getText());
        valores.put("genero", ""+genero.getText());
        long resultado = base2.insert("usuario", "id", valores);

        Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_SHORT).show();
    }

    public void ingresarUsuario(View view){
        try{
            lista.get(0);
            Intent intento = new Intent(getApplicationContext(), ActivityUbicacion.class);
            startActivity(intento);
        } catch (Exception ex){
            Toast.makeText(this, "Opps, Registrate!!!", Toast.LENGTH_SHORT).show();
        }

    }

    public ArrayList<Usuario> dbList(){
        ArrayList<Usuario> listita = new ArrayList<>();
        SQLiteDatabase base = conexion.getReadableDatabase();
        String[] columnas = {"id", "usuario", "contraseña", "nombre", "apellido", "genero"};

        Cursor c = base.query("usuario", columnas, null, null, null, null, null);
        while (c.moveToNext()){
            Usuario u = new Usuario(""+c.getInt(0), ""+c.getString(1), ""+c.getString(2), ""+c.getString(3), ""+c.getString(4), ""+c.getString(5));
            listita.add(u);
        }
        return listita;
    }
}