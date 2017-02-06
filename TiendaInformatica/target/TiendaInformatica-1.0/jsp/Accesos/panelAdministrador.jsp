<%-- 
    Document   : panelAdministrador
    Created on : 04-feb-2017, 17:15:49
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../includes/head.jsp" />
        <link href="${pageContext.request.contextPath}/css/formulario.css" rel="stylesheet">

        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="${pageContext.request.contextPath}/js/panelModificacion.js"></script>
        <script src="${pageContext.request.contextPath}/js/panelAdmin.js"></script>

        <title>JSP Page</title>
    </head>
    <body class="container-fluid">

        <jsp:include page="../includes/navegador.jsp" />
        <div class="row">
            <div class="col-xs-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Panel de Administrador</div>
                    <div class="panel-body"> 

                        <button type="button" class="btn btn-primary btn-lg btn-block" onclick="realizaProceso('ControladorAdministrador?accion=clientes')">Modificación de clientes</button>
                        <button type="button" class="btn btn-primary btn-lg btn-block" onclick="realizaProceso('ControladorAdministrador?accion=admipro')">Modificación de producto</button>
                        <button type="button" class="btn btn-primary btn-lg btn-block" onclick="realizaProceso('ControladorAdministrador?accion=reponer')">Reponer</button>
                    </div>
                </div>

            </div>
            <div id="datitos">
                <c:out value="${requestScope.mensaje}" />
            </div>
        </div>
        <br>

    </body>
</html>
