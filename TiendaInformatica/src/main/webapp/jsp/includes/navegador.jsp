<%-- 
    Document   : navegador
    Created on : 22-dic-2016, 20:15:39
    Author     : rafa
--%>
<!-- Define el autor del documento -->
<meta name="author" content="Rafael Retamal Donoso" />
<!-- Define el programa con el que se ha generado el documento -->
<meta name="generator" content="NetBeans IDE 8.1" />
<!-- Define el copyright del documento -->
<meta name="copyright" content="worldpc" />
<!-- Define el comportamiento de los buscadores -->
<meta name="robots" content="index, follow" />
<!-- Define las palabras claves del contenido del documento -->
<meta name="keywords" content="tienda" />
<!-- Define una breve descripción del sitio -->
<meta name="description" content="Tienda informatica" />
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                        
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}"><img  src="${pageContext.request.contextPath}/image/logotipo.png"></a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}">WorldPC</a></li>
              

            </ul>
            <div class="col-sm-3 col-md-3">
                <form class="navbar-form" role="search" onsubmit="return busquedaSimple();" >
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Buscador" name="buscador" required="required" id="buscador">
                        <div class="input-group-btn">
                            <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                        </div>
                    </div>
                </form>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="PanelCarrito"><span class="glyphicon glyphicon-shopping-cart"></span> Carrito</a></li>
                    <c:if test="${empty sessionScope.usuario}">

                    <li><a href="${pageContext.request.contextPath}/jsp/Accesos/login.jsp"><span class="glyphicon glyphicon-user"></span> Login</a></li>
                    </c:if>
                    <c:if test="${not empty sessionScope.usuario}">
                        <c:if test="${sessionScope.usuario.tipo=='u'}">
                        <li><a href="ConCliente"><span class="glyphicon glyphicon-user"></span> <c:out value="${sessionScope.usuario.username}"/></a></li>
                        <li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
                        </c:if>
                        <c:if test="${sessionScope.usuario.tipo=='a'}">
                        <li><a href="ControladorAdministrador"><span class="glyphicon glyphicon-user"></span> <c:out value="${sessionScope.usuario.username}"/></a></li>
                        <li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
                        </c:if>
                    </c:if>
            </ul>
        </div>
    </div>
</nav>
<div class="alert alert-success" id="success-alert">
    <button type="button" class="close" data-dismiss="alert">x</button>
    <strong>Correcto! </strong>
    Su producto se ha añadido correctamente.
</div>
<div class="alert alert-danger" id="danger-alert">
    <button type="button" class="close" data-dismiss="alert">x</button>
    <strong>Fallo! </strong>
    No nos queda mas productos en stock.
</div>
<div class="alert alert-danger" id="danger-borrado">
    <button type="button" class="close" data-dismiss="alert">x</button>
    <strong>Correcto! </strong>
    Su producto se ha borrado correctamente.
</div>
<input type="hidden" value="<c:out value="${requestScope.inputmensaje}" default="0"/>" id="inputmensajito" >
<div class="alert alert-danger" id="peligromensaje">
    <button type="button" class="close" data-dismiss="alert">x</button>
    <strong>Fallo! </strong>
    <c:out value="${requestScope.mensajeCarrito}"/>
</div>
