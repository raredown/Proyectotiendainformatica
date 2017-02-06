<%-- 
    Document   : factura
    Created on : 02-feb-2017, 20:05:59
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../includes/head.jsp" />

    </head>
    <body class="container-fluid">

        <jsp:include page="../includes/navegador.jsp" />
        <div class="row">
            <div class="col-xs-12">
                <div class="invoice-title">
                    <h2>Factura</h2><h3 class="pull-right">Numero de Factura #<c:out value="${verFactura.numeroFactura}"/> </h3>
                </div>
                <hr>
                <div class="row">
                    <div class="col-xs-6">
                        <address>
                            <strong>Facturado por:</strong><br>
                            WorldPC<br>
                            Avenida de Ámerica<br>
                            32 bajo<br>
                            Almendralejo, Badajoz 06200.
                        </address>
                    </div>
                    <div class="col-xs-6 text-right">
                        <address>
                            <strong>Recibido por:</strong><br>
                            <c:out value="${verFactura.nombreCliente}"/><br>
                            <c:out value="${verFactura.direccion}"/><<br>
                            <c:out value="${verFactura.nombreProvincia}"/><br>
                            <c:out value="${verFactura.nombrePueblo}"/>,<c:out value="${verFactura.codigoPostal}"/>
                        </address>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-6">
                        <address>
                            <strong>Método de pago:</strong><br>
                            Visa terminación **** 4242<br>
                            <c:out value="${verFactura.email}"/>
                        </address>
                    </div>
                    <div class="col-xs-6 text-right">
                        <address>
                            <strong>Emitido:</strong><br>
                            <c:out value="${verFactura.pedido.fecha}"/><br><br>
                        </address>
                    </div>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><strong>Resumen</strong></h3>
                    </div>
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-striped table-hover ">
                                <thead>
                                    <tr>
                                        <td><strong>Nombre</strong></td>
                                        <td class="text-center"><strong>Precio</strong></td>
                                        <td class="text-center"><strong>Cantidad</strong></td>
                                        <td class="text-right"><strong>Total</strong></td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <!-- foreach ($order->lineItems as $line) or some such thing here -->

                                    <c:forEach var="i" items="${requestScope.verFactura.lineaspedidos}">
                                        <tr>
                                            <td><c:out value="${i.producto.denominacion}"/></td>
                                            <td class="text-center"><fmt:formatNumber value="${i.precioUnitario-(i.precioUnitario/verFactura.pedido.iva)}" type="currency"  /></td>
                                    <td class="text-center"><c:out value="${i.cantidad}"/></td>
                                    <td class="text-right"><fmt:formatNumber value="${i.cantidad*i.precioUnitario-(i.precioUnitario/verFactura.pedido.iva)}" type="currency"  /></td>
                                    </tr>
                                </c:forEach>
                                <td class="thick-line"></td>
                                <td class="thick-line"></td>
                                <td class="thick-line text-center"><strong>Subtotal</strong></td>
                                <td class="thick-line text-right"><fmt:formatNumber value="${verFactura.pedido.baseImponible-(verFactura.pedido.baseImponible/verFactura.pedido.iva)}" type="currency"  /></td>
                                </tr>
                                <tr>
                                    <td class="no-line"></td>
                                    <td class="no-line"></td>
                                    <td class="no-line text-center"><strong>IVA  <c:out value="${verFactura.pedido.iva}"/> %</strong></td>
                                    <td class="no-line text-right"><fmt:formatNumber value="${verFactura.pedido.baseImponible/verFactura.pedido.iva}" type="currency"  /></td>
                                </tr>
                                <tr>
                                    <td>Gasto de envios</td>
                                    <td class="text-center"></td>
                                    <td class="text-center"></td>
                                    <td class="text-right"><c:out value="${verFactura.pedido.gastoEnvio}"/> €</td>
                                </tr>
                                <tr>
                                    <td class="no-line"></td>
                                    <td class="no-line"></td>
                                    <td class="no-line text-center"><strong>Total</strong></td>
                                    <td class="no-line text-right"> <fmt:formatNumber value="${verFactura.pedido.baseImponible+verFactura.pedido.gastoEnvio}" type="currency"  /></td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="../includes/footer.jsp" />
    </body>
</html>
