/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//alert("llego");
function unProducto(idproducto) {
   // alert(idproducto);
    var url = "Producto?idproducto=" + idproducto;


    $.ajax({
        url: url,
        type: 'get',
        beforeSend: function () {
            $("#recarga").html("Procesando, espere por favor...");
        },
        success: function (response) {
            $("#recarga").html(response);
        }
    });


}

