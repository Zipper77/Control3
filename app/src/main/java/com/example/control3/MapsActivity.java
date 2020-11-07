package com.example.control3;

import androidx.fragment.app.FragmentActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private String nombreUbi, latitud, longitud;
    ConexionBD conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intento = getIntent();
        nombreUbi = intento.getStringExtra("nombre");
        latitud = intento.getStringExtra("latitud");
        longitud = intento.getStringExtra("longitud");
        conexion = new ConexionBD(this, "BDarica", null, 1);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        ArrayList<Marker> lista = retrieveMarkers(mMap);

/*
        LatLng ubicacionNueva = new LatLng(Double.parseDouble(latitud), Double.parseDouble(longitud));
        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);

        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.addMarker(new MarkerOptions().position(ubicacionNueva).title(nombreUbi));

        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(ubicacionNueva));
        */

    }

    public ArrayList<Marker> retrieveMarkers(GoogleMap map){
        ArrayList<Marker> tempList = new ArrayList<>();
        SQLiteDatabase base = conexion.getReadableDatabase();
        String[] columnas = {"id", "nombre", "latitud", "longitud"};
        Cursor c = base.query("ubicacion", columnas, null, null, null, null, null);
        while(c.moveToNext()){
            LatLng posicion = new LatLng(Double.parseDouble(c.getString(2)), Double.parseDouble(c.getString(3)));
            Marker u = mMap.addMarker(new MarkerOptions().position(posicion).title(c.getString(1)));
            tempList.add(u);
        }
        return tempList;
    }

}