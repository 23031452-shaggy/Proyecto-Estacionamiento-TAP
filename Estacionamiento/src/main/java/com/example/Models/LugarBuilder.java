package com.example.Models;

public class LugarBuilder {
    private final int idLugar;
    private final int idEstacionamiento;
    private boolean estaOcupado = false;

    public LugarBuilder(int idLugar, int idEstacionamiento) {
        this.idLugar = idLugar;
        this.idEstacionamiento = idEstacionamiento;
    }

    public LugarBuilder setEstaOcupado(boolean estaOcupado) {
        this.estaOcupado = estaOcupado;
        return this;
    }

    public int getIdLugar() { return idLugar; }
    public int getIdEstacionamiento() { return idEstacionamiento; }
    public boolean isEstaOcupado() { return estaOcupado; }

    public Lugar build() {
        return new Lugar(this);
    }
}
