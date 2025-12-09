package com.example.Controllers;

import com.example.DataAccess.AuthDAO;
import com.example.Models.UserSession;
import com.example.Utils.AlertaUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField txtIdentificador;
    @FXML private TextField txtPlaca;
    @FXML private PasswordField txtPassword;

    private final AuthDAO authDAO = new AuthDAO();

    @FXML
    public void onBtnIngresarClick() {
        String id = txtIdentificador.getText();
        String placa = txtPlaca.getText();
        String pass = txtPassword.getText();
        if (id.isEmpty() || placa.isEmpty() || pass.isEmpty()) {
            AlertaUtils.mostrarAlerta("Campos vacíos", "Por favor llene todos los campos.");
            return;
        }
        if (authDAO.validarLogin(id, placa, pass)) {
            UserSession.getInstance().setSession(placa, 0);
            abrirMenuPrincipal();
        } else {
            AlertaUtils.mostrarAlerta("Error", "Datos incorrectos o vehículo no corresponde.");
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

}