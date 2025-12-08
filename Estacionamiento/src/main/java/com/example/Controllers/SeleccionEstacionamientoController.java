package com.example.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.stage.Window;

public class SeleccionEstacionamientoController {

    @FXML
    public void onEstacionamientoAClick(ActionEvent event) {
        abrirMapaLugares(event, 1, "Estacionamiento A");
    }

    @FXML
    public void onEstacionamientoBClick(ActionEvent event) {
        abrirMapaLugares(event, 2, "Estacionamiento B");
    }

    @FXML
    public void onEstacionamientoCClick(ActionEvent event) {
        abrirMapaLugares(event, 3, "Estacionamiento C");
    }

    private void abrirMapaLugares(ActionEvent event, int idEst, String nombre) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/Views/MapaLugares.fxml"));
            Scene scene = new Scene(loader.load());

            MapaLugaresController controller = loader.getController();
            controller.initData(idEst, nombre);

            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();

            stage.setScene(scene);
            stage.setTitle(nombre);

        } catch (Exception e) { e.printStackTrace(); }
    }
}
