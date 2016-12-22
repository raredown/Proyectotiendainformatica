package es.albarregas.daofactory;

import es.albarregas.dao.IUsuario;
import es.albarregas.dao.MysqlUsuarioDao;




public class MySQLDAOFactory extends DAOFactory{

    @Override
    public IUsuario getUsuarioDao() {
        return new MysqlUsuarioDao();
    }

 
    
    
}
