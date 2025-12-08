package com.example.DataAccess;

import com.example.Models.Lugar;
import com.example.Models.LugarBuilder;
import com.example.Models.UserSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OperacionesDAO {
    private final Connection con = DatabaseConnection.getInstance().getConnection();

    public List<Lugar> obtenerLugares(int idEstacionamiento) {
        List<Lugar> lista = new ArrayList<>();
        String sql = "SELECT * FROM Lugares WHERE id_estacionamiento = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, idEstacionamiento);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Lugar lugar = new LugarBuilder(
                        rs.getInt("id_lugar"),
                        rs.getInt("id_estacionamiento")
                ).setEstaOcupado(rs.getBoolean("esta_ocupado")).build();
                lista.add(lugar);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return lista;
    }

    public boolean registrarEntrada(int idLugar, int idEstacionamiento) {
        String placa = UserSession.getInstance().getPlacaActual();

        try {
            con.setAutoCommit(false);
            String sqlReg = "INSERT INTO Registros (placa_vehiculo, id_lugar, id_estacionamiento, fecha_hora_entrada) VALUES (?, ?, ?, NOW())";
            PreparedStatement stmtReg = con.prepareStatement(sqlReg);
            stmtReg.setString(1, placa);
            stmtReg.setInt(2, idLugar);
            stmtReg.setInt(3, idEstacionamiento);
            stmtReg.executeUpdate();

            String sqlLug = "UPDATE Lugares SET esta_ocupado = TRUE WHERE id_lugar = ? AND id_estacionamiento = ?";
            PreparedStatement stmtLug = con.prepareStatement(sqlLug);
            stmtLug.setInt(1, idLugar);
            stmtLug.setInt(2, idEstacionamiento);
            stmtLug.executeUpdate();

            con.commit();
            return true;
        } catch (SQLException e) {
            try { con.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            e.printStackTrace();
            return false;
        } finally {
            try { con.setAutoCommit(true); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    public String registrarSalida() {
        String placa = UserSession.getInstance().getPlacaActual();

        try {
            String sqlCheck = "SELECT id_registro, id_lugar, id_estacionamiento FROM Registros WHERE placa_vehiculo = ? AND fecha_hora_salida IS NULL";
            PreparedStatement stmtCheck = con.prepareStatement(sqlCheck);
            stmtCheck.setString(1, placa);
            ResultSet rs = stmtCheck.executeQuery();

            if (!rs.next()) return "No se encontró un vehículo estacionado con esa placa.";

            int idRegistro = rs.getInt("id_registro");
            int idLugar = rs.getInt("id_lugar");
            int idEst = rs.getInt("id_estacionamiento");

            con.setAutoCommit(false);

            String sqlUpdateReg = "UPDATE Registros SET fecha_hora_salida = NOW() WHERE id_registro = ?";
            PreparedStatement stmtUpd = con.prepareStatement(sqlUpdateReg);
            stmtUpd.setInt(1, idRegistro);
            stmtUpd.executeUpdate();

            String sqlFree = "UPDATE Lugares SET esta_ocupado = FALSE WHERE id_lugar = ? AND id_estacionamiento = ?";
            PreparedStatement stmtFree = con.prepareStatement(sqlFree);
            stmtFree.setInt(1, idLugar);
            stmtFree.setInt(2, idEst);
            stmtFree.executeUpdate();

            con.commit();
            return "Salida registrada con éxito.";

        } catch (SQLException e) {
            try { con.rollback(); } catch (SQLException ex) { ex.printStackTrace(); }
            e.printStackTrace();
            return "Error en la base de datos.";
        } finally {
            try { con.setAutoCommit(true); } catch (SQLException e) { e.printStackTrace(); }
        }
    }
}