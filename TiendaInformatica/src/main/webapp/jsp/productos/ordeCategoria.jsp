<%-- 
    Document   : porcategoria
    Created on : 15-ene-2017, 23:31:33
    Author     : rafa
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input value="<c:out value="${requestScope.idcatein}"/>" type="hidden" id="categoria">
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <div class="btn-group">
                <button type="button" class="btn btn-default" onclick="ordenar('nombre')" >Ordenar por nombre</button>
                <button type="button" class="btn btn-default" onclick="ordenar('precio')">Ordenar por precio</button>
                <button type="button" class="btn btn-default" onclick="ordenar('marca')">Ordenar por marca</button>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">		
    <div class="col-md-12 product-info">
        <ul id="myTab" class="nav nav-tabs nav_tabs">
            <li class="active"><a href="#1a" data-toggle="tab">1</a></li>
                <c:forEach var="i" begin="2" end="${requestScope.numeroPagina}">
                <li><a href="#<c:out value="${i}"/>a" data-toggle="tab"><c:out value="${i}"/></a></li>
                </c:forEach>


        </ul>
        <div id="myTabContent" class="tab-content">

            <div class="tab-pane fade in active" id="1a">

                <section class="container product-info">
                    <c:forEach var="item" items="${requestScope.productosCat}" end="5">



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
                                                <button class="btn btn-primary btn-product" onclick="unProducto('<c:out value="${item.idProducto}"/>')"><span class="glyphicon glyphicon-eye-open"></span> Ver</button>
                                            
                                            </div>
                                            <div class="col-md-6">
                                                <a onclick="addCarrito('<c:out value="${requestScope.productosId[0].idProducto}"/>')" class="btn btn-success btn-product"><span class="glyphicon glyphicon-shopping-cart"></span> Buy</a></div>
                                        </div>

                                        <p> </p>
                                    </div>
                                </div>
                            </div>
                        </div>



                    </c:forEach>
                </section>

            </div>

            <c:forEach var="i" begin="2" end="${requestScope.numeroPagina}">
                <div class="tab-pane fade" id="<c:out value="${i}"/>a">

                    <section class="container">
                        <c:forEach var="item" items="${requestScope.productosCat}" begin="${5 * (i-1)}" end="${5 * i}">



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
                                                    <a onclick="addCarrito('<c:out value="${requestScope.productosId[0].idProducto}"/>')" class="btn btn-success btn-product"><span class="glyphicon glyphicon-shopping-cart"></span> Buy</a></div>
                                            </div>

                                            <p> </p>
                                        </div>
                                    </div>
                                </div>
                            </div>



                        </c:forEach>
                    </section>

                </div>
            </c:forEach>  
        </div>
        <hr>
    </div>
</div>

