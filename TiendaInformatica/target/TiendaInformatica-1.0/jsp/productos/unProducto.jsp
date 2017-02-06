<%-- 
    Document   : unProducto
    Created on : 17-ene-2017, 20:05:59
    Author     : Daw2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-12 unProducto">

    <div class="col-md-3" id="imagenes" >
        <img src="image/imagenesProductos/imagenesProductos/<c:out value="${requestScope.productosId[0].listaImagenes[0].image}"/>" alt="Imagen" height="300px" width="300px">
    </div>
    <div class="col-md-6" id="informacion">
        <h2><c:out value="${requestScope.productosId[0].denominacion}"/></h2>
        <h1 class="text-success"><c:out value="${requestScope.productosId[0].precioUnitario}"/> €</h1>
        <p><c:out value="${requestScope.productosId[0].descripcion}"/></p>
        <p>Stock:  <c:out value="${requestScope.productosId[0].stock}"/></p>
        <a onclick="addCarrito('<c:out value="${requestScope.productosId[0].idProducto}"/>')" class="btn btn-success btn-product"><span class="glyphicon glyphicon-shopping-cart"></span>Comprar</a></div>
    </div>
</div>