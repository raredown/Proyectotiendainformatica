/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Categoria;
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
public class MysqlCategoriaDao implements ICategoria {

    @Override
    public ArrayList<Categoria> getCategoria(String clausulaWhere) {
        ArrayList<Categoria> lista = new ArrayList();
        if (clausulaWhere == null) {
            clausulaWhere = "";
        }
        String consulta = "SELECT * FROM categorias " + clausulaWhere;

        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            try (ResultSet resultado = sentencia.executeQuery(consulta)) {
                while (resultado.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setIdCategoria(resultado.getInt("idCategoria"));
                    categoria.setNombre(resultado.getString("Nombre"));
                    lista.add(categoria);
                }
            } catch (SQLException ex) {
                Logger.getLogger(MysqlCategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MysqlCategoriaDao.class.getName()).log(Level.SEVERE, null, ex);
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
