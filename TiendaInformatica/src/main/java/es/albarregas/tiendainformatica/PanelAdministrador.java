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
@WebServlet(name = "PanelAdministrador", urlPatterns = {"/PanelAdministrador"})
public class PanelAdministrador extends HttpServlet {

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
        if (request.getParameter("paneles") != null) {
            if (request.getParameter("paneles").equals("datosusuario")) {
                HttpSession sesion = request.getSession();
                Usuario usuario = (Usuario) sesion.getAttribute("usuario");
                DAOFactory daof = DAOFactory.getDAOFactory(1);
                IUsuario daousa = daof.getUsuarioDao();
                usuario.setClave(request.getParameter("pass1"));
                daousa.updateUsuario(usuario);
                sesion.setAttribute("usuario", usuario);
                request.setAttribute("mensaje", "Datos actualizado");
                request.getRequestDispatcher("jsp/Accesos/panelAdministrador.jsp").forward(request, response);
            }
        } else if (request.getParameter("bloquear") != null) {
            DAOFactory daof = DAOFactory.getDAOFactory(1);
            IUsuario udao = daof.getUsuarioDao();
            Usuario usuario = new Usuario();
            usuario.setBloqueado(request.getParameter("selecionado"));
            usuario.setIdUsuario(Integer.parseInt(request.getParameter("bloquear")));
            udao.actualizarUsuarioBloquead(usuario);

        } else if (request.getParameter("id") != null) {
            DAOFactory daof = DAOFactory.getDAOFactory(1);
            IProducto daoproducto = daof.getProducto();
            es.albarregas.beans.Producto producto = new es.albarregas.beans.Producto();
            producto.setIdProducto(Integer.parseInt(request.getParameter("id")));
            producto.setStock(Integer.parseInt(request.getParameter("stock")));
            daoproducto.actualizarProductoStock(producto);

        }   else if (request.getParameter("bloquearproducto") != null) {
            DAOFactory daof = DAOFactory.getDAOFactory(1);
            IProducto daoproducto = daof.getProducto();
            es.albarregas.beans.Producto producto = new es.albarregas.beans.Producto();
            producto.setIdProducto(Integer.parseInt(request.getParameter("bloquearproducto")));
            producto.setFueraCatalogo(request.getParameter("selecionado"));
            daoproducto.actualizarProductoBloqueado(producto);

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
