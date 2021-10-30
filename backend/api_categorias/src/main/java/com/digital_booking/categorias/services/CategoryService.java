package com.digital_booking.categorias.services;

import com.digital_booking.categorias.exceptions.ResourceNotFound;
import com.digital_booking.categorias.model.Category;
import com.digital_booking.categorias.repository.ICategoryRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Log4j
@Service
public class CategoryService {

    private ICategoryRepository categoryRepository;

    @Autowired
    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(Category c){
        // Evita que se guarde un id no generado por la DB
        c.setId(null);
        Category category = categoryRepository.save(c);
        log.info("Se guardo categoría con titulo " + category.getTitle());
        return category;
    }

    public Category findById(Long id) throws ResourceNotFound {
        Optional<Category> categoria = categoryRepository.findById(id);
        if(categoria.isEmpty()){
            throw new ResourceNotFound("No se encontró categoría con id "+ id);
        }else {
            log.info("Se busco categoría con id "+id);
            return categoria.get();
        }
    }

    public Category findByTitle(String title) throws ResourceNotFound{
        Category category = categoryRepository.findByTitle(title);
        if(category == null){
            throw  new ResourceNotFound("No se encontró categoría con title "+ title);
        }else{
            log.info("Se busco categoría con titulo "+ title);
            return category;
        }
    }

    public void updateCategory(Category category) throws ResourceNotFound {
        findById(category.getId());
        categoryRepository.save(category);
        log.info("Se actualizo categoría con id "+ category.getId());
    }

    public void deleteById(Long id) throws ResourceNotFound {
        Category category = findById(id);
        log.info("Se elimino categoría con id "+ category.getId());
        categoryRepository.deleteById(id);
    }

    public Collection<Category> findAllCategories(){
        log.info("Se buscaron todas las categorías");
        return categoryRepository.findAll();
    }
}