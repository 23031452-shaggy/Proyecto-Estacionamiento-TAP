package com.example.Controllers;

import com.example.DataAccess.OperacionesDAO;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MenuController {

    private final OperacionesDAO opDAO = new OperacionesDAO();

    @FXML
    public void onRegistrarEntradaClick(ActionEvent event) {
        try {
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/SeleccionEstacionamiento.fxml"));
            Scene scene = new Scene(fxmlLoader.load());

            stage.setScene(scene);
            stage.setTitle("Selección de Estacionamiento");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onRegistrarSalidaClick(ActionEvent event) {
        String resultado = opDAO.registrarSalida();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Salida");
        alert.setHeaderText(null);
        alert.setContentText(resultado);
        alert.showAndWait();
    }
}