/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.LineaPedido;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daw2
 */
public class MysqlLineaPedidoDao implements ILineaPedido {

    @Override
    public ArrayList<LineaPedido> getLineaPedido(String clausulaWhere) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addLineaPedido(LineaPedido lineaPedido) {
        String sql = "INSERT INTO `empresaweb`.`lineaspedidos` (`IdPedido`, `IdProducto`, `Cantidad`, `PrecioUnitario`) VALUES (?,?,?,?);";

        try {
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setInt(1, lineaPedido.getIdPedido());
            preparada.setInt(2, lineaPedido.getIdProducto());
            preparada.setInt(3, lineaPedido.getCantidad());
            preparada.setFloat(4, lineaPedido.getPrecioUnitario());
            preparada.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlLineaPedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }

    }

    @Override
    public void updateLineaPedido(LineaPedido lineaPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteLineaPedido(LineaPedido lineaPedido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

}
