/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function busquedaSimple() {


    var buscador = $("#buscador").val();

    $.ajax({
        url: "BuscadorSimple?buscador=" + buscador,
        type: 'get',
        beforeSend: function () {
            $("#recarga").html("Procesando, espere por favor...");
        },
        success: function (response) {
            $("#recarga").html(response);
        }
    });
    return false;
}

