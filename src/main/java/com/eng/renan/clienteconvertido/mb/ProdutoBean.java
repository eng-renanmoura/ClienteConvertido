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

import com.eng.renan.clienteconvertido.dao.ProdutoDao;
import com.eng.renan.clienteconvertido.modelo.Produto;
import com.eng.renan.clienteconvertido.tx.Transactional;

@Model
@Transactional
public class ProdutoBean {
	private Produto produto = new Produto();
	private List<Produto> produtos;
	
	@Inject
	ProdutoDao dao;
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public void grava(){
		System.out.println("Será que vai passar por aqui?");
		
		if(produto.getId() == null){
			dao.adiciona(produto);
		}else{
			dao.atualiza(produto);
		}
		this.produto = new Produto();
		this.produtos = dao.listaTodos();
	}
	
	public List<Produto> getProdutos(){
		if(produtos == null){
			System.out.println("carregando produtos...");
			produtos = dao.listaTodos();
		}
		
		return produtos;
	}
	
	
	
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public void remove(Produto produto){
		dao.remove(produto);
		this.produtos = dao.listaTodos(); 
	}
	
	
	public void comecaComMaiuscula(FacesContext fc, UIComponent component, Object value) 
			throws ValidatorException{
		String valor = value.toString();
		if(!valor.matches("[A-Z].*")){
			throw new ValidatorException(new FacesMessage("Deveria começar com maiúscula"));
		}
	}
	
}
