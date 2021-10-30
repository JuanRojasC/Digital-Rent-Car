package com.digital_booking.categorias.repository;

import com.digital_booking.categorias.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICategoryRepository extends JpaRepository<Category,Long> {

    @Query("FROM Category c WHERE c.title = ?1")
    Category findByTitle(String title);
}
