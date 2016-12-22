package es.albarregas.daofactory;

import es.albarregas.dao.IUsuario;


public abstract class DAOFactory {

    public static final int MYSQL = 1;

    
    public abstract IUsuario getUsuarioDao();
    
    
    public static DAOFactory getDAOFactory(int tipo){
        DAOFactory daof = null;
        
        switch(tipo){
            case MYSQL:
                daof = new MySQLDAOFactory();
                break;
        
        }
        
        return daof;
    }
    
}
