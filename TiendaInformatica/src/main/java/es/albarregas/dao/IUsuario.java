/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.dao;

import es.albarregas.beans.Usuario;
import java.util.ArrayList;

/**
 *
 * @author rafa
 */
public interface IUsuario {
    public ArrayList<Usuario> getUsuario(String clausulaWhere);
    public void addUsuario (Usuario usuario);
    public void updateUsuario(Usuario usuario);
    public void actualizarUsuarioBloquead(Usuario usuario);
    public void actualizarUsuarioFecha(Usuario usuario);
    public void closeConnection();
}
