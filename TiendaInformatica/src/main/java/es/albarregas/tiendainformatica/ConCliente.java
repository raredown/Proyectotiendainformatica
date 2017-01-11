/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tiendainformatica;

import es.albarregas.beans.Cliente;
import es.albarregas.beans.Usuario;
import es.albarregas.dao.ICliente;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.modelos.Formularios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "ConCliente", urlPatterns = {"/ConCliente"})
public class ConCliente extends HttpServlet {

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
        if (sesion.getAttribute("cliente") == null) {

            Usuario usuario = (Usuario) sesion.getAttribute("usuario");
            DAOFactory daof = DAOFactory.getDAOFactory(1);
            ICliente cdao = daof.getClienteDao();
            ArrayList<Cliente> clientes = new ArrayList();
            String where = "where IdCliente = '" + usuario.getIdUsuario() + "'";
            clientes = cdao.getCliente(where);
            //Si clientes esta vacio es que no tiene nigun cliente asociado a un usuario
            if (clientes.isEmpty()) {
                request.getRequestDispatcher("jsp/Accesos/formCliente.jsp").forward(request, response);
            } else {
                for (Cliente elemento : clientes) {
                    sesion.setAttribute("cliente", elemento);
                }
            }
            request.getRequestDispatcher("jsp/Accesos/panelCliente.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("jsp/Accesos/panelCliente.jsp").forward(request, response);
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
        //Validamos todos los cmapos de formulario
        // if (Formularios.dni(request.getParameter("nif")) && Formularios.nombres(request.getParameter("nombre"), 24) && Formularios.nombres(request.getParameter("apellidos"), 39) && Formularios.email(request.getParameter("email"))) {
        //Cogemos el la sesion de usuario para meter el id cliente ya que es el mismo 
        HttpSession sesion = request.getSession();
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        DAOFactory daof = DAOFactory.getDAOFactory(1);
        ICliente iaof = daof.getClienteDao();

        Cliente cliente = new Cliente();
        cliente.setNombre(request.getParameter("nombre"));
        cliente.setIdCliente(usuario.getIdUsuario());
        cliente.setApellidos(request.getParameter("apellidos"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setNif(request.getParameter("nif"));

        // Date edad = Date.valueOf(request.getParameter("fecha"));
        //Hago una plantilla para pasar una fecha de string a date
        String stringFecha = request.getParameter("fecha");
        //Uso este formato porque es como me llega los datos del input datespiker
        DateFormat fecha = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date convertido = null;
        // java.sql.Date fecha2=java.sql.Date.valueOf(stringFecha);
        try {
            convertido = fecha.parse(stringFecha);
            System.out.println(fecha.parse(stringFecha));
        } catch (ParseException ex) {
            Logger.getLogger(ConCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        cliente.setFechaNacimiento(new java.sql.Date(convertido.getTime()));

        java.util.Date d = new java.util.Date();
        //Dplantilla como la base de datos 
        SimpleDateFormat plantilla = new SimpleDateFormat("dd/MM/yyyy H:mm");
        String tiempo = plantilla.format(d);
        java.sql.Date date2 = new java.sql.Date(d.getTime());
        //Date alta = Date.valueOf(LocalDate.MAX);
        cliente.setFechaAlta(date2);
        iaof.addCliente(cliente);
        //  }
        request.getRequestDispatcher("index.jsp").forward(request, response);

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
