package es.albarregas.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

public class ConnectionFactory {

    static DataSource ds = null;
    static Connection conexion = null;
    static final String DATASOURCE_NAME = "java:comp/env/jdbc/empresa";
    final static Logger LOGGER = Logger.getRootLogger();
        
    public static Connection getConnection(){
        try {
            Context contextoInicial = new InitialContext();
            ds = (DataSource) contextoInicial.lookup(DATASOURCE_NAME);
            conexion = ds.getConnection();
        } catch (NamingException | SQLException ex) {
            LOGGER.fatal("Problemas en el acceso al pool de conexiones", ex);
        }
        return conexion;
    }
    
    public static void closeConnection(){
        try {
            conexion.close();
        } catch(SQLException e){
            System.out.println("Error al cerrar la conexión a la BD");
            e.printStackTrace();
        }
    }
    
}
