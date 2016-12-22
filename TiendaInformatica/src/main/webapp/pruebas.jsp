<%-- 
    Document   : pruebas
    Created on : 22-dic-2016, 20:50:18
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <jsp:include page="jsp/includes/head.jsp" />
        <link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/js/login.js"></script>

    </head>
    <body class="container-fluid">
        <jsp:include page="jsp/includes/navegador.jsp" />
        <div class="container">
            <div class="row">


                <div class="container">
                    <div class="card"></div>
                    <div class="card">
                        <h1 class="title">Login</h1>
                        <form>
                            <div class="input-container">
                                <input type="text" id="Username" required="required"/>
                                <label for="Username">Usuario</label>
                                <div class="bar"></div>
                            </div>
                            <div class="input-container">
                                <input type="password" id="Password" required="required"/>
                                <label for="Password">Contraseña</label>
                                <div class="bar"></div>
                            </div>
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
                        <form>
                            <div class="input-container">
                                <input type="text" id="Username" required="required"/>
                                <label for="Username">Usuario</label>
                                <div class="bar"></div>
                            </div>
                            <div class="input-container">
                                <input type="password" id="Password" required="required"/>
                                <label for="Password">Contraseña</label>
                                <div class="bar"></div>
                            </div>
                            <div class="input-container">
                                <input type="password" id="Repeat Password" required="required"/>
                                <label for="Repeat Password">Repita su contraseña</label>
                                <div class="bar"></div>
                            </div>
                            <div class="button-container">
                                <button><span>Next</span></button>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
        </div>

    </body>
</html>
