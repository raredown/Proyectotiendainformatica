/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.modelos;

import es.albarregas.beans.Producto;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author rafa
 */
public class ProductoOrdenados {

    static private Comparator<Producto> ascNombre;
    // static private Comparator<Producto> descPageNumber;

    static {
        ascNombre = new Comparator<Producto>() {
            @Override
            public int compare(Producto b1, Producto b2) {
                return b1.getDenominacion().compareTo(b2.getDenominacion());
            }
        };
    }
    /*
    private Producto[] productos;

    public Producto[] getProductos() {
        return productos;
    }*/
      public void sortAscTitle(Producto[] productos){
        Arrays.sort(productos, ascNombre);
    }
}
