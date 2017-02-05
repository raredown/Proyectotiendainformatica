<%-- 
    Document   : footer
    Created on : 24-ene-2017, 16:30:09
    Author     : Daw2
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="https://fortawesome.github.io/Font-Awesome/assets/font-awesome/css/font-awesome.css" rel="stylesheet">

<!-- Modal -->
<!-- Trigger the modal with a button -->




<!--footer start from here-->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-sm-6 footerleft ">
                <div class="logofooter"> General</div>
                <p>WorldPc es una empresa creada el dos de febrero de 2017 para la venta de productos informáticos.</p>
                <p><i class="fa fa-map-pin"></i> Avenida de Ámerica, 32 bajo ,Almendralejo, Badajoz 06200.</p>
                <p><i class="fa fa-phone"></i> Teléfono (España) : +91 9999 878 398</p>
                <p><i class="fa fa-envelope"></i> E-mail : raredown@gmail.com</p>

            </div>
            <div class="col-md-2 col-sm-6 paddingtop-bottom">
                <h6 class="heading7">LINKS UTILES</h6>
                <ul class="footer-ul">
                    <li><a type="button"  data-toggle="modal" data-target="#myModal">Contacta con nosotros</a></li>
                    <li><a href="#"> Política de privacidad</a></li>
                    <li><a href="#"> Terminos y condiciones</a></li>
                    <li><a type="button"  data-toggle="modal" data-target="#myModal1">Trabaja con nosotros</a></li>

                </ul>
            </div>
            <div class="col-md-3 col-sm-6 paddingtop-bottom">
                <h6 class="heading7">Redes sociales</h6>
                <div class="post">
                    <a href="#"><i id="social-fb" class="fa fa-facebook-square fa-3x social"></i></a>
                    <a href="#"><i id="social-tw" class="fa fa-twitter-square fa-3x social"></i></a>
                    <a href="#"><i id="social-gp" class="fa fa-google-plus-square fa-3x social"></i></a>
                    <a href="#"><i id="social-em" class="fa fa-envelope-square fa-3x social"></i></a>
                </div>
            </div>

        </div>
    </div>
</footer>
<!--footer start from here-->

<div class="copyright">
    <div class="container">
        <div class="col-md-6">
            <p>© 2017 - Derechos reserbados por Rafael Retamal</p>
        </div>

    </div>
</div>
<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Contacta</h4>
            </div>
            <div class="modal-body">
                <div class="well well-sm">
                    <form class="form-horizontal" action="" method="post">
                        <fieldset>
                            <legend class="text-center"></legend>

                            <!-- Name input-->
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="name">Nombre</label>
                                <div class="col-md-9">
                                    <input id="name" name="name" type="text" placeholder="Su nombre" class="form-control">
                                </div>
                            </div>

                            <!-- Email input-->
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="email">Su E-mail</label>
                                <div class="col-md-9">
                                    <input id="email" name="email" type="text" placeholder="Su email" class="form-control">
                                </div>
                            </div>

                            <!-- Message body -->
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="message">Su mensaje</label>
                                <div class="col-md-9">
                                    <textarea class="form-control" id="message" name="message" placeholder="Su mensaje aqui..." rows="5"></textarea>
                                </div>
                            </div>

                            <!-- Form actions -->
                            <div class="form-group">
                                <div class="col-md-12 text-right">
                                    <button type="submit" class="btn btn-primary btn-lg">Enviar</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        </div>
    </div>

</div>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal1" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Trabaja con nosotros</h4>
            </div>
            <div class="modal-body">
                <div class="well well-sm">
                    <form class="form-horizontal" action="" method="post">
                        <fieldset>
                            <legend class="text-center"></legend>

                            <!-- Name input-->
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="name">Nombre</label>
                                <div class="col-md-9">
                                    <input id="name" name="name" type="text" placeholder="Su nombre" class="form-control">
                                </div>
                            </div>

                            <!-- Email input-->
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="email">Su E-mail</label>
                                <div class="col-md-9">
                                    <input id="email" name="email" type="text" placeholder="Su email" class="form-control">
                                </div>
                            </div>

                            <!-- Message body -->
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="message">Carta de presentación</label>
                                <div class="col-md-9">
                                    <textarea class="form-control" id="message" name="message" placeholder="Carta de presentación..." rows="5"></textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-md-3 control-label" for="message">CV</label>
                                <div class="col-md-9">
                                    <input id="cv" name="cv" type="file" placeholder="Su email" class="form-control">            
                                </div>
                            </div>
                            <!-- Form actions -->
                            <div class="form-group">
                                <div class="col-md-12 text-right">
                                    <button type="submit" class="btn btn-primary btn-lg">Enviar</button>
                                </div>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
        </div>
    </div>

</div>
</div>