/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.event;

import es.albarregas.beans.Categoria;
import es.albarregas.beans.Producto;
import es.albarregas.dao.ICategoria;
import es.albarregas.dao.IImagen;
import es.albarregas.dao.IProducto;
import es.albarregas.daofactory.DAOFactory;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Daw2
 */
@WebListener
public class EventoInicial implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext contexto = sce.getServletContext();
        DAOFactory daof = DAOFactory.getDAOFactory(1);

        ArrayList<Categoria> categorias = new ArrayList();
        ArrayList<Producto> productos = new ArrayList();
        ArrayList<Producto> productosImagenes = new ArrayList();
        ICategoria daocategoria = daof.getCattegoria();
        IProducto daoproducto = daof.getProducto();

        IImagen daoimagen = daof.getImagen();
        categorias = daocategoria.getCategoria("");
        productos = daoproducto.getProducto("");
        Iterator<Producto> it = productos.iterator();

        while (it.hasNext()) {
            Producto productito =it.next();
           // productosImagenes.add(it.next().setListaImagenes(daoimagen.getImagen("where imagenes.IdProducto = ")));
           productito.setListaImagenes(daoimagen.getImagen("where imagenes.IdProducto = " + productito.getIdProducto()));
           productosImagenes.add(productito);

        }
        // contexto.setAttribute("prueba", "pruebas");
        contexto.setAttribute("productos", productosImagenes);
        contexto.setAttribute("categoria", categorias);

        System.out.print("aplicacion web arrancada");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
