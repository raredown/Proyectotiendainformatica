/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Factura;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafa
 */
public class MysqlFacturaDao implements IFactura {

    @Override
    public void addFactura(Factura factura) {
        String sql = "INSERT INTO `empresaweb`.`facturas` (`IdPedido`) VALUES (?);";
        try {
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setInt(1, factura.getIdPedido());
            preparada.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlFacturaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public Factura getoneFactura(String idpedido) {
        Factura objeto = new Factura();
        String consulta = "SELECT `NumeroFactura`, `IdPedido` FROM `empresaweb`.`facturas` WHERE  `IdPedido`="+idpedido;
        
         try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            try (ResultSet resultado = sentencia.executeQuery(consulta)) {
                while (resultado.next()) {
                    objeto.setIdPedido(resultado.getInt("IdPedido"));
                    objeto.setNumeroDeFactura(resultado.getInt("NumeroFactura"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProducto.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }
        return objeto;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

}
