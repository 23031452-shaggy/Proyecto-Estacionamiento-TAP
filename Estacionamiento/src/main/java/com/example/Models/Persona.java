package com.example.Models;

public class Persona {
    private final int noCont;
    private final String nombre;
    private final String telefono;

    // Constructor privado
    private Persona(PersonaBuilder builder) {
        this.noCont = builder.noCont;
        this.nombre = builder.nombre;
        this.telefono = builder.telefono;
    }

    public int getNoCont() { return noCont; }
    public String getNombre() { return nombre; }
    public String getTelefono() { return telefono; }

    public static class PersonaBuilder {
        private int noCont;
        private String nombre;
        private String telefono;

        public PersonaBuilder(int noCont, String nombre) {
            this.noCont = noCont;
            this.nombre = nombre;
        }

        public PersonaBuilder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Persona build() {
            return new Persona(this);
        }
    }
}