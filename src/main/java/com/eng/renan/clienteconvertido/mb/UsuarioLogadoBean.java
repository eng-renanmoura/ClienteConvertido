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
import java.io.Serializable;


import com.eng.renan.clienteconvertido.modelo.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class UsuarioLogadoBean implements Serializable {

	private static final long serialVersionUID = 7816010528258775566L;

	private Usuario usuario;

	public void loga(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public boolean isLogado() {
		return this.usuario != null;
	}
	
	public void desloga() {
		this.usuario = null;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
}
