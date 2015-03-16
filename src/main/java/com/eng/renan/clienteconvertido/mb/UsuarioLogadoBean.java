/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eng.renan.clienteconvertido.mb;

/**
 *
 * @author renanferreira
 */

import com.eng.renan.clienteconvertido.modelo.Usuario;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UsuarioLogadoBean implements Serializable {

        private static final long serialVersionUID = 1L;
    
	private Usuario usuario;

	public void loga(Usuario usuario) {
		this.usuario = usuario;
	}

        public void desloga() {
		this.usuario = null;
	}
	
	public boolean isLogado() {
		return usuario != null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
}
