/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eng.renan.clienteconvertido.util;

/**
 *
 * @author renanferreira
 */

import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("VENDA_CONVERTIDA");

	@Produces @RequestScoped
	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	public void close(@Disposes EntityManager em) {
		System.out.println("Fechando o entityManager");
		em.close();
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Fechando o entityManagerFactory");
		emf.close();
	}
	
}