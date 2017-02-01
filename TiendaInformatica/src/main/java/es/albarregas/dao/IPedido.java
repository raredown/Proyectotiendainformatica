/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Pedido;
import java.util.ArrayList;

/**
 *
 * @author Daw2
 */
public interface IPedido {

    public ArrayList<Pedido> getPedido(String clausulaWhere);

    public void addPedido(Pedido Pedido);

    public void updatePedido(Pedido Pedido);
    
    public void deletePedido(Pedido pedido);

    public void closeConnection();

}
