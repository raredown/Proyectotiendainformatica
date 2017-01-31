package es.albarregas.daofactory;

import es.albarregas.dao.ICaracteristica;
import es.albarregas.dao.ICategoria;
import es.albarregas.dao.ICliente;
import es.albarregas.dao.IDirrecion;
import es.albarregas.dao.IGeneral;
import es.albarregas.dao.IImagen;
import es.albarregas.dao.ILineaPedido;
import es.albarregas.dao.IPedido;
import es.albarregas.dao.IProducto;
import es.albarregas.dao.IProvincia;
import es.albarregas.dao.IPueblo;
import es.albarregas.dao.IUsuario;
import es.albarregas.dao.MysqlCaracteristicas;
import es.albarregas.dao.MysqlCategoriaDao;
import es.albarregas.dao.MysqlClienteDao;
import es.albarregas.dao.MysqlDirrecionDao;
import es.albarregas.dao.MysqlGeneral;
import es.albarregas.dao.MysqlImagen;
import es.albarregas.dao.MysqlLineaPedidoDao;
import es.albarregas.dao.MysqlPedidoDao;
import es.albarregas.dao.MysqlProducto;
import es.albarregas.dao.MysqlProvinciaDao;
import es.albarregas.dao.MysqlPuebloDao;
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

    @Override
    public IProvincia getProvincia() {
        return new MysqlProvinciaDao();
    }

    @Override
    public IPueblo getPueblo() {
        return new MysqlPuebloDao();
    }

    @Override
    public IDirrecion getDirrecion() {
        return new MysqlDirrecionDao();
    }

    @Override
    public IPedido getPedido() {
        return new MysqlPedidoDao();
    }

    @Override
    public IGeneral getGeneral() {
        return new MysqlGeneral();
    }

    @Override
    public ILineaPedido getLineaPedido() {
       return new MysqlLineaPedidoDao();
    }

}
