<%-- 
    Document   : porcategoria
    Created on : 15-ene-2017, 23:31:33
    Author     : rafa
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! categoria</h1>
        <c:set var="salary" scope="session" value="${2000*2}"/>
        <c:out value="${sessionScopesalary}"/>
        <c:out value="${requestScope.idcateindex}"/>
        <c:out value="${requestScope.nene}"/>
        <c:out value="${applicationScope.productos[0].denominacion}"/>

        <c:forEach var="item" items="${applicationScope.productos}">
            <c:if test="${item.idCategoria == requestScope.idcategoria}">
                <c:out value="${item.denominacion}"/>
            </c:if>
        </c:forEach>
    </body>
</html>
