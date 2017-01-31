/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tiendainformatica;

import es.albarregas.beans.Cliente;
import es.albarregas.beans.General;
import es.albarregas.beans.LineaPedido;
import es.albarregas.beans.Pedido;
import es.albarregas.dao.IGeneral;
import es.albarregas.dao.ILineaPedido;
import es.albarregas.dao.IPedido;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Daw2
 */
@WebServlet(name = "ControladorCarrito", urlPatterns = {"/ControladorCarrito"})
public class ControladorCarrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        //si no ahi nada en el carrito tengo que hacer esto 
        if (sesion.getAttribute("carrito") == null) {

            DAOFactory daof = DAOFactory.getDAOFactory(1);
            IPedido daopedido = daof.getPedido();
            IGeneral daogeneral = daof.getGeneral();

            Pedido carritoPedido = new Pedido();
            //N es carrito
            carritoPedido.setEstado("n");
            Date fecha = new Date();
            SimpleDateFormat plantilla = new SimpleDateFormat("dd/MM/yyyy H:mm");
            String tiempo = plantilla.format(fecha);
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            carritoPedido.setFecha(fechaSQL);
            if (sesion.getAttribute("cliente") != null) {
                Cliente cliente = (Cliente) sesion.getAttribute("cliente");
                carritoPedido.setIdCliente(cliente.getIdCliente());
            }
            General general;
            general = daogeneral.getGeneral();
            carritoPedido.setIva(general.getIva());
            carritoPedido.setGastoEnvio(general.getGastoEnvios());

            daopedido.addPedido(carritoPedido);

            //Añadimos la primera linea de pedido
            LineaPedido lineapedido = new LineaPedido();
            lineapedido.setIdPedido(carritoPedido.getIdPedido());

            ServletContext ctx = getServletContext();
            ArrayList<es.albarregas.beans.Producto> productos = (ArrayList<es.albarregas.beans.Producto>) ctx.getAttribute("productos");
            Iterator<es.albarregas.beans.Producto> it = productos.iterator();

            int idProducInt = Integer.parseInt(request.getParameter("idProducto"));

            while (it.hasNext()) {
                es.albarregas.beans.Producto productito = it.next();

                if (idProducInt == productito.getIdProducto()) {
                    lineapedido.setCantidad(1);
                    lineapedido.setIdProducto(idProducInt);
                    lineapedido.setPrecioUnitario(productito.getPrecioUnitario());
                }
            }

            //Select * from pedidos order by IdPedido DESC LIMIT 1 el ultimo registro q lo acabo de meter
            ArrayList<Pedido> carritoconid = daopedido.getPedido("order by IdPedido DESC LIMIT 1");
            for (Pedido elemento : carritoconid) {
                carritoPedido = elemento;
            }
            //Es la primera linea del pedido
            lineapedido.setNumeroLinea(1);
            lineapedido.setIdPedido(carritoPedido.getIdPedido());
            ILineaPedido dailineapedida = daof.getLineaPedido();
            dailineapedida.addLineaPedido(lineapedido);
            ArrayList<LineaPedido> lineaspedidos = new ArrayList();
            lineaspedidos.add(lineapedido);
            // carritoPedido.setBaseImponible(lineapedido.getPrecioUnitario());
            sesion.setAttribute("lineaspedidos", lineaspedidos);
            sesion.setAttribute("carrito", carritoPedido);
            //Para mostrar un mensaje al usuario
            response.getWriter().write("ok");
        } else if (sesion.getAttribute("lineaspedidos") != null) {
            int idProducInt = Integer.parseInt(request.getParameter("idProducto"));
            ArrayList<LineaPedido> lineaspedidos = (ArrayList<LineaPedido>) sesion.getAttribute("lineaspedidos");
            LineaPedido lineapedido = new LineaPedido();
            DAOFactory daof = DAOFactory.getDAOFactory(1);
            for (LineaPedido elemento : lineaspedidos) {
                if (idProducInt == elemento.getIdProducto()) {
                    lineapedido = elemento;
                    lineapedido.setCantidad(lineapedido.getCantidad() + 1);
                    elemento.setCantidad(elemento.getCantidad() + 1);
                }

            }
            //para comprobar si tenemos el producto ya en una linea de pedido
            if (lineapedido.getIdProducto() == 0) {
                ServletContext ctx = getServletContext();
                ArrayList<es.albarregas.beans.Producto> productos = (ArrayList<es.albarregas.beans.Producto>) ctx.getAttribute("productos");
                Iterator<es.albarregas.beans.Producto> it = productos.iterator();

                Pedido carritoPedido = (Pedido) sesion.getAttribute("carrito");
                lineapedido.setIdPedido(carritoPedido.getIdPedido());
                while (it.hasNext()) {
                    es.albarregas.beans.Producto productito = it.next();

                    if (idProducInt == productito.getIdProducto()) {
                        lineapedido.setCantidad(1);
                        lineapedido.setIdProducto(idProducInt);
                        lineapedido.setPrecioUnitario(productito.getPrecioUnitario());
                    }
                }
                lineapedido.setNumeroLinea(lineaspedidos.size() + 1);

                ILineaPedido dailineapedida = daof.getLineaPedido();
                dailineapedida.addLineaPedido(lineapedido);
                lineaspedidos.add(lineapedido);
            } else {
                ILineaPedido dailineapedida = daof.getLineaPedido();
                dailineapedida.updateLineaPedido(lineapedido);

            }

            // carritoPedido.setBaseImponible(lineapedido.getPrecioUnitario());
            sesion.setAttribute("lineaspedidos", lineaspedidos);
            response.getWriter().write("ok");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
