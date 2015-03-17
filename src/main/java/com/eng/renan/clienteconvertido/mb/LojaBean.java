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
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import com.eng.renan.clienteconvertido.dao.LojaDao;
import com.eng.renan.clienteconvertido.modelo.Loja;
import com.eng.renan.clienteconvertido.tx.Transactional;

@Model
@Transactional
public class LojaBean {
	private Loja loja = new Loja();
	private List<Loja> lojas;
	
	@Inject
	LojaDao dao;
	
	public Loja getLoja() {
		return loja;
	}
	
	public void setLoja(Loja loja) {
		this.loja = loja;
	}
	
	public void grava(){
		
		if(loja.getId() == null){
			dao.adiciona(loja);
		}else{
			dao.atualiza(loja);
		}
		this.loja = new Loja();
		this.lojas = dao.listaTodos();
	}
	
	public List<Loja> getLojas(){
		if(lojas == null){
			lojas = dao.listaTodos();
		}
		
		return lojas;
	}
	
	public void setLojas(List<Loja> lojas) {
		this.lojas = lojas;
	}

	public void remove(Loja loja){
		dao.remove(loja);
		this.lojas = dao.listaTodos(); 
	}
	
	public void comecaComMaiuscula(FacesContext fc, UIComponent component, Object value) 
			throws ValidatorException{
		String valor = value.toString();
		if(!valor.matches("[A-Z].*")){
			throw new ValidatorException(new FacesMessage("Deveria começar com maiúscula"));
		}
	}
	
}
