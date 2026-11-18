/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.bookflow.listener;

import br.edu.bookflow.controller.LoginBean;
import br.edu.bookflow.model.Role;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.faces.event.PhaseListener;
import jakarta.inject.Inject;
import java.io.IOException;

/**
 *
 * @author aluno
 */
public class CicloVidaListener implements PhaseListener{

    @Inject
    private LoginBean loginBean;
    
    @Override
    public void afterPhase(PhaseEvent event) {
        System.out.println("After Phase " + event.getPhaseId());
    }
    
     public void beforePhase(PhaseEvent event) {
        System.out.println("Before Phase " + event.getPhaseId());
        
        FacesContext ctx = event.getFacesContext();
        
        String pagina = ctx.getViewRoot().getViewId();
        System.out.println("Pagina: " + pagina);
        
        if(pagina.startsWith("/book/books")){
            if(loginBean.getUsuarioLogado() == null){
                redirecionar(ctx, "/login.xhtml");
            }
        }
        if(pagina.startsWith("/admin")){
            if(loginBean.getUsuarioLogado() == null){
                redirecionar(ctx, "/login.xhtml");
            } else if(loginBean.getUsuarioLogado().getRole() != Role.ADMIN){
                redirecionar(ctx, "/book/books.xhtml");
            }
        }
        if(pagina.startsWith("/login")){
            if(loginBean.getUsuarioLogado() != null){
                redirecionar(ctx, "/book/books.xhtml");
            }
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }
    
    private void redirecionar(FacesContext ctx, String pagina){
        try{
            String projeto = ctx.getExternalContext().getApplicationContextPath();
            ctx.getExternalContext().redirect(projeto + pagina);
        }catch(IOException ex){
            System.out.println("Erro ao redirecionar");
        }
    }
    
}
