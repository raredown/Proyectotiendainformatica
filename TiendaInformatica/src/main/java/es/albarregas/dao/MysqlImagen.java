/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Imagen;
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
public class MysqlImagen implements IImagen {

    @Override
    public ArrayList<Imagen> getImagen(String clausulaWhere) {
        ArrayList<Imagen> lista = new ArrayList();
        if (clausulaWhere == null) {
            clausulaWhere = "";
        }
        String consulta = "SELECT * FROM imagenes " + clausulaWhere;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            try (ResultSet resultado = sentencia.executeQuery(consulta)) {
                while (resultado.next()) {
                    Imagen imagen = new Imagen();
                    imagen.setIdImagen(resultado.getInt("IdImagen"));
                    imagen.setIdProducto(resultado.getInt("IdProducto"));
                    imagen.setImage(resultado.getString("Image"));
                    lista.add(imagen);

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlProducto.class.getName()).log(Level.SEVERE, null, ex);
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
