/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author demon
 */
public class VerificarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            //obtener los parametros del user y clave del formulario
            
            String user, clave;
            
            user = request.getParameter("txtUsuario");
            clave = request.getParameter("txtClave");
            
            //un objeto de usuario
            
            Usuario u = new Usuario();
            //verifique al usuario
            u = u.verificarUsuario(user, clave);
            
            //vamos a verificar si es cliente o administrador
            
            if(u!=null){
                //si el usuario existe en la bd, le vamos a crear una sesion de usuario
                HttpSession sesion = request.getSession(true);
                //enviar el objeto de la sesion
                sesion.setAttribute("usuario", u);
                //se envia el nombre de usuario
                
                HttpSession sesionok = request.getSession();
                sesionok.setAttribute("usurario", user);
                
                //vamos a verificar el privilegio para saber si es cliente o administrador
                
                if(u.getUsuario_Privilegio()==0){
                    //el usuario es cliente
                    response.sendRedirect("MostrarProductos.jsp");
                }else{
                    //administrador
                    response.sendRedirect("MostrarProductosEmpleado.jsp");
                }
            }else{
                //no existe ese usuario en la bd o la clave es incorrecta
                response.sendRedirect("Error.jsp");
                
            }
            
            
           
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
