package com.digital_booking.api_categories.controller;

import com.digital_booking.api_categories.dto.CategoryDTO;
import com.digital_booking.api_categories.exceptions.IncompleteData;
import com.digital_booking.api_categories.exceptions.ResourceNotFound;
import com.digital_booking.api_categories.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // POST REQUEST
    @PostMapping("/save/new")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDTO c){
        CategoryDTO category = categoryService.saveCategory(c);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PostMapping("/find/ids")
    public ResponseEntity<?> findCategoriesByIds(@RequestBody Collection<Long> categoriesIds){
        Collection<CategoryDTO> category = categoryService.findAllCategoriesById(categoriesIds);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    /*------------------------------------------------------------------------------------------------------*/

    // GET REQUEST
    @GetMapping("/find/all")
    public ResponseEntity<?> findAllCategories(){
        return ResponseEntity.ok(categoryService.findAllCategories());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findCategoryById(@PathVariable Long id) throws ResourceNotFound {
        CategoryDTO category = categoryService.findCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @GetMapping("/find/title")
    public ResponseEntity<?> findCategoryByTitle(@RequestParam String category) throws ResourceNotFound {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findCategoryByTitle(category));
    }

    /*------------------------------------------------------------------------------------------------------*/

    // PUT REQUEST
    @PutMapping("/update/category")
    public ResponseEntity<?> editCategory(@RequestBody CategoryDTO c) throws ResourceNotFound, IncompleteData {
        categoryService.updateCategory(c);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*------------------------------------------------------------------------------------------------------*/

    // DELETE REQUEST
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id) throws ResourceNotFound {
        categoryService.deleteCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Categoria Eliminada");
    }
}