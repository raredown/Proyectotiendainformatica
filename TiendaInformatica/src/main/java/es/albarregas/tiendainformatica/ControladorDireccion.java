/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tiendainformatica;

import es.albarregas.beans.Cliente;
import es.albarregas.beans.Dirrecion;
import es.albarregas.dao.IDirrecion;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author Daw2
 */
@WebServlet(name = "ControladorDireccion", urlPatterns = {"/ControladorDireccion"})
public class ControladorDireccion extends HttpServlet {

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

        Dirrecion dirrecion = new Dirrecion();
        DAOFactory daof = DAOFactory.getDAOFactory(1);
        HttpSession sesion = request.getSession();
        Cliente cliente = (Cliente) sesion.getAttribute("cliente");

        try {
            BeanUtils.populate(dirrecion, request.getParameterMap());
            String[] idcod = request.getParameter("idPuebloCd").split("/");
            dirrecion.setIdPueblo(Integer.parseInt(idcod[0]));
            dirrecion.setCodigoPostal(idcod[1]);
            dirrecion.setIdCliente(cliente.getIdCliente());
            String dirrecioprueba = dirrecion.getDireccion();
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ControladorDireccion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ControladorDireccion.class.getName()).log(Level.SEVERE, null, ex);
        }
        IDirrecion dirreciondao = daof.getDirrecion();
        dirreciondao.addDirrecion(dirrecion);
        ArrayList<Dirrecion> dirreciones = new ArrayList();
        if (sesion.getAttribute("dirreciones") != null) {
            dirreciones = (ArrayList<Dirrecion>) sesion.getAttribute("dirreciones");
        }
        dirreciones.add(dirrecion);
        sesion.setAttribute("dirreciones", dirreciones);
        request.setAttribute("mensaje", "Datos actualizado");
        request.getRequestDispatcher("jsp/Accesos/panelCliente.jsp").forward(request, response);
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
