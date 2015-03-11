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
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.StreamedContent;
import com.eng.renan.clienteconvertido.util.ReportUtil;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
 
@ManagedBean(name = "report")
public class Report {
 
    private StreamedContent arquivoRetorno;
     
    public StreamedContent getArquivoRetorno() {
        FacesContext context = FacesContext.getCurrentInstance();
        ReportUtil reportUtil = new ReportUtil();
        HashMap parametrosRelatorio = new HashMap();
        try {
            this.arquivoRetorno = reportUtil.geraRelatorio(parametrosRelatorio);
        } catch (Exception e) {
            context.addMessage(null, new FacesMessage(e.getMessage()));
            return null;
        }         
        return this.arquivoRetorno;
    }    
    public void setArquivoRetorno(StreamedContent arquivoRetorno) {
        this.arquivoRetorno = arquivoRetorno;
    }    
}