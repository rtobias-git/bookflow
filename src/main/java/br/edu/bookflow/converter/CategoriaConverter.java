/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.bookflow.converter;

import br.edu.bookflow.dao.CategoriaDao;
import br.edu.bookflow.model.Category;
import jakarta.enterprise.inject.spi.CDI;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;


/**
 *
 * @author aluno
 */
@FacesConverter(forClass = Category.class)
public class CategoriaConverter implements Converter<Category>{

    @Override
    public Category getAsObject(FacesContext fc, UIComponent uic, String valor) {
        CategoriaDao categoriaDao = CDI.current()
                .select(CategoriaDao.class).get();
        return categoriaDao.obterPeloId(Long.valueOf(valor));
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Category categoria) {
        if(categoria == null){
            return null;
        }
        return categoria.getId().toString();
    }
    
}
