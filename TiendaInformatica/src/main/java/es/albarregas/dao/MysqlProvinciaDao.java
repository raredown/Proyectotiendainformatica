/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Provincia;
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
public class MysqlProvinciaDao implements IProvincia {

    @Override
    public ArrayList<Provincia> getProvincia(String clausulaWhere) {
        ArrayList<Provincia> lista = new ArrayList();
        if (clausulaWhere == null) {
            clausulaWhere = "";
        }
        String consulta = "SELECT * FROM provincias " + clausulaWhere;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            try (ResultSet resultado = sentencia.executeQuery(consulta)) {
                while (resultado.next()) {
                    Provincia provincia = new Provincia();
                    provincia.setIdProvincia(resultado.getInt("IdProvincia"));
                    provincia.setNombre(resultado.getString("Nombre"));
                    
                    lista.add(provincia);
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

}
