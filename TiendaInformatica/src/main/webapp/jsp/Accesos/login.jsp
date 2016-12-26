<%-- 
    Document   : login
    Created on : 22-dic-2016, 20:00:13
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <jsp:include page="../includes/head.jsp" />
        <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/login.js"></script>

    </head>
    <body class="container-fluid">
        <jsp:include page="../includes/navegador.jsp" />
        <div class="container">
            <div class="row">


                <div class="container">
                    <div class="card"></div>
                    <div class="card">
                        <h1 class="title">Login</h1>
                        <form method="post" action="${pageContext.request.contextPath}/Login">
                            <div class="input-container">
                                <input type="text" id="Username" required="required" name="usuario" pattern="([a-z]+[0-9]{0,2}){5,12}$"/>
                                <label for="Username">Usuario</label>
                                <div class="bar"></div>
                            </div>
                            <div class="input-container">
                                <input type="password" id="Password" required="required" name="pass"/>
                                <label for="Password">Contraseña</label>
                                <div class="bar"></div>
                            </div>
                            <c:set var="mensaje" value="${requestScope.error}" />
                            <c:if test="${not empty mensaje}">
                                <div class="alert alert-danger"><p class="text-center"><c:out value="${mensaje}" /></p></div>
                            </c:if>
                            
                            <input type="hidden" value="entrar" name="oculto">
                            <div class="button-container">
                                <button><span>Entrar</span></button>
                            </div>

                        </form>
                    </div>
                    <div class="card alt">
                        <div class="toggle"></div>
                        <h1 class="title">Registro
                            <div class="close"></div>
                        </h1>
                        <form method="post" action="${pageContext.request.contextPath}/Login">
                            <div class="input-container">
                                <input type="text" id="Username" required="required" name="usuario" pattern="([a-z]+[0-9]{0,2}){5,12}$"/>
                                <label for="Username">Usuario</label>
                                <div class="bar"></div>
                            </div>
                            <div class="input-container">
                                <input type="password" id="password" required="required" name="password"/>
                                <label for="Password">Contraseña</label>
                                <div class="bar"></div>
                            </div>
                            <div class="input-container">
                                <input type="password" id="password2" required="required" onblur="validacion()" name="password2"/>
                                <label for="Repeat Password">Repita su contraseña</label>
                                <div class="bar"></div>
                            </div>
                            <input type="hidden" value="registro" name="oculto">
                            <div class="button-container">
                                <button><span>Siguiente</span></button>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>

    </body>
</html>
