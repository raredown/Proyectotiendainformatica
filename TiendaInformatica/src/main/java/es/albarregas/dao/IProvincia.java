/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Provincia;
import java.util.ArrayList;

/**
 *
 * @author Daw2
 */
public interface IProvincia {

    public ArrayList<Provincia> getProvincia(String clausulaWhere);

    public void closeConnection();
}
