/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

/**
 *
 * @author Daw2
 */
public class Dirrecion {
    private int idDireccion;
    private int idCliente;
    private String nombreDirrecion;
    private String direccion;
    private String codigoPostal;
    private int idPueblo;
    private String telefono;

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreDirrecion() {
        return nombreDirrecion;
    }

    public void setNombreDirrecion(String nombreDirrecion) {
        this.nombreDirrecion = nombreDirrecion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getIdPueblo() {
        return idPueblo;
    }

    public void setIdPueblo(int idPueblo) {
        this.idPueblo = idPueblo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
