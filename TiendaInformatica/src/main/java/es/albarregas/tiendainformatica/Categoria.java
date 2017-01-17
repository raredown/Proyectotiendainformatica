/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.tiendainformatica;

import es.albarregas.beans.Producto;
import es.albarregas.modelos.ProductoOrdenados;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
@WebServlet(name = "Categoria", urlPatterns = {"/Categoria"})
public class Categoria extends HttpServlet {

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
        if (request.getParameter("idcateindex") != null) {
            String idcatein = request.getParameter("idcateindex");
            int idcateiint = Integer.parseInt(idcatein);
            int limit = 5;
            //Categoria que viene dada por el index
            ServletContext ctx = getServletContext();
            ArrayList<Producto> productos = (ArrayList<Producto>) ctx.getAttribute("productos");
            Iterator<Producto> it = productos.iterator();

            ArrayList<Producto> productosCat = new ArrayList();

            while (it.hasNext()) {
                Producto productito = it.next();
                // productosImagenes.add(it.next().setListaImagenes(daoimagen.getImagen("where imagenes.IdProducto = ")));
                if (idcateiint == productito.getIdCategoria()) {

                    productosCat.add(productito);

                }
            }
            // ProductoOrdenados ordenados = new ProductoOrdenados();
            //java.util.Collections.sort(productosCat, Comparable);
            /*Por id marca
            Collections.sort(productosCat,new Comparator<Producto>(){
                     public int compare(Producto s1,Producto s2){
                           // Write your logic here.
                           return Integer.compare(s1.getIdMarca(), s2.getIdMarca());
                     }});
             */
            if (request.getParameter("ordenacion") != null) {
                String ordenacion = request.getParameter("ordenacion");
                switch (ordenacion) {

                    case "precio":
                        Collections.sort(productosCat, new Comparator<Producto>() {
                            public int compare(Producto s1, Producto s2) {
                                // Write your logic here.
                                return Integer.compare(Math.round(s1.getPrecioUnitario()), Math.round(s2.getPrecioUnitario()));
                            }
                        });
                        break;

                    case "marca":
                        Collections.sort(productosCat, new Comparator<Producto>() {
                            public int compare(Producto s1, Producto s2) {
                                // Write your logic here.
                                return Integer.compare(s1.getIdMarca(), s2.getIdMarca());
                            }
                        });
                        break;
                    case "nombre":

                        break;
                }

            }

            int tamano = productosCat.size();
            int numeroPagina = tamano / 5;
            if (tamano % 5 != 0) {
                numeroPagina = numeroPagina + 1;
            }

            request.setAttribute("numeroPagina", numeroPagina);
            request.setAttribute("productosCat", productosCat);
            request.setAttribute("idcatein", idcatein);
            request.getRequestDispatcher("jsp/productos/porcategoria3.jsp").forward(request, response);
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
