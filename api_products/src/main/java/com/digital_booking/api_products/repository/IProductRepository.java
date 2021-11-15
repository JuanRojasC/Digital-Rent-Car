package com.digital_booking.api_products.repository;

import com.digital_booking.api_products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("FROM Product p WHERE p.name LIKE %:name%")
    Collection<Product> findByName(String name);
}
