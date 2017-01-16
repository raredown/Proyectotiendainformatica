/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Producto;
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
public class MysqlProducto implements IProducto {

    @Override
    public ArrayList<Producto> getProducto(String clausulaWhere) {
        ArrayList<Producto> lista = new ArrayList();
        if (clausulaWhere == null) {
            clausulaWhere = "";
        }
        String consulta = "SELECT * FROM productos " + clausulaWhere;
        try {
            Statement sentencia = ConnectionFactory.getConnection().createStatement();
            try (ResultSet resultado = sentencia.executeQuery(consulta)) {
                while (resultado.next()) {
                    Producto producto = new Producto();
                 
                    producto.setDechaAlta(resultado.getDate("FechaAlta"));
                    producto.setDenominacion(resultado.getString("Denominacion"));
                    producto.setDescripcion(resultado.getString("Descripcion"));
                    producto.setFueraCatalogo(resultado.getString("FueraCatalogo"));
                    producto.setIdCategoria(resultado.getInt("IdCategoria"));
                    producto.setIdMarca(resultado.getInt("IdMarca"));
                    producto.setIdProducto(resultado.getInt("IdProducto"));
                    producto.setIdProvedor(resultado.getInt("IdProveedor"));
                    producto.setOferta(resultado.getString("Oferta"));
                    producto.setPrecioUnitario(resultado.getFloat("PrecioUnitario"));
                    producto.setRating(resultado.getInt("Rating"));
                    producto.setStock(resultado.getInt("Stock"));
                    producto.setStockMinimo(resultado.getInt("StockMinimo"));
                    
                    lista.add(producto);
                 
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
