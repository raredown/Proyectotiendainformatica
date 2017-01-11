/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//alert("llego")
function realizaProceso(sitio) {
    // alert(valorCaja1);
   
    $.ajax({
        url: "Prueba",
        type: 'post',
        beforeSend: function () {
            $("#datitos").html("");
        },
        success: function (response) {
            $("#datitos").html(response);
        }
    });
}
function actualizarDatos(sitio){
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
