package com.example.Models;

public class Lugar {
    private final int idLugar;
    private final int idEstacionamiento;
    private final boolean estaOcupado;

    public Lugar(LugarBuilder builder) {
        this.idLugar = builder.getIdLugar();
        this.idEstacionamiento = builder.getIdEstacionamiento();
        this.estaOcupado = builder.isEstaOcupado();
    }

    public int getIdLugar() { return idLugar; }
    public int getIdEstacionamiento() { return idEstacionamiento; }
    public boolean isEstaOcupado() { return estaOcupado; }
}
