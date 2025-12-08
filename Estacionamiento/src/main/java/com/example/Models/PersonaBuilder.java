package com.example.Models;

public class PersonaBuilder {
    private final int noCont;
    private String nombre;
    private String telefono;

    public PersonaBuilder(int noCont) {
        this.noCont = noCont;
    }

    public PersonaBuilder setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PersonaBuilder setTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public int getNoCont() { return noCont; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }

    public Persona build() {
        return new Persona(this);
    }
}
