/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Producto;
import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public interface IProducto {
    public ArrayList<Producto> getProducto(String clausulaWhere);
    public void closeConnection();
    
}
