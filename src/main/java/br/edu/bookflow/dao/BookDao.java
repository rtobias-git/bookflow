/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.bookflow.dao;

import br.edu.bookflow.model.Book;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aluno
 */
@Stateless
public class BookDao extends AbstractDao<Book>{
    
    public List<Book> fitrarPorCategoria(Long idCategoria){
        EntityManager em = getEntityManager();
        TypedQuery<Book> query = em.createNamedQuery("Book.fitrarPorCategoria", Book.class);
        query.setParameter("id_categoria", idCategoria);
        return query.getResultList();
    }
    
    public List<Book> obterTodos(){
        EntityManager em = getEntityManager();
        TypedQuery<Book> query = em.createNamedQuery("Book.obterTodos", Book.class);
        return query.getResultList();
    }
}
