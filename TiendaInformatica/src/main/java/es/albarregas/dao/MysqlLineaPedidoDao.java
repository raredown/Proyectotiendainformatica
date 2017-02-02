/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.LineaPedido;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        ArrayList<LineaPedido> lista = new ArrayList();
        if (clausulaWhere == null) {
            clausulaWhere = "";
        }
        String consulta = "SELECT * FROM lineaspedidos " + clausulaWhere;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            try (ResultSet resultado = sentencia.executeQuery(consulta)) {
                while (resultado.next()) {
                    LineaPedido linepe = new LineaPedido();
                    
                    linepe.setIdPedido(resultado.getInt("IdPedido"));
                    linepe.setIdProducto(resultado.getInt("IdProducto"));
                    linepe.setNumeroLinea(resultado.getInt("NumeroLinea"));
                    linepe.setPrecioUnitario(resultado.getFloat("PrecioUnitario"));
                    linepe.setCantidad(resultado.getInt("Cantidad"));
                    lista.add(linepe);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlPedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }
        return lista;

    }

    @Override
    public void addLineaPedido(LineaPedido lineaPedido) {
        String sql = "INSERT INTO `empresaweb`.`lineaspedidos` (`IdPedido`, `IdProducto`, `Cantidad`, `PrecioUnitario`,`NumeroLinea`) VALUES (?,?,?,?,?);";

        try {
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);

            preparada.setInt(1, lineaPedido.getIdPedido());
            preparada.setInt(2, lineaPedido.getIdProducto());
            preparada.setInt(3, lineaPedido.getCantidad());
            preparada.setFloat(4, lineaPedido.getPrecioUnitario());
            preparada.setInt(5, lineaPedido.getNumeroLinea());
            preparada.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlLineaPedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }

    }

    @Override
    public void updateLineaPedido(LineaPedido lineaPedido) {
        String sql = "UPDATE `empresaweb`.`lineaspedidos` SET `IdProducto`=?, `Cantidad`=?, `PrecioUnitario`=? WHERE `IdPedido`=? and `NumeroLinea`=?;";

        PreparedStatement preparada;
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setInt(1, lineaPedido.getIdProducto());
            preparada.setInt(2, lineaPedido.getCantidad());
            preparada.setFloat(3, lineaPedido.getPrecioUnitario());
            preparada.setInt(4, lineaPedido.getIdPedido());

            preparada.setInt(5, lineaPedido.getNumeroLinea());
            preparada.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlLineaPedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }

    }

    @Override
    public void deleteLineaPedido(LineaPedido lineaPedido) {
        String sql = "DELETE FROM `empresaweb`.`lineaspedidos` WHERE  `IdPedido`=? AND `NumeroLinea`=?;";
        PreparedStatement preparada;
        try {
            preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setInt(1, lineaPedido.getIdPedido());
            preparada.setInt(2, lineaPedido.getNumeroLinea());
            preparada.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlLineaPedidoDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

}
