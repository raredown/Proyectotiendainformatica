/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Factura;

/**
 *
 * @author rafa
 */
public interface IFactura {

    public void addFactura(Factura factura);

    public void closeConnection();

}
