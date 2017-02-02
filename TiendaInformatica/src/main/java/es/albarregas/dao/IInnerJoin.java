/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.MostraFactura;

/**
 *
 * @author rafa
 */
public interface IInnerJoin {

    public MostraFactura nombrePuebloProvinciaCodigoPostal(String idDirrecion);

    public void closeConnection();

}
