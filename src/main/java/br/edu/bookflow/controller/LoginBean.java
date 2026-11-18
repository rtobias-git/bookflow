package br.edu.bookflow.controller;

import br.edu.bookflow.dao.UserDao;
import br.edu.bookflow.model.User;
import br.edu.bookflow.util.Mensagem;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoginBean implements Serializable{
    private User usuario = new User();
    private User usuarioLogado;
    
    @Inject
    private UserDao userDao;
    
    public String acessar(){
        usuarioLogado = userDao.obterLogin(usuario.getEmail(), usuario.getPassword());
        if(usuarioLogado == null){
            Mensagem.showError("Usuario ou Senha Incorretos");
            return null;
        }else{
            Mensagem.showInfo("Usuario Logado");
            return "/book/books?faces-redirect=true"; //trocar depois books.xhtml
        }
    }
    
    public String logout(){
        if(usuarioLogado == null){
            Mensagem.showWarn("Nao ha um usuario logado");
            return null;
        }else{
            usuarioLogado = null;
            Mensagem.showInfo("Usuario Desconectado");
            return "/login?faces-redirect=true";
        }
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public User getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(User usuarioLogado) {
        this.usuarioLogado = usuarioLogado;
    }
}
