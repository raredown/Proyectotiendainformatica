<%-- 
    Document   : principalcarrito
    Created on : 31-ene-2017, 23:22:03
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                                        <h5><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</h5>
                                    </div>
                                    <div class="col-xs-6">
                                        <button type="button" class="btn btn-primary btn-sm btn-block">
                                            <span class="glyphicon glyphicon-share-alt"></span> Continue shopping
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="panel-body">
                            <c:forEach var="i"  items="${sessionScope.lineaspedidos}">

                                <div class="row">
                                    <div class="col-xs-2"><img class="img-responsive" src="image/imagenesProductos/imagenesProductos/<c:out value="${applicationScope.productos[0].listaImagenes[0].image}"/>" width="90px" height="70px">
                                    </div>
                                    <div class="col-xs-4">
                                        <h4 class="product-name"><strong>Product name</strong></h4><h4><small>Product description</small></h4>
                                    </div>
                                    <div class="col-xs-6">
                                        <div class="col-xs-6 text-right">
                                            <h6><strong>25.00 <span class="text-muted">x</span></strong></h6>
                                        </div>
                                        <div class="col-xs-4">
                                            <input type="text" class="form-control input-sm" value="1">
                                        </div>
                                        <div class="col-xs-2">
                                            <button type="button" class="btn btn-link btn-xs">
                                                <span class="glyphicon glyphicon-trash"> </span>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <hr>
                            </c:forEach>
                            <div class="row">
                                <div class="col-xs-2">
                                </div>
                                <div class="col-xs-4">
                                    <h2 class="product-name"><strong>Nombre del Producto</strong></h2>
                                </div>
                                <div class="col-xs-6">
                                    <div class="col-xs-6 text-right">
                                        <h2><strong>Precio </strong></h2>
                                    </div>
                                </div>
                            </div>
                            <div class="row">

                                <div class="col-xs-2">
                                </div>
                                <div class="col-xs-4">
                                    <h4 class="product-name"><strong>Product name</strong></h4><h4><small>Product description</small></h4>
                                </div>
                                <div class="col-xs-6">
                                    <div class="col-xs-6 text-right">
                                        <h6><strong>25.00 <span class="text-muted">x</span></strong></h6>
                                    </div>
                                    <div class="col-xs-4">
                                        <input type="text" class="form-control input-sm" value="1">
                                    </div>
                                    <div class="col-xs-2">
                                        <button type="button" class="btn btn-link btn-xs">
                                            <span class="glyphicon glyphicon-trash"> </span>
                                        </button>
                                    </div>
                                </div>
                            </div>
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
                                    <h4 class="text-right">Total <strong>$50.00</strong></h4>
                                </div>
                                <div class="col-xs-3">
                                    <button type="button" class="btn btn-success btn-block">
                                        Checkout
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
