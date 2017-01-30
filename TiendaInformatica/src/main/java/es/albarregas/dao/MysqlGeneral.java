/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.General;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daw2
 */
public class MysqlGeneral implements IGeneral {

    @Override
    public General getGeneral() {
        General general = new General();
        String consulta = "SELECT * FROM general";
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            try (ResultSet resultado = sentencia.executeQuery(consulta)) {
                while (resultado.next()) {
                    General generalResultado = new General();
                    generalResultado.setGastoEnvios(resultado.getFloat("GastosEnvio"));
                    generalResultado.setIva(resultado.getFloat("Iva"));
                    general = generalResultado;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlGeneral.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }
        return general;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

}
