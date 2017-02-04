<%-- 
    Document   : datosusuario
    Created on : 11-ene-2017, 12:20:08
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <div class="col-md-6">
        <form class="form-horizontal" method="post" action="PanelAdministrador
            <fieldset>
                <legend>Datos Usuario</legend>
              <div class="form-group">
                    <label for="inputContrasena" class="col-lg-2 control-label">Vieja Contraseñas</label>
                    <div class="col-lg-4">
                        <input type="password" class="form-control" id="pass" required="required" name="pass" onblur="contrasena()"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputContrasena" class="col-lg-2 control-label">Nueva Contraseñas</label>
                    <div class="col-lg-4">
                        <input type="password" class="form-control" id="pass1" required="required" name="pass1"/>
                    </div>
                </div>
                  <div class="form-group">
                    <label for="inputContrasena2" class="col-lg-2 control-label">Repita Contraseñas</label>
                    <div class="col-lg-4">
                        <input type="password" class="form-control" id="pass2" required="required" name="pass2" onblur="validacion()"/>
                    </div>
                </div>
                <input type="hidden" name="paneles" value="datosusuario">
            </fieldset>
            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                    <button type="reset" class="btn btn-primary">Cancelar</button>
                    <button type="submit" class="btn btn-info">Actualizar</button>
                </div>
            </div>
        </form>
    </div>