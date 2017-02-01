/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tiendainformatica;

import es.albarregas.beans.LineaPedido;
import es.albarregas.beans.Pedido;
import es.albarregas.dao.ILineaPedido;
import es.albarregas.dao.IPedido;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "PanelCarrito", urlPatterns = {"/PanelCarrito"})
public class PanelCarrito extends HttpServlet {

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
        ArrayList<LineaPedido> lineaspedidos = (ArrayList<LineaPedido>) sesion.getAttribute("lineaspedidos");
        if (request.getParameter("idLinea") == null) {
            request.getRequestDispatcher("jsp/carrito/principalcarrito.jsp").forward(request, response);
        } else if (request.getParameter("accion") != null) {
//          
            //para sumar cantidar o para restar
            DAOFactory daof = DAOFactory.getDAOFactory(1);
            ILineaPedido dailineapedida = daof.getLineaPedido();

            if (request.getParameter("accion").equals("add")) {

                for (LineaPedido elemento : lineaspedidos) {
                    if (request.getParameter("idLinea").equals(Integer.toString(elemento.getNumeroLinea()))) {
                        if (elemento.getProducto().getStock() - (elemento.getCantidad() + 1) >= 0) {
                            elemento.setCantidad(elemento.getCantidad() + 1);
                            dailineapedida.updateLineaPedido(elemento);
                            String pruebas = Integer.toString(elemento.getCantidad());
                            response.getWriter().write(pruebas);
                        } else {
                            response.getWriter().write("0");
                        }
                    }

                }

            } else if (request.getParameter("accion").equals("menos")) {
                LineaPedido lineaborrada = null;
                for (LineaPedido elemento : lineaspedidos) {

                    if (request.getParameter("idLinea").equals(Integer.toString(elemento.getNumeroLinea()))) {
                        if ((elemento.getCantidad() - 1) >= 1) {
                            elemento.setCantidad(elemento.getCantidad() - 1);
                            dailineapedida.updateLineaPedido(elemento);
                            String pruebas = Integer.toString(elemento.getCantidad());
                            response.getWriter().write(pruebas);
                        } else {
                            dailineapedida.deleteLineaPedido(elemento);
                            // lineaspedidos.remove(elemento);
                            lineaborrada = elemento;
                            String pruebas = "0";
                            response.getWriter().write(pruebas);

                        }
                    }
                }
                if (lineaborrada != null) {
                    lineaspedidos.remove(lineaborrada);
                }

            } else if (request.getParameter("accion").equals("delete")) {
                LineaPedido lineaborrada = new LineaPedido();
                for (LineaPedido elemento : lineaspedidos) {
                    if (request.getParameter("idLinea").equals(Integer.toString(elemento.getNumeroLinea()))) {
                        dailineapedida.deleteLineaPedido(elemento);
                        lineaborrada = elemento;
                        //lineaspedidos.remove(elemento);
                        String pruebas = "0";
                        response.getWriter().write(pruebas);

                    }
                }
                lineaspedidos.remove(lineaborrada);
            }
        }
        if (lineaspedidos.isEmpty()) {
            DAOFactory daof = DAOFactory.getDAOFactory(1);
             IPedido daopedido = daof.getPedido();
             daopedido.deletePedido((Pedido) sesion.getAttribute("carrito"));
            sesion.removeAttribute("lineaspedidos");
            sesion.removeAttribute("carrito");
        } else {
            sesion.setAttribute("lineaspedidos", lineaspedidos);
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

        if (sesion.getAttribute("carrito") != null) {
            DAOFactory daof = DAOFactory.getDAOFactory(1);
            IPedido daopedido = daof.getPedido();
            ArrayList<LineaPedido> lineaspedidos = (ArrayList<LineaPedido>) sesion.getAttribute("lineaspedidos");
            Pedido carrito = (Pedido) sesion.getAttribute("carrito");
            float baseimponible = 0;
            for (LineaPedido elemento : lineaspedidos) {
                baseimponible = baseimponible + (elemento.getCantidad() * elemento.getPrecioUnitario());
            }
            carrito.setBaseImponible(baseimponible);
            daopedido.updatePedido(carrito);
            sesion.setAttribute("carrito", carrito);
            response.getWriter().write(Float.toString(baseimponible));
        }

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
