package com.example.Utils;

import javafx.scene.control.Alert;

public class AlertaUtils {
    public static <T, V> void mostrarAlerta(T titulo, V mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo.toString());
        alert.setHeaderText(null);
        alert.setContentText(mensaje.toString());

        alert.showAndWait();
    }

    public static <T> void mostrarInfo(T mensaje) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(mensaje.toString());
        a.show();
    }
}