/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palestra.config;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author juanc
 */
public class PruebaConexion {
    
     public static void main(String[] args) {

        try {
            Connection conexion = Conexion.conectar();

            System.out.println("¡Conexión exitosa a la base de datos!");

            conexion.close();

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos:");
            e.printStackTrace();
        }
    }
}
