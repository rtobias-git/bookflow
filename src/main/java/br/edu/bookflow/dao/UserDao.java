/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.bookflow.dao;

import br.edu.bookflow.model.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

/**
 *
 * @author aluno
 */
@Stateless
public class UserDao extends AbstractDao<User>{
    
    public User obterLogin(String email, String senha){
        EntityManager em = getEntityManager();
        TypedQuery<User> query = em.createNamedQuery("User.obterLogin", User.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        try{
            return query.getSingleResult();
        }catch(Exception e){
            return null;
        }
    }
}
