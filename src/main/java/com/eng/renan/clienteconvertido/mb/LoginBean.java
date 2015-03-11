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

import javax.inject.Inject;
import com.eng.renan.clienteconvertido.dao.UsuarioDao;
import com.eng.renan.clienteconvertido.modelo.Usuario;
import javax.enterprise.inject.Model;

@Model
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1410748902384124487L;

	private Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioLogadoBean usuarioLogado;
	
	@Inject
	private UsuarioDao dao;
	
	public String efetuaLogin() {
		if (dao.existe(usuario)) {
			usuarioLogado.loga(usuario);
			return "index?faces-redirect=true";
		}
		return "login?faces-redirect=true";
	}
	
	public String deslogar() {
		this.usuarioLogado.desloga();
		
		return "login?faces-redirect=true";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
        
        public String register(){
          return "register.xhtml";
        }    
	
}
