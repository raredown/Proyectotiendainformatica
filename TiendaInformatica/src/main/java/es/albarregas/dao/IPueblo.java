/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Pueblo;
import java.util.ArrayList;

/**
 *
 * @author Daw2
 */
public interface IPueblo {

    public ArrayList<Pueblo> getPueblo(String clausulaWhere);

    public void closeConnection();

}
