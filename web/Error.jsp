<%-- 
    Document   : Error
    Created on : 4/08/2020, 07:06:16 AM
    Author     : demon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.*" session="true"%>
    
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

%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Errores</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <table width="800" border="0" align="center" >
            <tr>
                <td width="84" bgcolor="#FF0000"  > <img src="img/imagen01.jsp"  width="84" height="77" >    </td>
                <td width="716" bgcolor="#FF0000" > <h1 style="color:#FFFFFF" >Carrito de Compras</h1> </td>
            </tr>
            <tr align="center" >
                <td colspan="2" ></td>
            </tr>
            <tr align="center" >
                <td colspan="2" >
                    <h4> <a href="MostrarProductos.jsp" >Consultar Productos</a> | <a>Agregar al carrito</a> | <a>Cerrar sesión</a> </h4>
                </td>
            </tr>
            <tr></tr>
            <tr align="center" >
                <td colspan="2" ></td>
            </tr>
            
        </table>
    <center><h1>Upssss Sucedio un error lo sentimos <a href="index.html" >Haz clic aqui para volver</a> </h1></center>
    </body>
</html>
