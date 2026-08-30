/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.palestra.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author juanc
 */
public class UsuarioDAO {
    
    public boolean existeDocumento(String numeroDocumento){
        String sql = "SELECT numero_documento FROM usuario WHERE numero_documento = ?";
              
        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            
            sentencia.setString(1, numeroDocumento);
            
            try (ResultSet resultado = sentencia.executeQuery()) {
                return resultado.next();   
            }
            
        } catch (SQLException e) {
            System.out.println("Error al verificar el documento: " + e.getMessage());
            return false;
        }
    }
    
    public boolean existeEmail(String email) {
        
        String sql = "SELECT email FROM usuario WHERE email = ?";
        
        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            
             sentencia.setString(1, email);
             
             try (ResultSet resultado = sentencia.executeQuery()) {
                 return resultado.next();
             }
        } catch (SQLException e) {
            System.out.println("Error al verificar el correo: " + e.getMessage());
            return false;
        }
    }
    
    public boolean registrarUsuario(Usuario usuario) {
        
        String sql = "INSERT INTO usuario "
                + "(numero_documento, nombre, apellido, email, password, telefono) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conexion = Conexion.conectar();
             PreparedStatement sentencia = conexion.prepareStatement(sql)) {
            
            sentencia.setString(1, usuario.getNumeroDocumento());
            sentencia.setString(2, usuario.getNombre());
            sentencia.setString(3, usuario.getApellido());
            sentencia.setString(4, usuario.getEmail());
            sentencia.setString(5, usuario.getPassword());
            sentencia.setString(6, usuario.getTelefono());
            
            return sentencia.executeUpdate() > 0;
                        
        } catch (SQLException e) {
            System.out.println("Error al registrar el usuario: " + e.getMessage());
            return false;
        }
    }
}
