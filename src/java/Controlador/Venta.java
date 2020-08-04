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
public class Venta {
    
    private int venta_Codigo, usuario_Codigo;
    private String venta_Fecha;
    private double venta_TotalPagar;
    
    public Venta(){
    
    }

    public int getVenta_Codigo() {
        return venta_Codigo;
    }

    public void setVenta_Codigo(int venta_Codigo) {
        this.venta_Codigo = venta_Codigo;
    }

    public int getUsuario_Codigo() {
        return usuario_Codigo;
    }

    public void setUsuario_Codigo(int usuario_Codigo) {
        this.usuario_Codigo = usuario_Codigo;
    }

    public String getVenta_Fecha() {
        return venta_Fecha;
    }

    public void setVenta_Fecha(String venta_Fecha) {
        this.venta_Fecha = venta_Fecha;
    }

    public double getVenta_TotalPagar() {
        return venta_TotalPagar;
    }

    public void setVenta_TotalPagar(double venta_TotalPagar) {
        this.venta_TotalPagar = venta_TotalPagar;
    }
    
    
    
}
