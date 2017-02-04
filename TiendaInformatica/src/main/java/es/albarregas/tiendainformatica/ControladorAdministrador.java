/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tiendainformatica;

import es.albarregas.beans.Usuario;
import es.albarregas.dao.IProducto;
import es.albarregas.dao.IUsuario;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rafa
 */
@WebServlet(name = "ControladorAdministrador", urlPatterns = {"/ControladorAdministrador"})
public class ControladorAdministrador extends HttpServlet {

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
        if (request.getParameter("accion") == null) {
            request.getRequestDispatcher("jsp/Accesos/panelAdministrador.jsp").forward(request, response);
        } else if (request.getParameter("accion").equals("clientes")) {
            DAOFactory daof = DAOFactory.getDAOFactory(1);
            IUsuario udao = daof.getUsuarioDao();
            ArrayList<Usuario> usuarios = udao.getUsuario("where usuarios.Tipo='u'");
            request.setAttribute("usuarios", usuarios);
            request.getRequestDispatcher("jsp/includes/paneladmin/tablacliente.jsp").forward(request, response);
        } else if (request.getParameter("accion").equals("admipro")) {
            DAOFactory daof = DAOFactory.getDAOFactory(1);
            IProducto daoproducto = daof.getProducto();
            ArrayList<es.albarregas.beans.Producto> productos = new ArrayList();
            productos = daoproducto.getProducto("");
            request.setAttribute("todoproductos", productos);
            request.getRequestDispatcher("jsp/includes/paneladmin/tablaProducto.jsp").forward(request, response);
        }else if (request.getParameter("accion").equals("reponer")) {
            DAOFactory daof = DAOFactory.getDAOFactory(1);
            IProducto daoproducto = daof.getProducto();
            ArrayList<es.albarregas.beans.Producto> productos = new ArrayList();
            productos = daoproducto.getProducto("where Stock<StockMinimo");
            request.setAttribute("todoproductos", productos);
            request.getRequestDispatcher("jsp/includes/paneladmin/tablaProducto.jsp").forward(request, response);
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
