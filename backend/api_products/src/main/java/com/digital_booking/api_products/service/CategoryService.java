package com.digital_booking.api_products.service;

import com.digital_booking.api_products.cache.CacheCategories;
import com.digital_booking.api_products.feignclients.CategoryFeignClient;
import com.digital_booking.api_products.vo.Category;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Log4j
@Service
public class CategoryService {

    private CategoryFeignClient categoryFeignClient;
    private CacheCategories cacheCategories;

    @Autowired
    public CategoryService(CategoryFeignClient categoryFeignClient, CacheCategories cacheCategories) {
        this.categoryFeignClient = categoryFeignClient;
        this.cacheCategories = cacheCategories;
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public Category getCategory(Long id){
        try{
            Category category = cacheCategories.checkCacheForCategory(id);
            log.info("CATEGORY-API-FIND: category con id " + category.getId() + " obtenida");
            return category;
        }catch (Exception e){
            log.error("CATEGORY-API FALLO: " + e.getMessage());
            return null;
        }
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Map<Long, Category> getAllCategories(){
        try{
            Collection<Category> categories = categoryFeignClient.findAllCategories();
            Map<Long, Category> categoriesMap = new HashMap<>();
            for(Category c : categories){
                categoriesMap.put(c.getId(), c);
            }
            log.info("CATEGORY-API-FIND: Todas las categories han sido obtenida");
            return categoriesMap;
        }catch (Exception e){
            log.error("CATEGORY-API FALLO: " + e.getMessage());
            return null;
        }
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Map<Long, Category> getAllCategoriesById(Collection<Long> ids){
        try{
            Map<Long, Category> categories = cacheCategories.checkCacheForCategories(ids);
            log.info("CATEGORY-API-FIND: Categories con ids: " + ids + " obtenidas");
            return categories;
        }catch (Exception e){
            log.error("CATEGORY-API FALLO: " + e.getMessage());
            return null;
        }
    }
}
