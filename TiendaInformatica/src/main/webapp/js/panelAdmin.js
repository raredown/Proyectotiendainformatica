/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function realizaProcesoAdmin(sitio) {
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
function bloquear(id) {
    //  alert(id);
    selecionado = "n";

    if ($('#' + id).prop('checked')) {
        // alert('Seleccionado');
        selecionado = "s";
    } else
    {
        selecionado = "n";
    }
    // alert(id);
    sitio = "PanelAdministrador?bloquear=" + id + "&selecionado=" + selecionado;

    $.ajax({
        url: sitio,
        type: 'get'
    });
}
function updatebloquearProducto(id) {
    alert(id);
    selecionado = "n";
    // alert(id);
    if ($('#' + id).prop('checked')) {
        // alert('Seleccionado');
        selecionado = "s";
    } else
    {
        selecionado = "n";
    }
    alert(id);
    sitio = "PanelAdministrador?bloquearproducto=" + id + "&selecionado=" + selecionado;
    alert(sitio);
    $.ajax({
        url: sitio,
        type: 'get'
    });
}
function updatestock(id, input) {
    alert(id);
    inputval = $("#" + input).val();

    sitio = "PanelAdministrador?id=" + id + "&stock=" + inputval;
    alert(sitio);
    $.ajax({
        url: sitio,
        type: 'get'
    });
}
