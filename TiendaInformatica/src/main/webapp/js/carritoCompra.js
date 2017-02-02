/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("#success-alert").hide();
    $("#danger-alert").hide();
    $("#danger-borrado").hide();
    $("#peligromensaje").hide();
    mostrarmensaje();
    actualizarTotal();

});

function addCarrito(idProducto) {
// alert(valorCaja1);
    // alert(idProducto);
    var url = "ControladorCarrito?idProducto=" + idProducto;
    $.ajax({
        url: url,
        type: 'get',
        beforeSend: function () {
//            $("#datitos").html("");
        },
        success: function (response) {
//            $("#datitos").html(response);
            if (response == "ok") {
                //alert("Se ha añadido correctamente");
                $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
                    $("#success-alert").slideUp(500);
                });
            }

            //  alert(response);

        }

    });

}
function addLinea(idLinea, accion) {
// alert(valorCaja1);

    var url = "PanelCarrito?idLinea=" + idLinea + "&accion=" + accion;
    $.ajax({
        url: url,
        type: 'get',
        beforeSend: function () {
//            $("#datitos").html("");
        },
        success: function (response) {
//            $("#datitos").html(response);
            if (response != "0") {
                actualizarTotal();
                //alert("Se ha añadido correctamente");
                $("#success-alert").fadeTo(2000, 500).slideUp(500, function () {
                    $("#success-alert").slideUp(500);
                });
                //alert(response);
                $("#input" + idLinea).val(response);
            } else {
                $("#danger-alert").fadeTo(2000, 500).slideUp(500, function () {
                    $("#danger-alert").slideUp(500);
                });
            }

            //  alert(response);

        }

    });

}
function menosLinea(idLinea) {
// alert(valorCaja1);

    var url = "PanelCarrito?idLinea=" + idLinea + "&accion=menos";
    $.ajax({
        url: url,
        type: 'get',
        beforeSend: function () {
//            $("#datitos").html("");
        },
        success: function (response) {
            actualizarTotal();
            //  alert("llego menos");
//            $("#datitos").html(response);
            if (response != "0") {

                //alert("Se ha añadido correctamente");
                $("#danger-borrado").fadeTo(2000, 500).slideUp(500, function () {
                    $("#danger-borrado").slideUp(500);
                });
                //alert(response);
                $("#input" + idLinea).val(response);
            } else {
                $("#" + idLinea).html("");
            }

            //  alert(response);

        }

    });

}
function deleteLinea(idLinea) {
// alert(valorCaja1);

    var url = "PanelCarrito?idLinea=" + idLinea + "&accion=delete";
    alert(url);
    $.ajax({
        url: url,
        type: 'get',
        beforeSend: function () {
//            $("#datitos").html("");
        },
        success: function (response) {
            actualizarTotal();
//            $("#datitos").html(response);
            //  alert("llego delete");
            if (response == "0") {
                //alert("Se ha añadido correctamente");
                $("#danger-borrado").fadeTo(2000, 500).slideUp(500, function () {
                    $("#danger-borrado").slideUp(500);
                });
                //alert(response);
                $("#" + idLinea).html("");
            } else {

            }

            //  alert(response);

        }

    });

}
function actualizarTotal() {
    // alert("llego");

    var url = "PanelCarrito";

    $.ajax({
        url: url,
        type: 'post',
        beforeSend: function () {

        },
        success: function (response) {
            // alert("llego response");
            $("#baseImponible").html(response);
        }

    });

}
function mostrarmensaje() {
   // alert($("#inputmensajito").val());
    if ($("#inputmensajito").val() == 1) {
        $("#peligromensaje").fadeTo(4000, 500).slideUp(500, function () {
            $("#peligromensaje").slideUp(500);
        });
    }
}