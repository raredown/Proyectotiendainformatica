<%-- 
    Document   : datoscliente
    Created on : 11-ene-2017, 12:10:39
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="col-md-6">
        <form class="form-horizontal" method="post" action="PanelCliente">
            <fieldset>
                <legend>Datos Personales</legend>
                <div class="form-group">
                    <label class="col-lg-2 control-label">Nombre</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="nombre" placeholder="Nombre" name="nombre" pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,24}" value="<c:out value="${sessionScope.cliente.nombre}"/>" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputApellido" class="col-lg-2 control-label">Apellidos</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="apellidos" placeholder="Apellidos" name="apellidos" pattern="[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]{2,39}" value="<c:out value="${sessionScope.cliente.apellidos}"/>" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail" class="col-lg-2 control-label">Email</label>
                    <div class="col-lg-10">
                        <input class="form-control" type="email" name="email" id="email" pattern="^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" value="<c:out value="${sessionScope.cliente.email}"/>" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-lg-2 control-label">NIF</label>
                    <div class="col-lg-10">
                        <input type="text" class="form-control" id="nif" placeholder="Letra del dni en mayúscula" name="nif" pattern="(([X-Z]{1})([-]?)(\d{7})([-]?)([A-Z]{1}))|((\d{8})([-]?)([A-Z]{1}))" value="<c:out value="${sessionScope.cliente.nif}"/>" required>
                    </div>
                </div>
                    <input type="hidden" name="paneles" value="datosclientes">
                <div class="form-group">
                    <label class="col-lg-2 control-label">Edad</label>
                    <div class="col-lg-4">
                        <input type="text" class="form-control" id="fecha" name="fecha" placeholder="Pincha y elige fecha" value="<c:out value="${sessionScope.cliente.fechaNacimiento}"/>">
                    </div>
                </div>

            </fieldset>
            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                    <button type="reset" class="btn btn-primary">Cancelar</button>
                    <button type="submit" class="btn btn-info">Actualizar</button>
                </div>
            </div>
        </form>
    </div>
