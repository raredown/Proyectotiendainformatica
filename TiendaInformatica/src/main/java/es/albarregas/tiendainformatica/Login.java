/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tiendainformatica;

import es.albarregas.beans.Cliente;
import es.albarregas.beans.Dirrecion;
import es.albarregas.beans.LineaPedido;
import es.albarregas.beans.Pedido;
import es.albarregas.beans.Usuario;
import es.albarregas.dao.ICliente;
import es.albarregas.dao.IDirrecion;
import es.albarregas.dao.ILineaPedido;
import es.albarregas.dao.IPedido;
import es.albarregas.dao.IUsuario;
import es.albarregas.daofactory.DAOFactory;
import es.albarregas.modelos.Formularios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletContext;
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
                        if (elemento.getBloqueado().equals("n")) {

                            java.util.Date d = new java.util.Date();
                            elemento.setUltimoAcesso(new java.sql.Date(d.getTime()));
                            udao.actualizarUsuarioFecha(elemento);
                            sesion.setAttribute("usuario", elemento);
                            ICliente cdao = daof.getClienteDao();
                            ArrayList<Cliente> clientes = new ArrayList();
                            String whereCLie = "where IdCliente = '" + elemento.getIdUsuario() + "'";
                            clientes = cdao.getCliente(whereCLie);
                            for (Cliente elemento2 : clientes) {
                                sesion.setAttribute("cliente", elemento2);
                                IDirrecion dirredao = daof.getDirrecion();
                                ArrayList<Dirrecion> dirreciones = new ArrayList();
                                dirreciones = dirredao.getDirrecion("where IdCliente =" + elemento2.getIdCliente());
                                sesion.setAttribute("dirreciones", dirreciones);

                                //Metemos dirreciones
                                IPedido daopedido = daof.getPedido();
                                ArrayList<Pedido> pedidos = new ArrayList();
                                pedidos = daopedido.getPedido("where IdCliente=" + elemento2.getIdCliente());
                                sesion.setAttribute("pedidos", pedidos);
                                for (Pedido pedidito : pedidos) {
                                    //ya tiene un pedido en el carrito en la base de datos
                                    if (pedidito.getEstado().equals("n")) {
                                        //compruebo si exite el carrito 
                                        if (sesion.getAttribute("carrito") == null) {
                                            sesion.setAttribute("carrito", pedidito);
                                            ILineaPedido daolineapedi = daof.getLineaPedido();
                                            ArrayList<LineaPedido> lineasPedido = new ArrayList();
                                            lineasPedido = daolineapedi.getLineaPedido("where IdPedido=" + pedidito.getIdPedido());
                                            ServletContext ctx = getServletContext();
                                            ArrayList<es.albarregas.beans.Producto> productos = (ArrayList<es.albarregas.beans.Producto>) ctx.getAttribute("productos");
                                            for (LineaPedido lineaactual : lineasPedido) {
                                                for (es.albarregas.beans.Producto prod : productos) {
                                                    if (prod.getIdProducto() == lineaactual.getIdProducto()) {
                                                        lineaactual.setProducto(prod);
                                                    }
                                                }
                                            }
                                            sesion.setAttribute("lineaspedidos", lineasPedido);
                                        } //si ahi algo en el carrito lo meteremos en su antiguo carrito
                                        else {
                                            Pedido carritoPedido = (Pedido) sesion.getAttribute("carrito");
                                            ILineaPedido daolineapedi = daof.getLineaPedido();
                                            ArrayList<LineaPedido> lineasPedidoSesion = (ArrayList<LineaPedido>) sesion.getAttribute("lineaspedidos");
                                            ArrayList<LineaPedido> lineasPedido = daolineapedi.getLineaPedido("where IdPedido=" + pedidito.getIdPedido());
                                            ServletContext ctx = getServletContext();
                                            ArrayList<es.albarregas.beans.Producto> productos = (ArrayList<es.albarregas.beans.Producto>) ctx.getAttribute("productos");
                                            for (LineaPedido lineaactual : lineasPedido) {

                                                for (es.albarregas.beans.Producto prod : productos) {
                                                    if (prod.getIdProducto() == lineaactual.getIdProducto()) {
                                                        lineaactual.setProducto(prod);
                                                    }
                                                }
                                            }
                                            for (LineaPedido lineadeSesion : lineasPedidoSesion) {
                                                lineasPedido.add(lineadeSesion);
                                                lineadeSesion.setNumeroLinea(lineasPedidoSesion.size() + 1);
                                                lineadeSesion.setIdPedido(pedidito.getIdPedido());
                                                daolineapedi.addLineaPedido(lineadeSesion);
                                            }

                                            daopedido.deletePedido(carritoPedido);
                                            sesion.setAttribute("lineaspedidos", lineasPedido);
                                            sesion.setAttribute("carrito", pedidito);

                                        }
                                    }
                                }
                            }//for pedido

                        } else {
                            request.setAttribute("error", "Usuario bloqueado contacte con el administrador");
                            request.getRequestDispatcher("jsp/Accesos/login.jsp").forward(request, response);
                        }
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
        //Uso el metodo get para salir de la session
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
