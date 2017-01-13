/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Cliente;
import es.albarregas.beans.Usuario;
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
public class MysqlClienteDao implements ICliente {

    @Override
    public ArrayList<Cliente> getCliente(String clausulaWhere) {
        ArrayList<Cliente> lista = new ArrayList();
        if (clausulaWhere == null) {
            clausulaWhere = "";
        }
        String consulta = "SELECT * FROM clientes " + clausulaWhere;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            try (ResultSet resultado = sentencia.executeQuery(consulta)) {
                while (resultado.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(resultado.getInt("IdCliente"));
                    cliente.setNombre(resultado.getString("Nombre"));
                    cliente.setApellidos(resultado.getString("Apellidos"));
                    cliente.setEmail(resultado.getString("Email"));
                    cliente.setNif(resultado.getString("NIF"));
                    cliente.setFechaAlta(resultado.getDate("FechaAlta"));
                    cliente.setFechaNacimiento(resultado.getDate("FechaNacimiento"));
                    lista.add(cliente);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MysqlClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }

        return lista;
    }

    @Override
    public void addCliente(Cliente cliente) {
        try {
            String sql = "INSERT INTO `empresaweb`.`clientes` (`IdCliente`, `Nombre`, `Apellidos`, `Email`, `NIF`,`FechaNacimiento`,`FechaAlta`) VALUES (?, ?, ?, ?, ?,?,?)";
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            preparada.setInt(1, cliente.getIdCliente());
            preparada.setString(2, cliente.getNombre());
            preparada.setString(3, cliente.getApellidos());
            preparada.setString(4, cliente.getEmail());
            preparada.setString(5, cliente.getNif());
            preparada.setDate(6, cliente.getFechaNacimiento());
            preparada.setDate(7, cliente.getFechaAlta());
            preparada.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MysqlClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void closeConnection() {
        ConnectionFactory.closeConnection();
    }

    @Override
    public void updateCliente(Cliente cliente) {
        String sql = "update equipos set marca=?,numSerie=? where idEquipo=?";
        sql="UPDATE `empresaweb`.`clientes` SET `Nombre`=?, `Apellidos`=?, `Email`=?, `NIF`=?, `FechaNacimiento`=? WHERE  `IdCliente`=?;";
        try {
            PreparedStatement preparada = ConnectionFactory.getConnection().prepareStatement(sql);
            
            preparada.setString(1, cliente.getNombre());
            preparada.setString(2, cliente.getApellidos());
            preparada.setString(3, cliente.getEmail());
            preparada.setString(4, cliente.getNif());
            preparada.setDate(5, cliente.getFechaNacimiento());
            preparada.setInt(6, cliente.getIdCliente());
            preparada.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MysqlClienteDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            this.closeConnection();
        }
    }

}
