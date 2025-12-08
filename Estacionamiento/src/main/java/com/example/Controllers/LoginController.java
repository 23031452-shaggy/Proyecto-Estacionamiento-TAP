package com.example.Controllers;

import com.example.DataAccess.AuthDAO;
import com.example.Models.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField txtIdentificador;
    @FXML private TextField txtPlaca;

    private final AuthDAO authDAO = new AuthDAO();

    @FXML
    public void onBtnIngresarClick() {
        String id = txtIdentificador.getText();
        String placa = txtPlaca.getText();

        if (authDAO.validarLogin(id, placa)) {
            UserSession.getInstance().setSession(placa, 0);
            abrirMenuPrincipal();
        } else {
            mostrarAlerta("Error", "Datos incorrectos o vehículo no corresponde.");
        }
    }

    private void abrirMenuPrincipal() {
        try {
            Stage stage = (Stage) txtPlaca.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/MenuView.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setScene(scene);
            stage.setTitle("Menú Principal");
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}