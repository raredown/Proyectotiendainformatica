/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.General;

/**
 *
 * @author Daw2
 */
public interface IGeneral {
    public General getGeneral();
    public void closeConnection();
    
}
