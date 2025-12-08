package com.example.Models;

public class UserSession {
    private static UserSession instance;
    private String placaActual;
    private int noControlActual;

    private UserSession() {}

    public static UserSession getInstance() {
        if(instance == null) instance = new UserSession();
        return instance;
    }

    public void setSession(String placa, int noControl) {
        this.placaActual = placa;
        this.noControlActual = noControl;
    }

    public String getPlacaActual() { return placaActual; }
    public void cleanSession() { placaActual = null; noControlActual = 0; }
}
