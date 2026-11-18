package br.edu.bookflow.dao;

import br.edu.bookflow.model.Book;
import br.edu.bookflow.model.Category;
import br.edu.bookflow.model.Role;
import br.edu.bookflow.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/** Cadastra usuários, categorias e livros de exemplo a cada deploy. */
@Singleton
@Startup
public class Inicializador {

    @PersistenceContext(unitName = "conexaoPU")
    private EntityManager em;

    @PostConstruct
    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public void load() {
        em.persist(new User("Lívia Leitora", "leitor@email.com", "123456", Role.USER));
        em.persist(new User("Bruno Bibliotecário", "bibliotecario@email.com", "123456", Role.ADMIN));

        Category romance = new Category("Romance");
        Category ficcao = new Category("Ficção Científica");
        Category tecnico = new Category("Técnico");
        Category historia = new Category("História");
        em.persist(romance);
        em.persist(ficcao);
        em.persist(tecnico);
        em.persist(historia);

        em.persist(new Book("Clean Code", "Robert C. Martin", "9780132350884", tecnico, true));
        em.persist(new Book("Effective Java", "Joshua Bloch", "9780134685991", tecnico, false));
        em.persist(new Book("Dom Casmurro", "Machado de Assis", "9788535902778", romance, true));
        em.persist(new Book("Duna", "Frank Herbert", "9780306406157", ficcao, true));
        em.persist(new Book("Sapiens", "Yuval Noah Harari", "9781491950357", historia, false));
        em.persist(new Book("O Hobbit", "J. R. R. Tolkien", "9780596007126", romance, true));
    }
}
