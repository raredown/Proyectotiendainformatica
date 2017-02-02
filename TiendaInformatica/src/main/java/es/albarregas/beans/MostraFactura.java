/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public class MostraFactura {

    private int numeroFactura;
    private String nombreCliente;
    private String direccion;
    private String nombrePueblo;
    private String nombreProvincia;
    private String codigoPostal;
    private Pedido pedido;
    private String email;
    private ArrayList<LineaPedido> lineaspedidos;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombrePueblo() {
        return nombrePueblo;
    }

    public void setNombrePueblo(String nombrePueblo) {
        this.nombrePueblo = nombrePueblo;
    }

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public ArrayList<LineaPedido> getLineaspedidos() {
        return lineaspedidos;
    }

    public void setLineaspedidos(ArrayList<LineaPedido> lineaspedidos) {
        this.lineaspedidos = lineaspedidos;
    }

}
