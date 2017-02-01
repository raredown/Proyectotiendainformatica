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
        <script src="${pageContext.request.contextPath}/js/producto.js"></script>
        <script src="${pageContext.request.contextPath}/js/buscadorSimple.js"></script>

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
                <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <input type="hidden" value="1" id="pagina">
                    <!-- Wrapper for slides -->
                    <div class="carousel-inner" role="listbox">

                        <div class="item active">
                            <img src="image/imagenesProductos/imagenesProductos/<c:out value="${applicationScope.productos[0].listaImagenes[0].image}"/>" alt="Chania">
                            <div class="carousel-caption">
                                <h3><c:out value="${applicationScope.productos[0].denominacion}"/>"</h3>
                                <p><button class="btn-primary" type="button" onclick="unProducto('<c:out value="${applicationScope.productos[0].idProducto}"/>')">Ver Producto</button></p>

                            </div>
                        </div>
                        <c:forEach var="item" items="${applicationScope.productos}" begin="1">
                            <c:if test="${item.oferta == 's'}">
                                <div class="item">
                                    <img src="image/imagenesProductos/imagenesProductos/<c:out value="${item.listaImagenes[0].image}"/>" alt="<c:out value="${item.denominacion}"/>"">
                                    <div class="carousel-caption">
                                        <h3><c:out value="${item.denominacion}"/>"</h3>
                                        <p><button class="btn-primary" type="button" onclick="unProducto('<c:out value="${item.idProducto}"/>')">Ver Producto</button></p>
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach>       

                    </div>

                    <!-- Left and right controls -->
                    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
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


       <jsp:include page="../includes/footer.jsp" />
    </body>
</html>
