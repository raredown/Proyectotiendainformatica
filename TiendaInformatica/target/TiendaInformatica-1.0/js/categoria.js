/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function redireccionar(idcategoria) {
    var pagina = $("#pagina").val();
    var url = "Categoria?idcateindex=" + idcategoria+"&paginacion="+pagina;
    

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
function ordenar(ordenacion) {
    var idcategoria = $("#categoria").val();
   //alert(idcategoria);
    var url = "Categoria?idcateindex=" + idcategoria+"&ordenacion="+ordenacion;
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