package com.example.control3;

import java.io.Serializable;

public class Usuario implements Serializable {

    private String id, usuario, contraseña, nombre, apellido, genero;

    public Usuario() {
        this.id = "666";
        this.usuario = "Louise";
        this.contraseña = "Cuchicopi";
        this.nombre = "Louise";
        this.apellido = "Belcheler";
        this.genero = "Femenino";
    }

    public Usuario(String id, String usuario, String contraseña, String nombre, String apellido, String genero) {
        this.id = id;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
