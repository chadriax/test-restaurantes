package com.testCasa.app1.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://sql.freedb.tech:3306/freedb_RestauranteApp"; // tu base de datos
    private static final String USER = "freedb_chadriax"; // tu usuario MySQL
    private static final String PASSWORD = "*g!jJ6%wC!B&8B8"; // tu contraseña

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error al conectar a la base de datoss", e);
        }
    }

}
