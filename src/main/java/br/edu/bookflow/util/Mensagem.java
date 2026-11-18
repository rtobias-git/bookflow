package br.edu.bookflow.util;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;

/**
 *
 * @author aluno
 */
public class Mensagem {
    
    private static void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public static void showInfo(String conteudo) {
        addMessage(FacesMessage.SEVERITY_INFO, 
                "Informacao", conteudo);
    }

    public static void showWarn(String conteudo) {
        addMessage(FacesMessage.SEVERITY_WARN, 
                "Atencao", conteudo);
    }

    public static void showError(String conteudo) {
        addMessage(FacesMessage.SEVERITY_ERROR, 
                "Erro", conteudo);
    }
    
}
