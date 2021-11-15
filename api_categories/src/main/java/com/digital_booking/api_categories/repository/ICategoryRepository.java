package com.digital_booking.api_categories.repository;

import com.digital_booking.api_categories.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Long> {

    @Query("FROM Category c WHERE c.title = ?1")
    Category findByTitle(String title);
}
