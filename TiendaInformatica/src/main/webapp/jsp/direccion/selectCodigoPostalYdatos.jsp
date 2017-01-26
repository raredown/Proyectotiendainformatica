<%-- 
    Document   : selectCodigoPostalYdatos
    Created on : 26-ene-2017, 18:06:18
    Author     : Daw2
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="form-group">

    <label class="col-lg-2 control-label">Codigo postal:</label>
    <div class="col-lg-4">
        <select class="form-control" id="selectcodigopostal"  >
            <c:forEach var="i" items="${requestScope.pueblos}">
                <option value="<c:out value="${i.idPueblo}"/>"><c:out value="${i.codigoPostal}" /></option>
            </c:forEach>
        </select>
    </div>
</div>
<div class="form-group">
    <label for="dirrecioncalle" class="col-lg-2 control-label">Dirreción:</label>
    <div class="col-lg-4">
        <input type="text" class="form-control" id="dirrecionCalle" placeholder="dirrecion" name="dirrecionCalle"  required>
    </div>
</div>
<div class="form-group">
    <label for="direcionNombre" class="col-lg-2 control-label">Nombre de esta Dirreción:</label>
    <div class="col-lg-4">
        <input type="text" class="form-control" id="direcionNombre" placeholder="nombre dirrecion" name="direcionNombre"  required>
    </div>
</div>
<div class="form-group">
    <label for="direcionNombre" class="col-lg-2 control-label">Teléfono:</label>
    <div class="col-lg-4">
        <input type="text" class="form-control" id="telefono" placeholder="telefono" name="telefono"  required>
    </div>
</div>
<div class="form-group">
    <div class="col-lg-10 col-lg-offset-2">
        
        <button type="submit" class="btn btn-info">Añadir</button>
    </div>
</div>
