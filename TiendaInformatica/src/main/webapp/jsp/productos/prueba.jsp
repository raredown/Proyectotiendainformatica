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
        <jsp:include page="../includes/head.jsp" />
        <script src="${pageContext.request.contextPath}/js/categoria.js"></script>

    </head>
    <body class="container-fluid">

        <jsp:include page="../includes/navegador.jsp" />

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
        <div class="col-xs-10">
            <div class="container-fluid">
                <c:forEach var="item" items="${applicationScope.productos}">
                    <c:if test="${item.idCategoria == requestScope.idcatein}">
                        <c:forEach var="item" items="${applicationScope.productos}">
                            <c:if test="${item.idCategoria == requestScope.idcatein}">
                                <div class="row">
                                    <!-- Este div esta -->
                                    <div class="col-sm-6 col-md-4"></div>
                                    <div class="col-sm-6 col-md-4">
                                        <div class="thumbnail" >

                                            <img src="image/imagenesProductos/imagenesProductos/<c:out value="${item.listaImagenes[0].image}"/>" alt="Imagen" >
                                            <div class="caption">
                                                <div class="row">
                                                    <div class="col-md-6 col-xs-6">
                                                        <h3><c:out value="${item.denominacion}"/></h3>
                                                    </div>
                                                    <div class="col-md-6 col-xs-6 price">

                                                        <h3> <c:out value="${item.precioUnitario}"/> €</h3>
                                                    </div>
                                                </div>
                                                <p></p>
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <a class="btn btn-primary btn-product"><span class="glyphicon glyphicon-eye-open"></span> Ver</a> 
                                                    </div>
                                                    <div class="col-md-6">
                                                        <a href="#" class="btn btn-success btn-product"><span class="glyphicon glyphicon-shopping-cart"></span> Buy</a></div>
                                                </div>

                                                <p> </p>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>
                    </c:if>
                </c:forEach>
            </div>

            <c:out value="${applicationScope.productos[0].denominacion}"/>
            <c:out value="${requestScope.idcatein}"/>
            <c:out value="${sessionScope.usuario.username}"/>

            <c:forEach var="item" items="${applicationScope.productos}">
                <c:if test="${item.idCategoria == requestScope.idcatein}">
                    <c:out value="${item.denominacion}"/>
                </c:if>
            </c:forEach>
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
