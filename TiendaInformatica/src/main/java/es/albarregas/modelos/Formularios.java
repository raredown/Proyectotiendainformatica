/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.modelos;

/**
 * Clase modelo para validaciones de formularios
 *
 * @author rafa
 */
public class Formularios {

    //Metodo que comprieba si es un usuario 
    public static boolean letrasYNumeros(String usuario) {
        if (usuario.matches("([a-z]+[0-9]{0,2}){5,12}$")) {
            return true;
        }
        return false;
    }

    public static boolean passwordIguales(String pass, String pass2) {
        //String prueba1 = pass;
        // String prueba2 = pass2;
        if (pass != "" && pass2 != "") {
            if (pass.equals(pass2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean nombres(String nombre, int tamanomaximo) {
        if (nombre.matches("[a-zA-ZàáâäãåąčćęèéêëėįìíîïłńòóôöõøùúûüųūÿýżźñçčšžÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ∂ð ,.'-]") && nombre.length() < tamanomaximo) {
            return true;
        }
        return false;

    }

    public static boolean email(String email) {
        if (email.matches("^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")) {
            
        }
        return false;
    }

    public static boolean dni(String dni) {
        if (dni.matches("(([X-Z]{1})([-]?)(\\d{7})([-]?)([A-Z]{1}))|((\\d{8})([-]?)([A-Z]{1}))")) {
            return true;
        }
        return false;

    }
}
