package com.palestra.servlet;

import java.io.IOException;
import com.palestra.config.Usuario;
import com.palestra.config.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String numeroDocumento = request.getParameter("numeroDocumento");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String telefono = request.getParameter("telefono");
        
        Usuario usuario = new Usuario();
        
        usuario.setNumeroDocumento(numeroDocumento);
        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuario.setTelefono(telefono);
        
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        if (usuarioDAO.existeDocumento(numeroDocumento)) {
            
            response.getWriter().println("El documento ya esta registrado");
            
            return;  
        }
        
        if (usuarioDAO.existeEmail(email)) {

            response.getWriter().println("El correo electrónico ya está registrado");

            return;
        }
        
        if (usuarioDAO.registrarUsuario(usuario)) {

            response.getWriter().println("Usuario registrado correctamente");

        } else {

            response.getWriter().println("No fue posible registrar el usuario");

        }
    }
}