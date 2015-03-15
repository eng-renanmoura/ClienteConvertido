/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eng.renan.clienteconvertido.datamodel;

/**
 *
 * @author renanferreira
 */
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import com.eng.renan.clienteconvertido.dao.VendaDao;
import com.eng.renan.clienteconvertido.modelo.Venda;

public class DataModelVenda extends LazyDataModel<Venda> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1265372999219624964L;

	@Inject
	private VendaDao dao;
	
	@PostConstruct
	void inicializaTotal(){
		super.setRowCount(dao.contaTodos());
	}
	
	//@Override
	//public List<Venda> load(int first, int pageSize, String sortField, SortOrder sortOrder,
	//		Map<String, String> filters){
	//	return dao.listaTodosPaginada(first, pageSize);
	//}
	
}
