package com.example.Controllers;

import com.example.DataAccess.OperacionesDAO;
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
    public void onRegistrarEntradaClick() {
        try {
            Stage stage = (Stage) new Button().getScene().getWindow();

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/Views/SeleccionEstacionamiento.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage currentStage = (Stage) Stage.getWindows().stream().filter(Window::isShowing).findFirst().orElse(null);
            if(currentStage != null) currentStage.setScene(scene);

        } catch (Exception e) { e.printStackTrace(); }
    }

    @FXML
    public void onRegistrarSalidaClick() {
        String resultado = opDAO.registrarSalida();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Salida");
        alert.setHeaderText(null);
        alert.setContentText(resultado);
        alert.showAndWait();
    }
}