/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tiendainformatica;

import es.albarregas.beans.Cliente;
import es.albarregas.beans.Factura;
import es.albarregas.beans.LineaPedido;
import es.albarregas.beans.MostraFactura;
import es.albarregas.beans.Pedido;
import es.albarregas.dao.IFactura;
import es.albarregas.dao.IInnerJoin;
import es.albarregas.dao.IPedido;
import es.albarregas.dao.IProducto;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rafa
 */
@WebServlet(name = "ConclusionCarrito", urlPatterns = {"/ConclusionCarrito"})
public class ConclusionCarrito extends HttpServlet {

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
        if (sesion.getAttribute("carrito") == null) {
            request.setAttribute("inputmensaje", 1);
            request.setAttribute("mensajeCarrito", " No tiene nada en el carrito.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (sesion.getAttribute("usuario") == null) {
            request.setAttribute("inputmensaje", 1);
            request.setAttribute("mensajeCarrito", "Registrate ó logeate para comprar.");

            request.getRequestDispatcher("jsp/Accesos/login.jsp").forward(request, response);
        } else if (sesion.getAttribute("cliente") == null) {
            request.setAttribute("inputmensaje", 1);
            request.setAttribute("mensajeCarrito", " Completa tus datos.");
            request.getRequestDispatcher("ConCliente").forward(request, response);
        } else if (sesion.getAttribute("dirreciones") == null) {
            request.setAttribute("inputmensaje", 1);
            request.setAttribute("mensajeCarrito", " No tenemos ninguna dirrecion tuya.");
            request.getRequestDispatcher("ConCliente").forward(request, response);

        } else {
            request.setAttribute("inputmensaje", 0);
            request.getRequestDispatcher("jsp/carrito/conclusioncarrito.jsp").forward(request, response);
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
        HttpSession sesion = request.getSession();
        DAOFactory daof = DAOFactory.getDAOFactory(1);
        IProducto daoproducto = daof.getProducto();
        if (request.getParameter("dirreccionescojida") != null) {
            String tipopedido = "r";
            Pedido carrito = (Pedido) sesion.getAttribute("carrito");
            ArrayList<LineaPedido> lineaspedidos = (ArrayList<LineaPedido>) sesion.getAttribute("lineaspedidos");
            carrito.setIdDireccion(Integer.parseInt(request.getParameter("dirreccionescojida")));
            ServletContext ctx = getServletContext();
            ArrayList<es.albarregas.beans.Producto> productos = (ArrayList<es.albarregas.beans.Producto>) ctx.getAttribute("productos");
            for (LineaPedido linea : lineaspedidos) {

                for (es.albarregas.beans.Producto elemento : productos) {
                    if (elemento.getIdProducto() == linea.getIdProducto()) {
                        elemento.setStock(elemento.getStock() - linea.getCantidad());
                        if (elemento.getStock() < 0) {
                            tipopedido = "p";
                        }
                        daoproducto.updateProducto(elemento);
                    }

                }
            }
            carrito.setEstado(tipopedido);
            IPedido daopedido = daof.getPedido();
            daopedido.updatePedido(carrito);
            //Mostrar factura
            IInnerJoin daoiinerjoin = daof.getInnerJoin();
            MostraFactura mostrarFactura = new MostraFactura();
            mostrarFactura = daoiinerjoin.nombrePuebloProvinciaCodigoPostal(Integer.toString(carrito.getIdDireccion()));
            mostrarFactura.setLineaspedidos(lineaspedidos);
            mostrarFactura.setPedido(carrito);
            Cliente cliente = (Cliente) sesion.getAttribute("cliente");
            mostrarFactura.setNombreCliente(cliente.getNombre());
            mostrarFactura.setEmail(cliente.getEmail());
            IFactura daofactura = daof.getFactura();
            Factura factura = new  Factura();
            factura.setIdPedido(carrito.getIdPedido());
            daofactura.addFactura(factura);
            factura = daofactura.getoneFactura(Integer.toString(carrito.getIdPedido()));
            mostrarFactura.setNumeroFactura(factura.getNumeroDeFactura());
            //^^^^^^^^^^^^^^^^^^^^^^^^
            sesion.removeAttribute("carrito");
            sesion.removeAttribute("lineaspedidos");
            request.setAttribute("verFactura", mostrarFactura);
            request.getRequestDispatcher("jsp/carrito/factura.jsp").forward(request, response);
        }
        //request.getParameter("dirreccionescojida");
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
