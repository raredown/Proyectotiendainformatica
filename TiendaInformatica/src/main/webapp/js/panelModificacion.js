/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//alert("llego")
function realizaProceso(sitio) {
    // alert(valorCaja1);

    $.ajax({
        url: sitio,
        type: 'post',
        beforeSend: function () {
            $("#datitos").html("");
        },
        success: function (response) {
            $("#datitos").html(response);
        }
    });
}
function actualizarDatos(sitio) {
    $.ajax({
        url: sitio,
        type: 'post',
        beforeSend: function () {
            $("#datitos").html("Procesando, espere por favor...");
        },
        success: function (response) {
            $("#datitos").html(response);
        }
    });

}
function validacion() {

    var password1 = document.getElementById('pass1');
    var password2 = document.getElementById('pass2');

    if (password1.value != password2.value) {
        //alert(password1+"         "+password2);
        password1.setCustomValidity("Las contraseñas deben ser iguales");
        password2.setCustomValidity("Las contraseñas deben ser iguales");

    } else {

        password1.setCustomValidity("");
        password2.setCustomValidity("");
    }

}
function contrasena() {
    var password = $('#pass');
    // var pase =document.getElementById('pass');
    //alert(password);
    var pasServer;
    $.ajax({
        url: "PanelCliente",
        type: 'post',
        dataType: "json",
        success: function (response) {
            pasServer = response.clave;
            //alert("puede ser la clave"+response.clave);
            if (password.val() == pasServer) {
                //alert("entro2");
                //pase.setCustomValidity("Las contraseñas deben ser iguales");
                //$('#pass').get(0).setCustomValidity('The two email addresses must match.');
                password.get(0).setCustomValidity("");
            } else {
                password.get(0).setCustomValidity('No es la contraseña antigua.');
                
            }
        }
    });
    //alert(pasServer);

}
function cargarPueblos() {
     alert("llego");
     alert($("#provincias").select().val());
     var id = $("#provincias").select().val();

    $.ajax({
        url: "ContraladorPueblo?idProvincia = "+id,
        type: 'get',
        beforeSend: function () {
            $("#pueblos").html("");
        },
        success: function (response) {
            $("#pueblos").html(response);
        }
    });
}