/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;


import es.albarregas.beans.Cliente;
import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public interface ICliente {
    public ArrayList<Cliente> getCliente(String clausulaWhere);
    public void addCliente (Cliente cliente);
    public void updateCliente(Cliente cliente);
    public void closeConnection();
    
}
