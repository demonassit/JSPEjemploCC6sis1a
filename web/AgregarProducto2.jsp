<%-- 
    Document   : AgregarProducto2
    Created on : 6/08/2020, 07:28:29 AM
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
        <title>JSP Page</title>
    </head>
    <body>
        
        <% 
    //vamos por un objeto de producto para realizar la busqueda del mismo por codigo
Producto prod = new Producto().buscarProducto(Integer.parseInt(request.getParameter("cod")));
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
                    <form name="agregarcarro" action="AgregarCarro" method="post" >
                        <table width="100%" border="0" >
                            <tr>
                                <td width="17%" bgcolor="#FF0000" >
                                    <span class="Estilo3" >Codigo:</span>
                                </td>
                                <td width="83%" >
                                    <label><input type="text" name="txtCodigo" id="txtCodigo" size="10"
                                                  readonly value="<%=prod.getProducto_Codigo() %>"></label>
                                </td>
                            </tr>
                            <tr>
                                <td width="17%" bgcolor="#FF0000" >
                                    <span class="Estilo3" >Producto:</span>
                                </td>
                                <td width="83%" >
                                    <label><input type="text" name="txtProducto" id="txtProducto" size="60"
                                                  readonly value="<%=prod.getProducto_Nombre()%>"></label>
                                </td>
                            </tr>
                            <tr>
                                <td width="17%" bgcolor="#FF0000" >
                                    <span class="Estilo3" >Precio:</span>
                                </td>
                                <td width="83%" >
                                    <label><input type="text" name="txtPrecio" id="txtPrecio" size="15"
                                                  readonly value="<%=prod.getProducto_Precio()%>"></label>
                                </td>
                            </tr>
                            <tr>
                                <td width="17%" bgcolor="#FF0000" >
                                    <span class="Estilo3" >Stock:</span>
                                </td>
                                <td width="83%" >
                                    <label><input type="text" name="txtStock" id="txtStock" size="15"
                                                  readonly value="<%=prod.getProducto_Stock()%>"></label>
                                </td>
                            </tr>
                            <tr>
                                <td width="17%" bgcolor="#FF0000" >
                                    <span class="Estilo3" >Cantidad:</span>
                                </td>
                                <td width="83%" >
                                    <label><input type="text" name="txtCantidad" id="txtCantidad" size="10"
                                                   value="1"></label>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>
                                    <label><input type="submit" name="button" value="Registrar Compra" ></label>
                                </td>
                            </tr>
                        </table>
                    </form>
                </td>
            </tr>
            <tr>
                <td colspan="2"></td>
            </tr>
    </table>
        
    </body>
</html>
