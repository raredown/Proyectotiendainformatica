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
    public void addPedido(Pedido pedido) {
        String sql = "INSERT INTO pedidos (`Fecha`, `Estado`, `BaseImponible`, `Descuento`,`GastosEnvio`,`Iva`,`IdDireccion`,`IdCliente`) VALUES (?, ?, ?, ?, ?,?,?,?)";
        try {
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setDate(1, pedido.getFecha());
            preparada.setString(2, pedido.getEstado());
            preparada.setFloat(3, pedido.getBaseImponible());
            preparada.setFloat(4, pedido.getDescuento());
            preparada.setFloat(5, pedido.getGastoEnvio());
            preparada.setFloat(6, pedido.getIva());
            preparada.setInt(7, pedido.getIdDireccion());
            if (pedido.getIdCliente() != 0) {
                preparada.setInt(8, pedido.getIdCliente());
            } else {
                preparada.setNull(8, java.sql.Types.INTEGER);
               
            }
            preparada.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlPedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
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
