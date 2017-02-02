/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.MostraFactura;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafa
 */
public class MysqlInnerJoin implements IInnerJoin {

    @Override
    public MostraFactura nombrePuebloProvinciaCodigoPostal(String idDirrecion) {
        MostraFactura objeto = new MostraFactura();
        String consulta = "select pueblos.Nombre,pueblos.CodigoPostal,provincias.Nombre,direcciones.Direccion  from direcciones INNER join pueblos on(direcciones.IdPueblo = pueblos.IdPueblo) inner join provincias on (pueblos.IdProvincia=provincias.IdProvincia) where direcciones.IdDireccion =" + idDirrecion;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            try (ResultSet resultado = sentencia.executeQuery(consulta)) {
                while (resultado.next()) {
                    objeto.setNombrePueblo(resultado.getString(1));
                    objeto.setCodigoPostal(resultado.getString(2));
                    objeto.setNombreProvincia(resultado.getString(3));
                    objeto.setDireccion(resultado.getString(4));
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
