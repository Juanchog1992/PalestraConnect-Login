/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palestra.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juanc
 */
public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/palestra_connect";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "Juanca920721@";

    public static Connection conectar() throws SQLException {
        try {
        Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
        throw new SQLException("No se encontró el driver de MySQL", e);
    }
        return DriverManager.getConnection(URL, USUARIO, PASSWORD);
    }
}
