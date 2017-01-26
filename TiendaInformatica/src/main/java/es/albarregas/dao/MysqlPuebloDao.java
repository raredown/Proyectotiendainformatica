/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Pueblo;
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
public class MysqlPuebloDao implements IPueblo {

    @Override
    public ArrayList<Pueblo> getPueblo(String clausulaWhere) {
        ArrayList<Pueblo> lista = new ArrayList();
        if (clausulaWhere == null) {
            clausulaWhere = "";
        }
        String consulta = "SELECT DISTINCT Nombre FROM pueblos " + clausulaWhere;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            try (ResultSet resultado = sentencia.executeQuery(consulta)) {
                while (resultado.next()) {
                    Pueblo pueblo = new Pueblo();

                    pueblo.setNombre(resultado.getString("Nombre"));
                    lista.add(pueblo);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProvinciaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }
        return lista;
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

    @Override
    public ArrayList<Pueblo> getPuebloCodigoPostal(String clausulaWhere) {
        ArrayList<Pueblo> lista = new ArrayList();
        if (clausulaWhere == null) {
            clausulaWhere = "";
        }
        String consulta = "SELECT * FROM pueblos " + clausulaWhere;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            try (ResultSet resultado = sentencia.executeQuery(consulta)) {
                while (resultado.next()) {
                    Pueblo pueblo = new Pueblo();
                    pueblo.setIdProvincia(resultado.getInt("IdProvincia"));
                    pueblo.setIdPueblo(resultado.getInt("IdPueblo"));
                    pueblo.setCodigoPostal(resultado.getString("CodigoPostal"));
                    pueblo.setNombre(resultado.getString("Nombre"));
                    lista.add(pueblo);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProvinciaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }
        return lista;
    }

}
