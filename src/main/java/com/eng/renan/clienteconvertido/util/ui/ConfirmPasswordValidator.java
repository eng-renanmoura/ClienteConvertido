/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eng.renan.clienteconvertido.util.ui;

/**
 *
 * @author renanferreira
 */
 
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;
 
@FacesValidator("confirmPasswordValidator")
public class ConfirmPasswordValidator implements Validator {
 
    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
 
        UIInput senhaComponent = (UIInput) component.getAttributes().get("senhaComponent");
        String senha = (String) senhaComponent.getValue();
 
        String confirm = (String) value;
 
        if (!senha.equals(confirm)) {
            throw new ValidatorException(new FacesMessage("Senhas não são iguais."));
        }
    }
}