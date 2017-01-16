package es.albarregas.daofactory;

import es.albarregas.dao.ICaracteristica;
import es.albarregas.dao.ICategoria;
import es.albarregas.dao.ICliente;
import es.albarregas.dao.IImagen;
import es.albarregas.dao.IProducto;
import es.albarregas.dao.IUsuario;
import es.albarregas.dao.MysqlCaracteristicas;
import es.albarregas.dao.MysqlCategoriaDao;
import es.albarregas.dao.MysqlClienteDao;
import es.albarregas.dao.MysqlImagen;
import es.albarregas.dao.MysqlProducto;
import es.albarregas.dao.MysqlUsuarioDao;

public class MySQLDAOFactory extends DAOFactory {

    @Override
    public IUsuario getUsuarioDao() {
        return new MysqlUsuarioDao();
    }

    @Override
    public ICliente getClienteDao() {
        return new MysqlClienteDao();
    }

    @Override
    public ICaracteristica getCaracteristica() {
        return new MysqlCaracteristicas();
    }

    @Override
    public ICategoria getCattegoria() {
        return new MysqlCategoriaDao();
    }

    @Override
    public IProducto getProducto() {
        return new MysqlProducto();
    }

    @Override
    public IImagen getImagen() {
        return new MysqlImagen();
    }

}
