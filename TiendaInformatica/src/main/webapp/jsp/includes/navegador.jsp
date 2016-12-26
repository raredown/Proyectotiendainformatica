<%-- 
    Document   : navegador
    Created on : 22-dic-2016, 20:15:39
    Author     : rafa
--%>
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
            <a class="navbar-brand" href="#"><img  src="${pageContext.request.contextPath}/image/logito.png"></a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a href="${pageContext.request.contextPath}">Inicio</a></li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Page 1-1</a></li>
                        <li><a href="#">Page 1-2</a></li>
                        <li><a href="#">Page 1-3</a></li>
                    </ul>
                </li>
                <li><a href="#">Page 2</a></li>
                <li><a href="#">Page 3</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${empty sessionScope.usuario}">
                    <li><a href="${pageContext.request.contextPath}/jsp/Accesos/login.jsp"><span class="glyphicon glyphicon-user"></span> Login</a></li>
                    </c:if>
                    <c:if test="${not empty sessionScope.usuario}">
                    <li><a href="ConCliente"><span class="glyphicon glyphicon-user"></span> <c:out value="${sessionScope.usuario.username}"/></a></li>
                    <li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Salir</a></li>
                    </c:if>
            </ul>
        </div>
    </div>
</nav>