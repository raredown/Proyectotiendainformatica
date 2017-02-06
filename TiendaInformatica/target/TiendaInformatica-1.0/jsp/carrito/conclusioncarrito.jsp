<%-- 
    Document   : conclusioncarrito
    Created on : 02-feb-2017, 17:06:59
    Author     : rafa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../includes/head.jsp" />
    </head>
    <body class="container-fluid" style="font-family: 'Open Sans', sans-serif;">
        <jsp:include page="../includes/navegador.jsp" />

        <div class="container">
            <div class="centered title"><h1>Finaliza su pago.</h1></div>
        </div>
        <hr class="featurette-divider"></hr>
        <div class="container">
            <div class="row">
                <div class="col-sm-6">
                    <div class="tab-content">
                        <div id="stripe" class="tab-pane fade in active">
                            <script src='https://js.stripe.com/v2/' type='text/javascript'></script>
                            <br>
                            <form method="post" action="ConclusionCarrito">
                                <div class='form-row'>
                                    <div class='form-group required'>
                                        <div class='error form-group hide'>
                                            <div class='alert-danger alert'>
                                                Corrige su datos.

                                            </div>
                                        </div>
                                        <label class='control-label'>Nombre de la tarjeta</label>
                                        <input class='form-control' size='4' type='text'>
                                    </div>

                                </div>
                                <div class='form-row'>
                                    <div class='form-group card required'>
                                        <label class='control-label'>Número de la tarjeta </label>
                                        <input autocomplete='off' class='form-control card-number' size='20' type='text'>
                                    </div>
                                </div>

                                <div class='form-row'>
                                    <div class='form-group cvc required'>
                                        <label class='control-label'>CVC</label>
                                        <input autocomplete='off' class='form-control card-cvc' placeholder='ex. 311' size='4' type='text'>
                                    </div>
                                    <div class='form-group expiration required'>
                                        <label class='control-label'>Espiración</label>
                                        <input class='form-control card-expiry-month' placeholder='MM' size='2' type='text'>
                                    </div>
                                    <div class='form-group expiration required'>
                                        <label class='control-label'>Año</label>
                                        <input class='form-control card-expiry-year' placeholder='YYYY' size='4' type='text'>
                                    </div>
                                </div>


                                <div class='form-row'>
                                    <label class='control-label'>Dirreción</label>
                                    <select class="form-control" id="dirreccionescojida" name="dirreccionescojida" >
                                        <c:forEach var="i" items="${sessionScope.dirreciones}">
                                            <option value="<c:out value="${i.idDireccion}"/>"><c:out value="${i.nombreDirrecion}" /></option>
                                        </c:forEach>
                                    </select>
                                    <div class='form-group'>
                                        <label class='control-label'></label>

                                        <button class='form-control btn btn-primary' type='submit'> Continuar →</button>



                                    </div>
                                </div>    
                            </form> 
                        </div>

                        <div id="paypal" class="tab-pane fade">
                            <form action="?" id="paypalForm" method="POST">
                                <div class="paypalResult"><!-- content will load here --></div>
                                <br>
                                <input type="hidden" id="action" value="paypal"></input>
                                <input type="hidden" id="token" value="token-supersecuretoken123123123"></input>
                                <a href="#paypal"><img src="https://www.paypalobjects.com/webstatic/en_US/i/buttons/checkout-logo-large.png" alt="paypal" width="100%"></a>
                                <br><br><br>
                                <div class='form-group card required'>
                                    <label class='control-label'>Dirreción</label>
                                    <select class="form-control" id="dirreccionescojida" name="dirreccionescojida" >
                                        <c:forEach var="i" items="${sessionScope.dirreciones}">
                                            <option value="<c:out value="${i.idDireccion}"/>"><c:out value="${i.nombreDirrecion}" /></option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <button class='form-control btn btn-primary submit-button' type='submit'> Continuar →</button>
                        </div>
                    </div>



                </div>   

                <div class="col-sm-6">
                    <label class='control-label'></label><!-- spacing -->

                    <div class="alert alert-info">Por favor escoja su método de pago.</div>
                    <br>
                    <div class="btn-group-vertical btn-block">
                        <a class="btn btn-default" style="text-align: left;" data-toggle="tab" href="#stripe">Tarjeta de crédito</a>
                        <a class="btn btn-default" style="text-align: left;" data-toggle="tab" href="#paypal">PayPal</a>
                    </div>

                    <br><br><br>

                    <div class="jumbotron jumbotron-flat">
                        <div>Precio de su compra:<c:out value="${sessionScope.carrito.baseImponible}"/>€</div>
                        <div>Gastos de envios:<c:out value="${sessionScope.carrito.gastoEnvio}"/>€</div>
                        <div class="center"><h2><i>Precio final:</i></h2></div>

                        <div class="paymentAmt" style="font-size: 70px;"><fmt:formatNumber value="${sessionScope.carrito.baseImponible+sessionScope.carrito.gastoEnvio}" type="currency"  /></div>



                    </div>



                    <br><br><br>
                </div>



            </div>



        </div>
    </div>


</form>


<jsp:include page="../includes/footer.jsp" />
</body>
</html>
