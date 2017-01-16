<%-- 
    Document   : porcategoria
    Created on : 15-ene-2017, 23:31:33
    Author     : rafa
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav aria-label="...">
    <ul class="pager">
        <li><a href="#">Previous</a></li>
        <li><a href="#">Next</a></li>
    </ul>
</nav>
<div class="container-fluid">
    <c:forEach var="item" items="${applicationScope.productos}">
 
            <c:if test="${item.idCategoria == requestScope.idcatein}">
                <c:set var="elemento" value="${elemento+1}"/>

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
