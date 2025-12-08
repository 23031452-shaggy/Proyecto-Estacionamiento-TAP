package com.example.Models;

public class Persona {
    private final int noCont;
    private final String nombre;
    private final String telefono;

    public Persona(PersonaBuilder builder) {
        this.noCont = builder.getNoCont();
        this.nombre = builder.getNombre();
        this.telefono = builder.getTelefono();
    }

    public int getNoCont() { return noCont; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }
}

