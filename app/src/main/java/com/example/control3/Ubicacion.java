package com.example.control3;

import java.io.Serializable;

public class Ubicacion implements Serializable {
    private String id, nombreUbi, latitud, longitud;

    public Ubicacion() {
        this.id = "999";
        this.nombreUbi = "Beach";
        this.latitud = "111";
        this.longitud = "222";
    }

    public Ubicacion(String id, String nombreUbi, String latitud, String longitud) {
        this.id = id;
        this.nombreUbi = nombreUbi;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreUbi() {
        return nombreUbi;
    }

    public void setNombreUbi(String nombreUbi) {
        this.nombreUbi = nombreUbi;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
}
