package es.albarregas.daofactory;

import es.albarregas.dao.ICaracteristica;
import es.albarregas.dao.ICategoria;
import es.albarregas.dao.ICliente;
import es.albarregas.dao.IDirrecion;
import es.albarregas.dao.IFactura;
import es.albarregas.dao.IGeneral;
import es.albarregas.dao.IImagen;
import es.albarregas.dao.IInnerJoin;
import es.albarregas.dao.ILineaPedido;
import es.albarregas.dao.IPedido;
import es.albarregas.dao.IProducto;
import es.albarregas.dao.IProvincia;
import es.albarregas.dao.IPueblo;
import es.albarregas.dao.IUsuario;

public abstract class DAOFactory {

    public static final int MYSQL = 1;

    public abstract IUsuario getUsuarioDao();

    public abstract ICliente getClienteDao();

    public abstract ICaracteristica getCaracteristica();

    public abstract ICategoria getCattegoria();

    public abstract IProducto getProducto();

    public abstract IImagen getImagen();
    
    public abstract IProvincia getProvincia();
    
    public abstract IPueblo getPueblo();
    
    public abstract IDirrecion getDirrecion();
    
    public abstract IPedido getPedido();
    
    public abstract IGeneral getGeneral();
    
    public abstract ILineaPedido getLineaPedido();
    
    public abstract  IInnerJoin getInnerJoin();
    
    public abstract IFactura getFactura();

    public static DAOFactory getDAOFactory(int tipo) {
        DAOFactory daof = null;

        switch (tipo) {
            case MYSQL:
                daof = new MySQLDAOFactory();
                break;

        }

        return daof;
    }

}
