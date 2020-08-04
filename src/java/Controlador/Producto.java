/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author demon
 */

import java.util.*;
import java.sql.*;

public class Producto {
    private int producto_Codigo, producto_Stock;
    private String producto_Nombre;
    private double producto_Precio;
    
    //creamos el constructor
    public Producto(){
    
    }
    
    //operaciones para el producto
    //obtener toda la lista de productos
    
    public Vector<Producto> listaProductos(){
        //hago una instancia del vector
        Vector<Producto> lp = new Vector<Producto>();
        //inicializo objetos y variables
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = Conexion.getConnection();
            String q = "Select * from Producto";
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            //buscamos dentro de la tabla de producto
            while(rs.next()){
                //hago una instancia del producto
                Producto prod = new Producto();
                prod.setProducto_Codigo(rs.getInt("producto_Codigo"));
                prod.setProducto_Nombre(rs.getString("producto_Nombre"));
                prod.setProducto_Precio(rs.getDouble("producto_Precio"));
                prod.setProducto_Stock(rs.getInt("producto_Stock"));
                //lo agrego al vector
                lp.add(prod);
            }
        
        }catch(SQLException e){
            System.out.println("Error al conectar con Producto");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            lp = null;
        
        }finally{
            try{
                
                rs.close();
                ps.close();
                con.close();
            
            }catch(SQLException e){
                
                System.out.println(e.getStackTrace());
            
            }
        }
        return lp;
    }
    
    //busqueda por codigo del producto
    public Producto buscarProducto(int codigoProducto){
    
        Producto prod = new Producto();
        //inicializo objetos y variables
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try{
            con = Conexion.getConnection();
            String q = "Select * from Producto where producto_Codigo = ? ";
            ps = con.prepareStatement(q);
            //obtener el codigo
            ps.setInt(1, codigoProducto);
            rs = ps.executeQuery();
            //buscamos dentro de la tabla de producto
            while(rs.next()){
                //hago una instancia del producto
                
                prod.setProducto_Codigo(rs.getInt("producto_Codigo"));
                prod.setProducto_Nombre(rs.getString("producto_Nombre"));
                prod.setProducto_Precio(rs.getDouble("producto_Precio"));
                prod.setProducto_Stock(rs.getInt("producto_Stock"));
                //lo agrego al vector
                
            }
        
        }catch(SQLException e){
            System.out.println("Error al conectar con Producto");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            prod = null;
        
        }finally{
            try{
                
                rs.close();
                ps.close();
                con.close();
            
            }catch(SQLException e){
                
                System.out.println(e.getStackTrace());
            
            }
        }
        return prod;
        
    }
    
    //el metodo que se encarga de actualizar el stock
    //para poder actualizar debe de tener un elemento de tipo bandera
    // a que me identifique si se o no se actualizo
    
    public boolean actualizarStock(Vector<Producto> vp){
    
        boolean actualizo=false;
        Connection con = null;
        PreparedStatement ps = null;
        
        try{
            
            con = Conexion.getConnection();
            for(Producto prod : vp){
                String q = "update Producto set producto_stock = ? where producto_Codigo = ?";
                ps = con.prepareStatement(q);
                ps.setInt(1, prod.getProducto_Stock());
                ps.setInt(2, prod.getProducto_Codigo());
                if(ps.executeUpdate() == 1){
                    actualizo = true;
                }else{
                    actualizo = false;
                    break;
                }
            }
        
        }catch(SQLException e){
            System.out.println("Error al actualizar el stock");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
            actualizo = false;
        
        }finally{
            try{
                ps.close();
                con.close();
            
            }catch(SQLException e){
                System.out.println(e.getStackTrace());
            }
        }
        return actualizo;
        
    }
    
    
    
    //creamos los getter y setter

    public int getProducto_Codigo() {
        return producto_Codigo;
    }

    public void setProducto_Codigo(int producto_Codigo) {
        this.producto_Codigo = producto_Codigo;
    }

    public int getProducto_Stock() {
        return producto_Stock;
    }

    public void setProducto_Stock(int producto_Stock) {
        this.producto_Stock = producto_Stock;
    }

    public String getProducto_Nombre() {
        return producto_Nombre;
    }

    public void setProducto_Nombre(String producto_Nombre) {
        this.producto_Nombre = producto_Nombre;
    }

    public double getProducto_Precio() {
        return producto_Precio;
    }

    public void setProducto_Precio(double producto_Precio) {
        this.producto_Precio = producto_Precio;
    }
    
    
}
