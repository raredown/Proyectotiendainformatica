/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Imagen;
import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public interface IImagen {
    public ArrayList<Imagen> getImagen(String clausulaWhere);
    public void closeConnection();
}
