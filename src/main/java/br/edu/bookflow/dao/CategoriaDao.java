/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.bookflow.dao;

import br.edu.bookflow.model.Category;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless
public class CategoriaDao extends AbstractDao<Category>{
    
    public Category obterPeloId(Long id){
        EntityManager em = getEntityManager();
        return em.find(Category.class, id);
    }
    
    public List<Category> obterTodos(){
        EntityManager em = getEntityManager();
        TypedQuery<Category> query = em.createNamedQuery("Category.obterTodos", Category.class);
        return query.getResultList();
    }
}
