package com.example.DataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthDAO {
    private final Connection con = DatabaseConnection.getInstance().getConnection();

    public boolean validarLogin(String identificador, String placa, String passwordTextoPlano) {
        String sql = "SELECT p.noCont FROM Personas p " +
                "JOIN Vehiculos v ON p.noCont = v.noCont " +
                "WHERE v.placa = ? AND (p.nombre = ? OR p.noCont = ?)" +
                "AND p.hashPass = SHA1(?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, placa);
            stmt.setString(2, identificador);
            stmt.setString(3, identificador);
            stmt.setString(4, passwordTextoPlano);

            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}