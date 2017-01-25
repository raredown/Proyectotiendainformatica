<%-- 
    Document   : selectDirrecion
    Created on : 25-ene-2017, 19:24:50
    Author     : Daw2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-6">

    <form class="form-horizontal" method="post">
        <fieldset>
            <legend>Nueva Dirrecion</legend>
            <div class="form-group">
                <label class="col-lg-2 control-label">Provincia:</label>
                <div class="col-lg-4">
                    <select class="form-control" id="provincias" onchange="cargarPueblos()" >
                        <c:forEach var="i" items="${requestScope.provincias}">
                            <option value="<c:out value="${i.idProvincia}"/>"><c:out value="${i.nombre}" /></option>
                        </c:forEach>
                    </select>
                </div>
            </div>
          

            <div id="pueblos">

              
            </div>
            <div id="codigoPostal">
              
            </div>
            <div id="datoscomplementario">
                
            </div>
            <div class="form-group">
                <div class="col-lg-10 col-lg-offset-2">
                    <button type="reset" class="btn btn-primary">Cancelar</button>
                    <button type="submit" class="btn btn-info">Añadir</button>
                </div>
            </div>
        </fieldset>

    </form>

</div>
