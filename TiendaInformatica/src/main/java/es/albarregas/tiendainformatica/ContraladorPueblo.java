/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tiendainformatica;

import es.albarregas.beans.Pueblo;
import es.albarregas.dao.IPueblo;
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
 * @author Daw2
 */
@WebServlet(name = "ContraladorPueblo", urlPatterns = {"/ContraladorPueblo"})
public class ContraladorPueblo extends HttpServlet {

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
        if (request.getParameter("idProvincia") != null) {
            int idprovincia = Integer.parseInt(request.getParameter("idProvincia"));
            DAOFactory daof = DAOFactory.getDAOFactory(1);
            IPueblo puedao = daof.getPueblo();
            ArrayList<Pueblo> pueblos = new ArrayList();
            pueblos = puedao.getPueblo("where IdProvincia=" + request.getParameter("idProvincia") + " ORDER BY Nombre");
            request.setAttribute("pueblos", pueblos);
            //request.getRequestDispatcher("mal.jsp").forward(request, response);
            request.getRequestDispatcher("jsp/direccion/selectPoblacion.jsp").forward(request, response);

        } else if (request.getParameter("codigoPostal") != null) {

            DAOFactory daof = DAOFactory.getDAOFactory(1);
            IPueblo puedao = daof.getPueblo();
            String prueba = request.getParameter("codigoPostal");
            ArrayList<Pueblo> pueblos = new ArrayList();
            pueblos = puedao.getPuebloCodigoPostal("where Nombre ='" + request.getParameter("codigoPostal") + "' and IdProvincia= " + request.getParameter("idpro"));
            request.setAttribute("pueblos", pueblos);
     //       request.getRequestDispatcher("mal.jsp").forward(request, response);
          request.getRequestDispatcher("jsp/direccion/selectCodigoPostalYdatos.jsp").forward(request, response);

        }
      //  request.getRequestDispatcher("mal.jsp").forward(request, response);
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
