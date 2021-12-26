package com.digital_booking.api_products.repository;

import com.digital_booking.api_products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Date;

public interface IProductRepository extends JpaRepository<Product, Long> {

    @Query("FROM Product p WHERE p.name LIKE %:name%")
    Collection<Product> findByName(String name);

    @Query("FROM Product p WHERE p.cityId = ?1")
    Collection<Product> findByCity(Long id);

    @Query(nativeQuery = true, value = "INSERT INTO products_terms_and_conditions VALUES (?1, ?2);")
    Long detachTermAndCondition(Long productId, Long productTandC);

}
