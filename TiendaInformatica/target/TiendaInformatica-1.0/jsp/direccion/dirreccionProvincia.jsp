<%-- 
    Document   : selectDirrecion
    Created on : 25-ene-2017, 19:24:50
    Author     : Daw2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div class="col-md-6">
    <div class="panel-group" id="accordion">
        <c:if test="${not empty sessionScope.dirreciones}">
            <c:forEach var="i" items="${sessionScope.dirreciones}">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion" href="#<c:out value="${i.idDireccion}"/>"><c:out value="${i.nombreDirrecion}"/></a>
                        </h4>
                    </div>
                    <div id="<c:out value="${i.idDireccion}"/>" class="panel-collapse collapse">
                        <div class="panel-body">
                            <p>Calle: <c:out value="${i.direccion}"/></p> 
                            <p>Codigo postal : <c:out value="${i.codigoPostal}"/></p> 
                            <p>Telefono:<c:out value="${i.telefono}"/> </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </c:if>
      
    </div> 

    <form class="form-horizontal" method="post" action="ControladorDireccion">
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
            <div id="contenedorformdirrecion">

            </div>

        </fieldset>

    </form>

</div>
