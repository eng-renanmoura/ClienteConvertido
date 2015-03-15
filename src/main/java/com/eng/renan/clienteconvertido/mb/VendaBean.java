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

import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.LazyDataModel;

import com.eng.renan.clienteconvertido.dao.VendaDao;
import com.eng.renan.clienteconvertido.dao.ProdutoDao;
import com.eng.renan.clienteconvertido.modelo.Item;
import com.eng.renan.clienteconvertido.modelo.Venda;
import com.eng.renan.clienteconvertido.modelo.Produto;

@Named
@ConversationScoped
public class VendaBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6751082803157706917L;
	private Venda venda = new Venda();
	private Item item = new Item();
	private Long idProduto;
	
	private HtmlDataTable tabela;
	
	@Inject
	private LazyDataModel<Venda> dataModel;
	
	@Inject
	private Conversation conversation;
	
	@Inject
	private ProdutoDao produtoDao;
	
	@Inject
	private VendaDao vendaDao;
	
	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public ProdutoDao getProdutoDao() {
		return produtoDao;
	}

	public void setProdutoDao(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}

	public VendaDao getVendaDao() {
		return vendaDao;
	}

	public void setVendaDao(VendaDao vendaDao) {
		this.vendaDao = vendaDao;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	public Venda getVenda(){
		return venda;
	}
	
	public String gravar(){
		this.vendaDao.adiciona(venda);
		conversation.end();
		return "venda?faces-redirect=true";
	}
	
	public void guardaItem(){
		Produto produto = produtoDao.buscaPorId(getIdProduto());
		item.setProduto(produto);
		item.setValorUnitario(produto.getPreco());
		
		venda.getItens().add(item);
		item.setNotaFiscal(venda);
		
		item = new Item();
	}
	
	public String avancar(){
	   if(conversation.isTransient()){
		conversation.begin();
	   }
		return "item?faces-redirect=true";
	}

	public LazyDataModel<Venda> getDataModel() {
		return dataModel;
	}
	
	public void removeItem(){
		Item item = (Item) tabela.getRowData();
		venda.getItens().remove(item);
	}

	public HtmlDataTable getTabela() {
		return tabela;
	}

	public void setTabela(HtmlDataTable tabela) {
		this.tabela = tabela;
	}
	
	
}
