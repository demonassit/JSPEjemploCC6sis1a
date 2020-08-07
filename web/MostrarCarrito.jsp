<%-- 
    Document   : MostrarCarrito
    Created on : 7/08/2020, 07:09:47 AM
    Author     : demon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.*, Controlador.*" session="true" %>

<%  

    //todo lo que hay aqui adentro es codigo java
    String usuario = "";
    HttpSession sessionok = request.getSession();
    if(sessionok.getAttribute("usuario") == null){

%>

<jsp:forward page="index.html">
    <jsp:param name="error" value="Es obligatorio tener una cuenta autenticada"/>
</jsp:forward>

<%   

    }else{
        usuario = (String)sessionok.getAttribute("usuario");
    }
    //todo lo anterior se encarga de validar la sesion que sea correcta
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta de Productos</title>
    </head>
    <body>
        <% 
    //vamos a obtener la lista de productos del detalle
    Vector<DetalleVenta> vectorDetalle = (Vector<DetalleVenta>)session.getAttribute("detalleVenta");
    Vector<Producto> vectorStock = null;
%>  
        <table width="800" border="0" align="center" >
        <tr>
            <td width="84" bgcolor="#FF0000" >
                <img src="img/imagen01.jpg" width="84" height="77" >
            </td>
            <td width="716" bgcolor="#FF0000" >
                <h1 style="color:#FFFFFF">
                    Carrito de Compras
                </h1>
            </td>
        </tr>
        <tr align="center" >
                <td colspan="2" ></td>
            </tr>
            <tr align="center" >
                <td colspan="2" >
                    <h4> <a href="MostrarProductos.jsp" >Consultar Productos</a> | <a href="AgregarProducto1.jsp" >Agregar al carrito</a> | <a>Cerrar sesión</a> </h4>
                </td>
            </tr>
            <tr></tr>
            <tr align="center" >
                <td colspan="2" ></td>
            </tr>
            <tr>
                <td colspan="2" >
                    <table width="100%" border="0" >
                        <tr>
                            <td width="68%" >
                                <h4>Nombre</h4>
                            </td>
                            <td width="16%" align="right" valing="top" >
                                <h4><span class="Estilo3" >Cantidad</span></h4>
                            </td>
                            <td width="16%" align="right" valing="top" >
                                <h4><span class="Estilo3" >Sub Total</span></h4>
                            </td>
                        </tr>
                        <%
                            //llenamos la tabla de los productos
                            for(DetalleVenta det : vectorDetalle){
                                Producto prod = new Producto().buscarProducto(det.getProducto_Codigo());
                        %>
                        <tr>
                            <td> <%=prod.getProducto_Nombre() %> </td>
                            <td align="right" valing="top" > <%=det.getDetVenta_Cantidad() %> </td>
                            <td align="right" valing="top" > <%=det.getDetVenta_Subtotal() %> </td>
                        </tr>
                        <%}%>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <a href="FinalizarCompra" >Finalizar Compra</a>
                </td>
            </tr>
        </table>
    </body>
</html>
