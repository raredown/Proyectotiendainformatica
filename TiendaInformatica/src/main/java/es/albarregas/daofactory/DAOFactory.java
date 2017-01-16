package es.albarregas.daofactory;

import es.albarregas.dao.ICaracteristica;
import es.albarregas.dao.ICategoria;
import es.albarregas.dao.ICliente;
import es.albarregas.dao.IImagen;
import es.albarregas.dao.IProducto;
import es.albarregas.dao.IUsuario;

public abstract class DAOFactory {

    public static final int MYSQL = 1;

    public abstract IUsuario getUsuarioDao();

    public abstract ICliente getClienteDao();

    public abstract ICaracteristica getCaracteristica();

    public abstract ICategoria getCattegoria();

    public abstract IProducto getProducto();

    public abstract IImagen getImagen();

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
