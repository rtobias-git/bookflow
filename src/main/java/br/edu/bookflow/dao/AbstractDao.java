package br.edu.bookflow.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class AbstractDao<T> {

    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public void adicionar(T entity) {
        em.persist(entity);
    }
    
    public void excluir(T entity) {
        em.remove(em.merge(entity));
    }
}
