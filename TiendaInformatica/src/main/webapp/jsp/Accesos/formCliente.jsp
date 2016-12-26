<%-- 
    Document   : index.jsp
    Created on : 22-dic-2016, 20:07:27
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <jsp:include page="../includes/head.jsp" />
        <link href="${pageContext.request.contextPath}/css/formulario.css" rel="stylesheet">
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/js/bootstrap-datepicker.min.js"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
        <script>
            $(document).ready(function () {
                $('#fecha').datepicker();
            });
        </script>
    </head>
    <body class="container-fluid">

        <jsp:include page="../includes/navegador.jsp" />
        <div class="row">
            <div class="col-md-6 col-md-offset-3">
                <form class="form-horizontal" method="post" action="ConCliente">
                    <fieldset>
                        <legend>Datos Personales</legend>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">Nombre</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="nombre" placeholder="Nombre" name="nombre" pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,24}" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputApellido" class="col-lg-2 control-label">Apellidos</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="apellidos" placeholder="Apellidos" name="apellidos" pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,39}" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                            <div class="col-lg-10">
                                <input class="form-control" type="email" name="email" id="email" pattern="^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" required>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-2 control-label">NIF</label>
                            <div class="col-lg-10">
                                <input type="text" class="form-control" id="nif" placeholder="Letra del dni en mayúscula" name="nif" pattern="(([X-Z]{1})([-]?)(\d{7})([-]?)([A-Z]{1}))|((\d{8})([-]?)([A-Z]{1}))" required>
                            </div>
                        </div>
                         <div class="form-group">
                            <label class="col-lg-2 control-label">Edad</label>
                            <div class="col-lg-4">
                                <input type="text" class="form-control" id="fecha" name="fecha" placeholder="Pincha y elige fecha">
                            </div>
                        </div>
                       
                    </fieldset>
                    <div class="form-group">
                        <div class="col-lg-10 col-lg-offset-2">
                            <button type="reset" class="btn btn-primary">Cancelar</button>
                            <button type="submit" class="btn btn-info">Enviar</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
