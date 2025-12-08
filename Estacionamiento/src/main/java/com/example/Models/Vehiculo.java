package com.example.Models;

public class Vehiculo {
    private final String placa;
    private final int noContPropietario;
    private final String marca;
    private final String modelo;
    private final String color;

    public Vehiculo(VehiculoBuilder builder) {
        this.placa = builder.getPlaca();
        this.noContPropietario = builder.getNoContPropietario();
        this.marca = builder.getMarca();
        this.modelo = builder.getModelo();
        this.color = builder.getColor();
    }

    public String getPlaca() { return placa; }
    public int getNoContPropietario() { return noContPropietario; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getColor() { return color; }
}
