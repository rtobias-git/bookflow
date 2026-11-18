/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.bookflow.controller;

import br.edu.bookflow.dao.BookDao;
import br.edu.bookflow.dao.CategoriaDao;
import br.edu.bookflow.model.Book;
import br.edu.bookflow.model.Category;
import br.edu.bookflow.util.Mensagem;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author aluno
 */
@Named
@RequestScoped
public class BookBean {
    private Book book = new Book();
    private Category categoriaSelecionada;
    private List<Book> books;
    private List<Category> categorias;
    private String sitSelecionada;
    
    @Inject
    private BookDao bookDao;
    
    @Inject
    private CategoriaDao categoriaDao;
    
    public void adicionar(){
        if(sitSelecionada != null)
            book.setAvailable(Boolean.parseBoolean(sitSelecionada));
        
        bookDao.adicionar(book);
    }
    
    public List<Book> obterLivros(){
        if(this.books == null){
            this.books = bookDao.obterTodos();
            if(this.books == null)
                Mensagem.showInfo("A lista esta vazia");
        }
            
        return this.books;
    }
    
    public List<Category> obterCategorias(){
        if(this.categorias == null){
            this.categorias = categoriaDao.obterTodos();
        }
            
        return this.categorias;
    }
    
    public void filtrar(){
        if(categoriaSelecionada != null){
            this.books = bookDao.fitrarPorCategoria(categoriaSelecionada.getId());
        }else{
            this.books = obterLivros();
        }
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Category getCategoriaSelecionada() {
        return categoriaSelecionada;
    }

    public void setCategoriaSelecionada(Category categoriaSelecionada) {
        this.categoriaSelecionada = categoriaSelecionada;
    }

    public String getSitSelecionada() {
        return sitSelecionada;
    }

    public void setSitSelecionada(String sitSelecionada) {
        this.sitSelecionada = sitSelecionada;
    }
}
