package com.example.control3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConexionBD extends SQLiteOpenHelper {

    private final String scriptCrear = "CREATE TABLE usuario (id INTEGER, usuario TEXT, contraseña TEXT, nombre TEXT, apellido TEXT, genero TEXT)";
    private final String scriptCrear2 = "CREATE TABLE ubicacion (id INTEGER, nombre TEXT, latitud TEXT, longitud TEXT)";

    public ConexionBD(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(scriptCrear);
        db.execSQL(scriptCrear2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuario");
        db.execSQL("DROP TABLE IF EXISTS ubicacion");
        onCreate(db);
    }
}
