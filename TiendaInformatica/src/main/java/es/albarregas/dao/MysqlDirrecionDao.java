/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Dirrecion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafa
 */
public class MysqlDirrecionDao implements IDirrecion {

    @Override
    public ArrayList<Dirrecion> getDirrecion(String clausulaWhere) {
        ArrayList<Dirrecion> lista = new ArrayList();
        if (clausulaWhere == null) {
            clausulaWhere = "";
        }
        String consulta = "SELECT * FROM direcciones " + clausulaWhere;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            try (ResultSet resultado = sentencia.executeQuery(consulta)) {
                while (resultado.next()) {
                    Dirrecion dirrecion = new Dirrecion();
                    dirrecion.setCodigoPostal(resultado.getString("CodigoPostal"));
                    dirrecion.setDireccion(resultado.getString("Direccion"));
                    dirrecion.setIdCliente(resultado.getInt("IdCliente"));
                    dirrecion.setIdDireccion(resultado.getInt("IdDireccion"));
                    dirrecion.setIdPueblo(resultado.getInt("IdPueblo"));
                    dirrecion.setNombreDirrecion(resultado.getString("NombreDireccion"));
                    dirrecion.setTelefono(resultado.getString("Telefono"));
                    lista.add(dirrecion);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlDirrecionDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }

        return lista;
    }

    @Override
    public void addDirrecion(Dirrecion dirrecion) {
        String sql = "INSERT INTO `empresaweb`.`direcciones` ( `IdCliente`, `NombreDireccion`, `Direccion`, `CodigoPostal`, `IdPueblo`, `Telefono`) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setInt(1, dirrecion.getIdCliente());
            preparada.setString(2, dirrecion.getNombreDirrecion());
            preparada.setString(3, dirrecion.getDireccion());
            preparada.setString(4, dirrecion.getCodigoPostal());
            preparada.setInt(5, dirrecion.getIdPueblo());
            preparada.setString(6, dirrecion.getTelefono());
            preparada.executeUpdate();
        } catch (SQLException ex) {

            Logger.getLogger(MysqlUsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void updateDirrecion(Dirrecion dirrecion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeDirrecion(Dirrecion dirrecion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

}
