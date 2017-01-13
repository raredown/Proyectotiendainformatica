/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

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

    @Override
    public void addUsuario(Usuario usuario) {
        String sql = "INSERT INTO `empresaweb`.`usuarios` (`UserName`, `Clave`) VALUES (?,?);";
        try {
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1, usuario.getUsername());
            preparada.setString(2, usuario.getClave());
            preparada.executeUpdate();
        } catch (SQLException ex) {
            
            Logger.getLogger(MysqlUsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        try {
            String sql ="UPDATE `empresaweb`.`usuarios` SET `Clave`=? WHERE  `IdUsuario`=?;";
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setString(1,usuario.getClave());
            preparada.setInt(2, usuario.getIdUsuario());
            preparada.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlUsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }
    }

}
