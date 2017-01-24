/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.LineaPedido;
import java.util.ArrayList;

/**
 *
 * @author Daw2
 */
public interface ILineaPedido {
    public ArrayList<LineaPedido> getLineaPedido(String clausulaWhere);

    public void addLineaPedido(LineaPedido lineaPedido);

    public void updateLineaPedido(LineaPedido lineaPedido);
    
    public void deleteLineaPedido(LineaPedido lineaPedido);

    public void closeConnection();
}
