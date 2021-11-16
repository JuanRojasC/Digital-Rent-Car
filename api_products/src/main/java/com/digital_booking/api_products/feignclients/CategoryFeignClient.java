package com.digital_booking.api_products.feignclients;

import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.vo.Category;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "categories-service")
@RequestMapping("/categories")
public interface CategoryFeignClient {

    @GetMapping("/find/all")
    Collection<Category> findAllCategories();

    @GetMapping("/find/{id}")
    Category findCategoryById(@PathVariable Long id) throws ResourceNotFound;

    @PostMapping("/find/ids")
    Collection<Category> findCategoriesByIds(@RequestBody Collection<Long> categoriesIds);
}
