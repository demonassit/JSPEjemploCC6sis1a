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
import java.sql.*;

public class Conexion {
    
    //clase para la conexion con la BD
    public static Connection getConnection(){
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/ventas";
            String user = "root";
            String pass = "N0m3l0";
            //vamos a retornar la conexion
            return DriverManager.getConnection(url, user, pass);
                   
        }catch(SQLException e){
            
            System.out.println("No se conecto a la BD");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
        return null;
    }
    
}
