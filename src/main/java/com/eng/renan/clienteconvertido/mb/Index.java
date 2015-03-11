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
 
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
  
@RequestScoped
@ManagedBean
public class Index {
    public String getMessage(){
        return "mensagem";
    }
    public String login(){
          return "login.xhtml";
     }
    
    public String index(){
          return "index.xhtml";
    }
    
    public String register(){
          return "register.xhtml";
    }
     
    public String relatorio(){
          return "relatorio.xhtml";
    }
}