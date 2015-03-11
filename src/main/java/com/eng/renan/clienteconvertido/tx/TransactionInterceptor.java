/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eng.renan.clienteconvertido.tx;

/**
 *
 * @author renanferreira
 */

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transactional
public class TransactionInterceptor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5736106550956158949L;
	@Inject
	private EntityManager manager;
	
	@AroundInvoke
	public Object intercept(InvocationContext ctx) {
		
		try {
			System.out.println("Abrindo a transação");
			manager.getTransaction().begin();
			
			Object resultado = ctx.proceed();
			
			manager.getTransaction().commit();
			System.out.println("Comitando a transação");
			
			return resultado;
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		
		return "";

		}
	}

