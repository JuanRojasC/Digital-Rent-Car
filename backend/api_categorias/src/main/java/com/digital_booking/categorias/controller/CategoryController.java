package com.digital_booking.categorias.controller;

import com.digital_booking.categorias.exceptions.ResourceNotFound;
import com.digital_booking.categorias.model.Category;
import com.digital_booking.categorias.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // POST REQUEST
    @PostMapping("/registrar")
    public ResponseEntity<Category> registerCategory(@RequestBody Category c){
        Category category = categoryService.saveCategory(c);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    /*------------------------------------------------------------------------------------------------------*/

    // GET REQUEST
    @GetMapping
    public ResponseEntity<?> findAllCategories(){
        return ResponseEntity.ok(categoryService.findAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findCategoryById(@PathVariable Long id) throws ResourceNotFound {
        Category category = categoryService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @GetMapping("/")
    public ResponseEntity<?> findCategoryByTitle(@RequestParam String categoria) throws ResourceNotFound {
        Category category = categoryService.findByTitle(categoria);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    /*------------------------------------------------------------------------------------------------------*/

    // PUT REQUEST
    @PutMapping()
    public ResponseEntity<?> editCategory(@RequestBody Category c) throws ResourceNotFound {
        categoryService.updateCategory(c);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*------------------------------------------------------------------------------------------------------*/

    // DELETE REQUEST
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) throws ResourceNotFound {
        categoryService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Categoria Eliminada");
    }
}