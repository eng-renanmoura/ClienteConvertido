/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eng.renan.clienteconvertido.listener;

/**
 *
 * @author renanferreira
 */
import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

import com.eng.renan.clienteconvertido.mb.UsuarioLogadoBean;

public class Autorizador implements PhaseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3863062805588826397L;
        
	
	UsuarioLogadoBean usuarioLogado = new UsuarioLogadoBean();
	
	
	@Override
	public void afterPhase(PhaseEvent event) {
		FacesContext context = event.getFacesContext();
		
		if("/public/index.xhtml".equals(context.getViewRoot().getViewId())){
			return;
		}
		
		if("/public/login.xhtml".equals(context.getViewRoot().getViewId())){
			return;
		}
		
		if(!usuarioLogado.isLogado()){
			NavigationHandler handler = context.getApplication().getNavigationHandler();
			
			handler.handleNavigation(context, null, "/public/login?faces-redirect=true");
			
			context.renderResponse();
		}
		
	
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.RESTORE_VIEW;
	}

}