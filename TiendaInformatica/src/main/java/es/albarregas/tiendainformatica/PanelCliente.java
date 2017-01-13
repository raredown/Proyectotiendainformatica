/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tiendainformatica;

import com.google.gson.Gson;
import es.albarregas.beans.Cliente;
import es.albarregas.beans.Usuario;
import es.albarregas.dao.ICliente;
import es.albarregas.dao.IUsuario;
import es.albarregas.daofactory.DAOFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
@WebServlet(name = "PanelCliente", urlPatterns = {"/PanelCliente"})
public class PanelCliente extends HttpServlet {

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
            if (request.getParameter("paneles").equals("datosclientes")) {

                HttpSession sesion = request.getSession();
                Usuario usuario = (Usuario) sesion.getAttribute("usuario");
                Cliente sesioncliente = (Cliente) sesion.getAttribute("cliente");
                DAOFactory daof = DAOFactory.getDAOFactory(1);
                ICliente iaof = daof.getClienteDao();

                Cliente cliente = new Cliente();
                cliente.setNombre(request.getParameter("nombre"));
                cliente.setIdCliente(usuario.getIdUsuario());
                cliente.setApellidos(request.getParameter("apellidos"));
                cliente.setEmail(request.getParameter("email"));
                cliente.setNif(request.getParameter("nif"));
                cliente.setFechaAlta(sesioncliente.getFechaAlta());
                // Date edad = Date.valueOf(request.getParameter("fecha"));
                //Hago una plantilla para pasar una fecha de string a date
                String stringFecha = request.getParameter("fecha");
                //Uso este formato porque es como me llega del input
                //System.out.println(stringFecha);
                DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date convertido = null;
                // java.sql.Date fecha2=java.sql.Date.valueOf(stringFecha);
                try {
                    convertido = fecha.parse(stringFecha);
                    System.out.println(fecha.parse(stringFecha));
                } catch (ParseException ex) {
                    Logger.getLogger(ConCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                cliente.setFechaNacimiento(new java.sql.Date(convertido.getTime()));
                iaof.updateCliente(cliente);
                sesion.setAttribute("cliente", cliente);
                request.setAttribute("mensaje", "Datos actualizado");
                request.getRequestDispatcher("jsp/Accesos/panelCliente.jsp").forward(request, response);

            } else if (request.getParameter("paneles").equals("datosusuario")) {
                HttpSession sesion = request.getSession();
                Usuario usuario = (Usuario) sesion.getAttribute("usuario");
                DAOFactory daof = DAOFactory.getDAOFactory(1);
                IUsuario daousa = daof.getUsuarioDao();
                usuario.setClave(request.getParameter("pass1"));
                daousa.updateUsuario(usuario);
                sesion.setAttribute("usuario", usuario);
                request.setAttribute("mensaje", "Datos actualizado");
                request.getRequestDispatcher("jsp/Accesos/panelCliente.jsp").forward(request, response);
            }
        } else {
            HttpSession sesion = request.getSession();
            Usuario usuario = (Usuario) sesion.getAttribute("usuario");
            Gson gson = new Gson();
            String representacionJSON = gson.toJson(usuario);
            // System.out.print(representacionJSON);

            //response.setCharacterEncoding("UTF-8");
            response.getWriter().write(representacionJSON);
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
