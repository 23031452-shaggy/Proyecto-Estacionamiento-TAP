package com.example.Models;

public class VehiculoBuilder {
    private final String placa;
    private final int noContPropietario;
    private String marca;
    private String modelo;
    private String color;

    public VehiculoBuilder(String placa, int noContPropietario) {
        this.placa = placa;
        this.noContPropietario = noContPropietario;
    }

    public VehiculoBuilder setMarca(String marca) { this.marca = marca; return this; }
    public VehiculoBuilder setModelo(String modelo) { this.modelo = modelo; return this; }
    public VehiculoBuilder setColor(String color) { this.color = color; return this; }

    public String getPlaca() { return placa; }
    public int getNoContPropietario() { return noContPropietario; }
    public String getMarca() { return marca; }
    public String getModelo() { return modelo; }
    public String getColor() { return color; }

    public Vehiculo build() { return new Vehiculo(this); }
}
