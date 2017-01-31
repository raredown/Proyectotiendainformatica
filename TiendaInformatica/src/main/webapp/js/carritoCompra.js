/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $("#success-alert").hide();
});

function addCarrito(idProducto) {
// alert(valorCaja1);
    alert(idProducto);
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

