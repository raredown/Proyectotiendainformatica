<%-- 
    Document   : panelCliente
    Created on : 26-dic-2016, 18:29:36
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

        <title>JSP Page</title>
    </head>
    <body class="container-fluid">

        <jsp:include page="../includes/navegador.jsp" />
        <div class="row">
            <div class="col-xs-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Panel de usuario</div>
                    <div class="panel-body"> 
                        <button type="button" class="btn btn-primary btn-lg btn-block" onclick="realizaProceso('jsp/includes/panelcliente/datosusuario.jsp')">Modificación de login</button>
                        <button type="button" class="btn btn-primary btn-lg btn-block" onclick="realizaProceso('jsp/includes/panelcliente/datoscliente.jsp')">Modificación datos personales</button>
                        <button type="button" class="btn btn-primary btn-lg btn-block" onclick="realizaProceso('ControladorProvincia')">Modificación de direcciones</button>
                    </div>
                </div>

            </div>
            <div id="datitos">
                <c:if test="${not empty requestScope.mensaje}">
                    <div class="alert alert-success" id="success-alert2">
                        <button type="button" class="close" data-dismiss="alert">x</button>
                        <strong>Correcto! </strong>
                        <c:out value="${requestScope.mensaje}" />
                    </div>

                </c:if>
            </div>
        </div>
        <br>

        <!--
        <jsp:include page="../includes/panelcliente/datoscliente.jsp" /><br>
        <jsp:include page="../includes/panelcliente/datosusuario.jsp" />
        -->
    </body>
</html>
