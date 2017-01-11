<%-- 
    Document   : datosusuario
    Created on : 11-ene-2017, 12:20:08
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <form class="form-horizontal" method="post" action="ConCliente">
            <fieldset>
                <legend>Datos Usuario</legend>
                <div class="form-group">
                    <label class="col-lg-2 control-label">Usuario</label>
                    <div class="col-lg-4">
                        <input  class="form-control" type="text" id="Username" required="required" name="usuario" pattern="([a-z]+[0-9]{0,2}){5,12}$" required/>

                    </div>
                </div>
                <div class="form-group">
                    <label for="inputContrasena" class="col-lg-2 control-label">Contraseñas</label>
                    <div class="col-lg-4">
                        <input type="password" class="form-control" id="Password" required="required" name="pass"/>
                    </div>
                </div>
                  <div class="form-group">
                    <label for="inputContrasena2" class="col-lg-2 control-label">Nueva Contraseñas</label>
                    <div class="col-lg-4">
                        <input type="password2" class="form-control" id="Password" required="required" name="pass2"/>
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