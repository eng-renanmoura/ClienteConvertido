/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eng.renan.clienteconvertido.dao;

/**
 *
 * @author renanferreira
 */

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.eng.renan.clienteconvertido.modelo.Usuario;

public class UsuarioDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;
	
	public boolean existe(Usuario usuario) {
		Query query = manager.createQuery("select u from Usuario u where u.login = :pLogin and u.senha = :pSenha")
						.setParameter("pLogin", usuario.getLogin())
						.setParameter("pSenha", usuario.getSenha());

		boolean encontrado = !query.getResultList().isEmpty();

		return encontrado;
	}
}