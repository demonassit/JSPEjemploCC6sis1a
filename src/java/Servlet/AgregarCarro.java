/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.DetalleVenta;
import Controlador.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author demon
 */
public class AgregarCarro extends HttpServlet {

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
            
            //obtener la sesion
            HttpSession sesion = request.getSession();
            //crear los objetos de producto y detalle de la venta
            Vector<Producto> stockProducto = null;
            Vector<DetalleVenta> vectorDetalle = null;
            
            
            //si se creo la sesion con el atributo de la venta
            if(sesion.getAttribute("detalleVenta")!=null){
            
                //si existe una sesion con atributos
                vectorDetalle = (Vector<DetalleVenta>)sesion.getAttribute("detalleVenta");
                stockProducto = (Vector<Producto>)sesion.getAttribute("stockProducto");
            }else{
                //no hay sesion iniciada, (no hay un carrito ya guardado)
                vectorDetalle = new Vector<DetalleVenta>();
                stockProducto = new Vector<Producto>();
            }
            
            //obtenemos todos los elementos del formulario
            int codigo, cantidad;
            double subtotal=0;
            
            codigo = Integer.parseInt(request.getParameter("txtCodigo").trim());
            cantidad = Integer.parseInt(request.getParameter("txtCantidad").trim());
            
            Producto prod = new Producto();
            
            //vamos a obtener el detalle de la venta
            
            DetalleVenta detalle = new DetalleVenta();
            
            detalle.setDetVenta_Item(vectorDetalle.size()+1);
            detalle.setProducto_Codigo(codigo);
            detalle.setDetVenta_Subtotal(subtotal);
            detalle.setDetVenta_Cantidad(cantidad);
            
            //voy agregar a mi vector
            vectorDetalle.add(detalle);
            sesion.setAttribute("detalleVenta", vectorDetalle);
            
            //agrego el stock
            prod.setProducto_Stock(prod.getProducto_Stock()-cantidad);
            stockProducto.add(prod);
            sesion.setAttribute("stockProducto", stockProducto);
            response.sendRedirect("MostrarCarrito.jsp");
            
            
            
            
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
