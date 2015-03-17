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
import com.eng.renan.clienteconvertido.dao.LojaDao;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import com.eng.renan.clienteconvertido.dao.VendedorDao;
import com.eng.renan.clienteconvertido.modelo.Loja;
import com.eng.renan.clienteconvertido.modelo.Vendedor;
import com.eng.renan.clienteconvertido.tx.Transactional;

@Model
@Transactional
public class VendedorBean {
	private Vendedor vendedor = new Vendedor();
	private List<Vendedor> vendedores;
        private Long idLoja;
	
	@Inject
	VendedorDao dao;
        
        @Inject
        LojaDao lojaDao;
	
	public Vendedor getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	public void grava(){
		Loja loja = lojaDao.buscaPorId(getIdLoja());
            
                vendedor.setLoja(loja);
                
		if(vendedor.getId() == null){
			dao.adiciona(vendedor);
		}else{
			dao.atualiza(vendedor);
		}
		this.vendedor = new Vendedor();
		this.vendedores = dao.listaTodos();
	}
	
	public List<Vendedor> getVendedores(){
		if(vendedores == null){
			vendedores = dao.listaTodos();
		}
		
		return vendedores;
	}
	
	public void setVendedores(List<Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public void remove(Vendedor vendedor){
		dao.remove(vendedor);
		this.vendedores = dao.listaTodos(); 
	}
	
	public void comecaComMaiuscula(FacesContext fc, UIComponent component, Object value) 
			throws ValidatorException{
		String valor = value.toString();
		if(!valor.matches("[A-Z].*")){
			throw new ValidatorException(new FacesMessage("Deveria começar com maiúscula"));
		}
	}

        public Long getIdLoja() {
            return idLoja;
        }

        public void setIdLoja(Long idLoja) {
            this.idLoja = idLoja;
        }
        	
}
