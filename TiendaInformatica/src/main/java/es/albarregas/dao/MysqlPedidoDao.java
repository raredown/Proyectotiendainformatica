/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Pedido;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daw2
 */
public class MysqlPedidoDao implements IPedido {

    @Override
    public ArrayList<Pedido> getPedido(String clausulaWhere) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addPedido(Pedido Pedido) {
        String sql = "INSERT INTO `empresaweb`.`clientes` (`IdCliente`, `Nombre`, `Apellidos`, `Email`, `NIF`,`FechaNacimiento`,`FechaAlta`) VALUES (?, ?, ?, ?, ?,?,?)";
        try {
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
        } catch (SQLException ex) {
            Logger.getLogger(MysqlPedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updatePedido(Pedido Pedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

}
