/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public class MysqlUsuarioDao implements IUsuario {

    @Override
    public ArrayList<Usuario> getUsuario(String clausulaWhere) {
        ArrayList<Usuario> lista = new ArrayList();
        if (clausulaWhere == null) {
            clausulaWhere = "";
        }
        String consulta = "SELECT * FROM usuarios " + clausulaWhere;
         try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            try (ResultSet resultado = sentencia.executeQuery(consulta)) {
                while (resultado.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setIdUsuario(resultado.getInt("IdUsuario"));
                    usuario.setUsername(resultado.getString("UserName"));
                    usuario.setClave(resultado.getString("Clave"));
                    usuario.setUltimoAcesso(resultado.getDate("UltimoAcceso"));
                    usuario.setTipo(resultado.getString("Tipo"));
                    usuario.setBloqueado(resultado.getString("Bloqueado"));
                  
                    lista.add(usuario);
                }
            }

        } catch (SQLException ex) {
            System.out.println("Error al ejecutar la sentencia");
            ex.printStackTrace();
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
