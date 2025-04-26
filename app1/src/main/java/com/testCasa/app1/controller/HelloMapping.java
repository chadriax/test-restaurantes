package com.testCasa.app1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.testCasa.app1.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HelloMapping {

    @GetMapping("/hola")
    public String hola() {
        Map<String, List<String>> usuariosConVotaciones = new HashMap<>();

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(
                     "SELECT u.nombre AS usuario_nombre, r.nombre AS restaurante_nombre, v.ranking " +
                             "FROM Usuarios u " +
                             "JOIN Votaciones v ON u.id = v.usuario_id " +
                             "JOIN Restaurantes r ON r.id = v.restaurante_id " +
                             "ORDER BY u.id, v.ranking ASC")) {

            while (rs.next()) {
                String usuarioNombre = rs.getString("usuario_nombre");
                String restauranteNombre = rs.getString("restaurante_nombre");
                int ranking = rs.getInt("ranking");

                String voto = restauranteNombre + " (" + ranking + ")";

                usuariosConVotaciones
                        .computeIfAbsent(usuarioNombre, k -> new ArrayList<>())
                        .add(voto);
            }

        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }

        if (usuariosConVotaciones.isEmpty()) {
            return "No hay votaciones registradas.";
        } else {
            StringBuilder resultado = new StringBuilder();
            usuariosConVotaciones.forEach((usuario, votaciones) -> {
                resultado.append(usuario)
                        .append(": ")
                        .append(votaciones)
                        .append("\n");
            });
            return resultado.toString();
        }
    }
}
