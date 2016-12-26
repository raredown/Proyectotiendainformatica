/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tiendainformatica;

import es.albarregas.beans.Usuario;
import es.albarregas.dao.IUsuario;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.modelos.Formularios;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

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
        DAOFactory daof = DAOFactory.getDAOFactory(1);
        IUsuario udao = daof.getUsuarioDao();
        ArrayList<Usuario> usuarios;

        //Pregunto si viene de para entrar o para registrar un usuario
        //String pruebas = request.getParameter("oculto");
        if (request.getParameter("oculto") != null) {

            if (request.getParameter("oculto").equals("entrar")) {
                //Formamos la clasula where para que me compruebe que haya un usuario y una clave con los datos introducido en el form
                String where = "where 'nada'";
                //Validamos los campos en el servidor
                if (Formularios.letrasYNumeros(request.getParameter("usuario")) && !request.getParameter("pass").equals("")) {
                    // where  = "where UserName = 'prueba' and Clave = '123'";
                    where = "where UserName = '" + request.getParameter("usuario") + "' and Clave = '" + request.getParameter("pass") + "'";
                }
                usuarios = udao.getUsuario(where);
                //Si está vacía volveremos a la pagina de login con un  mensaje de error si no entraremos en el panelde usuario
                if (usuarios.isEmpty()) {
                    request.setAttribute("error", "Contraseña ó usuario incorrecto");
                    request.getRequestDispatcher("jsp/Accesos/login.jsp").forward(request, response);
                } else {
                    HttpSession sesion = request.getSession();
                    //Uso un for pero solo cojo uno es imposible que haya varios usuarios despues de la clausula where de antes
                    for (Usuario elemento : usuarios) {
                        sesion.setAttribute("usuario", elemento);
                    }
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                //request.getRequestDispatcher("index_1.html").forward(request, response);
                /*
                ** Esto es para el registro
                **
                 */

            } else if (request.getParameter("oculto").equals("registro")) {
                if (Formularios.passwordIguales(request.getParameter("password"), request.getParameter("password2")) && Formularios.letrasYNumeros(request.getParameter("usuario"))) {
                    Usuario usuario = new Usuario();
                    usuario.setClave(request.getParameter("password"));
                    usuario.setUsername(request.getParameter("usuario"));
                    udao.addUsuario(usuario);
                    //Para que cuando se registre entre automaticamente 
                    String where = "where UserName = '" + request.getParameter("usuario") + "' and Clave = '" + request.getParameter("password") + "'";
                    usuarios = udao.getUsuario(where);
                    //Aqui es muy raro que entre pero por si acaso lo ponemos
                    if (usuarios.isEmpty()) {
                        request.setAttribute("error", "No se ha podido logear después del registro hazlo manualmente");
                        request.getRequestDispatcher("jsp/Accesos/login.jsp").forward(request, response);
                    } else {
                        HttpSession sesion = request.getSession();
                        //Uso un for pero solo cojo uno es imposible que haya varios usuarios despues de la clausula where de antes
                        for (Usuario elemento : usuarios) {
                            sesion.setAttribute("usuario", elemento);
                        }
                    }
                   
                }
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            //Por si algo sale mal vuelve al index
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
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
        //Uso el metodo post para salir de la session
        HttpSession sesion = request.getSession();
        sesion.invalidate();
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
