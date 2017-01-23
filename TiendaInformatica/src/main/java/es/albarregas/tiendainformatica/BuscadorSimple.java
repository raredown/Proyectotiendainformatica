/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tiendainformatica;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafa
 */
@WebServlet(name = "BuscadorSimple", urlPatterns = {"/BuscadorSimple"})
public class BuscadorSimple extends HttpServlet {

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
      
        if (request.getParameter("buscador") != null) {
            String cadenaBuscada = request.getParameter("buscador");
            ServletContext ctx = getServletContext();
            ArrayList<es.albarregas.beans.Producto> productos = (ArrayList<es.albarregas.beans.Producto>) ctx.getAttribute("productos");
            Iterator<es.albarregas.beans.Producto> it = productos.iterator();

            ArrayList<es.albarregas.beans.Producto> productosBuscado = new ArrayList();

            while (it.hasNext()) {
                es.albarregas.beans.Producto productito = it.next();
                // productito.getDenominacion().indexOf(cadenaBuscada);
                // Comparo si tiene el substring del buscador
                if (productito.getDenominacion().toLowerCase().contains(cadenaBuscada.toLowerCase())) {

                    productosBuscado.add(productito);

                }
            }
            int tamano = productosBuscado.size();
            int numeroPagina = tamano / 5;
            if (tamano % 5 != 0) {
                numeroPagina = numeroPagina + 1;
            }
            request.setAttribute("numeroPagina", numeroPagina);
            request.setAttribute("productosBuscado", productosBuscado);
            request.setAttribute("cadenaBuscada", cadenaBuscada);
            request.getRequestDispatcher("jsp/productos/buscadorsimple.jsp").forward(request, response);
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
