<%-- 
    Document   : principalcarrito
    Created on : 31-ene-2017, 23:22:03
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../includes/head.jsp" />

    </head>
    <body class="container-fluid">

        <jsp:include page="../includes/navegador.jsp" />

        <div class="container">
            <div class="row">
                <div class="col-xs-12">

                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <h5><span class="glyphicon glyphicon-shopping-cart"></span> Carrito de la compra</h5>
                                    </div>
                                    <div class="col-xs-6">
                                        <div class="col-xs-2"></div>
                                        <div class="col-xs-4">
                                            <button type="button" class="btn btn-primary btn-sm btn-block">
                                                <span class="glyphicon glyphicon-share-alt"></span> Continuar comprando
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body">


                            <div class="row">
                                <div class="col-xs-2">
                                </div>
                                <div class="col-xs-4">
                                    <h2 class="product-name"><strong>Nombre del Producto</strong></h2>
                                </div>
                                <div class="col-xs-6">
                                    <div class="col-xs-6 text-right">
                                        <h3><strong>Precio </strong></h3>
                                    </div>
                                    <div class="col-xs-4">
                                        <h3 class="product-name"><strong>Cantidad</strong></h3>
                                    </div>
                                </div>

                            </div>
                            <c:forEach var="i"  items="${sessionScope.lineaspedidos}">
                                <c:set var="string2" value="${fn:substring(i.producto.descripcion, 0, 45)}" />
                                <div class="row" id="<c:out value="${i.numeroLinea}"/>">

                                    <div class="col-xs-2">
                                        <img src="image/imagenesProductos/imagenesProductos/<c:out value="${i.producto.listaImagenes[0].image}"/>" alt="producto" style="width: 72px; height: 72px;">
                                    </div>
                                    <div class="col-xs-4">
                                        <h4 class="product-name"><strong><c:out value="${i.producto.denominacion}"/></strong></h4><h4><small><c:out value="${string2}"/>...</small></h4>
                                    </div>
                                    <div class="col-xs-6">
                                        <div class="col-xs-6 text-right">
                                            <c:out value="${i.precioUnitario}"/> €
                                        </div>
                                        <div class="col-xs-4">


                                            <input type="text" id="input<c:out value="${i.numeroLinea}"/>" class="form-control text-center" readonly value=" <c:out value="${i.cantidad}"/>">
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <button type="button" class="btn btn-link btn-xs" onclick="addLinea('<c:out value="${i.numeroLinea}"/>','add')">
                                                <span class="glyphicon glyphicon-plus "> </span>
                                            </button> 
                                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                            <button type="button" class="btn btn-link btn-xs" onclick="menosLinea('<c:out value="${i.numeroLinea}"/>')">
                                                <span class="glyphicon glyphicon-minus"> </span>
                                            </button> 

                                        </div>
                                        <div class="col-xs-2">
                                            <button type="button" class="btn btn-link btn-xs" onclick="deleteLinea('<c:out value="${i.numeroLinea}"/>')">
                                                <span class="glyphicon glyphicon-trash"> </span>
                                            </button>
                                        </div>
                                    </div>

                                </div>
                                <hr>
                            </c:forEach>

                            <hr>
                            <div class="row">
                                <div class="text-center">
                                    <div class="col-xs-9">
                                        <h6 class="text-right">Added items?</h6>
                                    </div>
                                    <div class="col-xs-3">
                                        <button type="button" class="btn btn-default btn-sm btn-block">
                                            Update cart
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-footer">
                            <div class="row text-center">
                                <div class="col-xs-9">
                                    <h4 class="text-right">Total <strong id='baseImponible'><c:out value="${sessionScope.carrito.baseImponible}" default="0"/> </strong> €</h4>
                                </div>
                                <div class="col-xs-3">
                                    <button type="button" class="btn btn-success btn-block">
                                        Comprar¡
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="../includes/footer.jsp" />
    </body>
</html>
