/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eng.renan.clienteconvertido;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author renanferreira
 */
@Named
@RequestScoped
public class HelloBean {
    public String getMessage(){
        return "ADS";
    }
}
