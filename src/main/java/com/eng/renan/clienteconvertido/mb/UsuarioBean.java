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
import com.eng.renan.clienteconvertido.dao.PerfilDao;
import com.eng.renan.clienteconvertido.modelo.Perfil;
import com.eng.renan.clienteconvertido.modelo.Usuario;
import com.eng.renan.clienteconvertido.util.GenerateValidation;
import com.eng.renan.clienteconvertido.util.ManipulateDate;
import com.eng.renan.clienteconvertido.util.RoleEnum;
import java.io.Serializable;
import java.util.Map;
 
import javax.enterprise.inject.Model;
import javax.inject.Inject;
 
@Model
public class UsuarioBean implements Serializable {
 
    private Usuario usuario = new Usuario();
    private Perfil perfil = new Perfil();
 
    private int dia = 0;
    private int mes = 0;
    private int ano = 0;
    
    @Inject
    PerfilDao perfilDao;
 
    public String save() {
 
       
        
        //usuario.setSenha(GenerateMD5.generate(usuario.getSenha()));
        usuario.setValidation(GenerateValidation.keyValidation());
        usuario.getPermissions().add(RoleEnum.ROLE_COMMON.getValue());
        usuario.setActive(false);
         
        perfil.setUsuario(usuario);
        perfil.setBirth(ManipulateDate.getDate(ano, mes, dia));
 
        perfilDao.adiciona(perfil);
        return "/public/feedback_login";
    }
 
    public Usuario getUsuario() {
        return usuario;
    }
 
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
 
    public Perfil getPerfil() {
        return perfil;
    }
 
    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
 
    public Map<String, Object> getDias() {
        return ManipulateDate.getDays();
    }
 
    public Map<String, Object> getMeses() {
        return ManipulateDate.getMonths();
    }
 
    public Map<String, Object> getAnos() {
        return ManipulateDate.getYears();
    }
 
    public int getDia() {
        return dia;
    }
 
    public void setDia(int dia) {
        this.dia = dia;
    }
 
    public int getMes() {
        return mes;
    }
 
    public void setMes(int mes) {
        this.mes = mes;
    }
 
    public int getAno() {
        return ano;
    }
 
    public void setAno(int ano) {
        this.ano = ano;
    }
}