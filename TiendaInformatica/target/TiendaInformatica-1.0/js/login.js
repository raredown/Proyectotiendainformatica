/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {
    $('.toggle').on('click', function () {
        $('.container').stop().addClass('active');
    });

    $('.close').on('click', function () {
        $('.container').stop().removeClass('active');
    });

});
function validacion() {

    var password1 = document.getElementById('password');
    var password2 = document.getElementById('password2');

    if (password1.value != password2.value) {
        //alert(password1+"         "+password2);
        password1.setCustomValidity("Las contraseñas deben ser iguales");
        password2.setCustomValidity("Las contraseñas deben ser iguales");

    } else {

        password1.setCustomValidity("");
        password2.setCustomValidity("");
    }



}