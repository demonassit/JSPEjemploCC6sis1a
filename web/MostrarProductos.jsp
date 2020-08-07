<%-- 
    Document   : MostrarProductos
    Created on : 5/08/2020, 08:42:01 AM
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
        <title>Productos</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        
<% 
    //vamos a obtener la lista de productos
    Vector<Producto> vecPro = new Producto().listaProductos();
%>    
    <p> <b> Bienvenido</b> </p><%=usuario%> 
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
                    <h4> <a href="MostrarProductos.jsp" >Consultar Productos</a> | <a href="AgregarProducto1.jsp" >Agregar al carrito</a> | <a href="CerrarSesion" >Cerrar sesión</a> </h4>
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
                                <h4><span class="Estilo3" >Stock</span></h4>
                            </td>
                            <td width="16%" align="right" valing="top" >
                                <h4><span class="Estilo3" >Precio</span></h4>
                            </td>
                        </tr>
                        <%
                            //llenamos la tabla de los productos
                            for(Producto prod : vecPro){
                        %>
                        <tr>
                            <td> <%=prod.getProducto_Nombre() %> </td>
                            <td align="right" valing="top" > <%=prod.getProducto_Stock() %> </td>
                            <td align="right" valing="top" > <%=prod.getProducto_Precio()%> </td>
                        </tr>
                        <%}%>
                    </table>
                </td>
            </tr>
            <tr>
                <td colspan="2"></td>
            </tr>
    </table>
        
    </body>
</html>
