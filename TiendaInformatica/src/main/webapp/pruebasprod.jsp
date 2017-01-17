<%-- 
    Document   : index.jsp
    Created on : 22-dic-2016, 20:07:27
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <jsp:include page="jsp/includes/head.jsp" />
        <script src="${pageContext.request.contextPath}/js/categoria.js"></script>

    </head>
    <body class="container-fluid">

        <jsp:include page="jsp/includes/navegador.jsp" />

        <div class="row">
            <div class="col-xs-2">
                <div class="panel panel-primary">

                    <div class="panel-heading"><a data-toggle="collapse" href="#collapse1">Productos</a></div>
                    <div id="collapse1" class="panel-collapse collapse">
                        <div class="panel-body"> 

                            <c:forEach var="item" items="${applicationScope.categoria}">
                                <button type="button" class="btn btn-primary btn-md btn-block" onclick="redireccionar('<c:out value="${item.idCategoria}"/>')"><c:out value="${item.nombre}"/></button>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-10" id="recarga">


                <div class="col-md-12 unProducto">
                    
                    <div class="col-md-3" id="imagenes" >
                        <img src="image/imagenesProductos/imagenesProductos/<c:out value="${applicationScope.productos[0].listaImagenes[0].image}"/>" alt="Imagen" height="300px" width="300px">
                    </div>
                    <div class="col-md-6" id="informacion">
                        <h2><c:out value="${applicationScope.productos[0].denominacion}"/></h2>
                        <h1 class="text-success"><c:out value="${applicationScope.productos[0].precioUnitario}"/> €</h1>
                        <p><c:out value="${applicationScope.productos[0].descripcion}"/></p>
                        <p>Stock:  <c:out value="${applicationScope.productos[0].stock}"/></p>
                        <button class="btn btn-primary btn-product">Añadir al carrito</button>
                    </div>
                </div>

            </div>


            <!-- Futuros cosas
            <c:forEach var="item" items="${applicationScope.productos}">
                
                <img src="image/imagenesProductos/imagenesProductos/<c:out value="${applicationScope.productos[0].listaImagenes[0].image}"/>" alt="Smiley face" >
                
                <c:forEach var="item2" items="${item.listaImagenes}">
                    <c:out value="${item2.image}"/>
                </c:forEach>
                <br>
            </c:forEach>
            -->
        </div>
    </body>
</html>
