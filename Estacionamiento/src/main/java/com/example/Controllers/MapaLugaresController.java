package com.example.Controllers;

import com.example.DataAccess.OperacionesDAO;
import com.example.Models.Lugar;
import com.example.Utils.AlertaUtils;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.util.List;
import java.util.Optional;

public class MapaLugaresController {

    @FXML private TilePane panelLugares;
    @FXML private Button btnRegresar;

    private int idEstacionamientoActual;
    private final OperacionesDAO opDAO = new OperacionesDAO();

    public void initData(int idEstacionamiento, String titulo) {
        this.idEstacionamientoActual = idEstacionamiento;
        cargarLugares();
    }

    private void cargarLugares() {
        panelLugares.getChildren().clear();
        List<Lugar> lugares = opDAO.obtenerLugares(idEstacionamientoActual);

        for (Lugar lugar : lugares) {
            Button btn = new Button(String.valueOf(lugar.getIdLugar()));
            btn.setPrefSize(50, 50);

            if (lugar.isEstaOcupado()) {
                btn.setStyle("-fx-background-color: grey; -fx-text-fill: white;");
                btn.setDisable(true);
            } else {
                btn.setStyle("-fx-background-color: lightgreen; -fx-cursor: hand;");
                btn.setOnAction(e -> confirmarOcupacion(lugar.getIdLugar()));
            }
            panelLugares.getChildren().add(btn);
        }
    }

    private void confirmarOcupacion(int idLugar) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar lugar");
        alert.setHeaderText("¿Deseas tomar el lugar " + idLugar + "?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            boolean exito = opDAO.registrarEntrada(idLugar, idEstacionamientoActual);

            if (exito) {
                AlertaUtils.mostrarInfo("Entrada marcada con éxito");
                cargarLugares();
            } else {
                AlertaUtils.mostrarInfo("Error al registrar entrada");
            }
        }
    }

    @FXML
    public void onRegresarClick(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/SeleccionEstacionamiento.fxml"));
            Scene scene = new Scene(loader.load());
            Node source = (Node) event.getSource();
            Stage stage = (Stage) source.getScene().getWindow();

            stage.setScene(scene);
        } catch (Exception e) { e.printStackTrace(); }
    }
}