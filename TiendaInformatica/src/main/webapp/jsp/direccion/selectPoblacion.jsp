<%-- 
    Document   : selectPoblacion
    Created on : 26-ene-2017, 16:59:48
    Author     : Daw2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="form-group">
    
    <label class="col-lg-2 control-label">Pueblos:</label>
    <div class="col-lg-4">
        <select class="form-control" id="selectpueblos" onchange="cargarCodigoPostal()" >
            <c:forEach var="i" items="${requestScope.pueblos}">
                <option value="<c:out value="${i.nombre}"/>"><c:out value="${i.nombre}" /></option>
            </c:forEach>
        </select>
    </div>
</div>