/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.util.Date;

/**
 *
 * @author Daw2
 */
public class Producto {

    private int idProducto;
    private String denominacion;
    private String descripcion;
    private float precioUnitario;
    private int stock;
    private int stockMinimo;
    private Date dechaAlta;
    private String oferta;
    private String fueraCatalogo;
    private int rating;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public Date getDechaAlta() {
        return dechaAlta;
    }

    public void setDechaAlta(Date dechaAlta) {
        this.dechaAlta = dechaAlta;
    }

    public String getOferta() {
        return oferta;
    }

    public void setOferta(String oferta) {
        this.oferta = oferta;
    }

    public String getFueraCatalogo() {
        return fueraCatalogo;
    }

    public void setFueraCatalogo(String fueraCatalogo) {
        this.fueraCatalogo = fueraCatalogo;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
