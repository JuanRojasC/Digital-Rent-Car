package com.digital_booking.api_products.service;

import com.digital_booking.api_products.cache.CacheCategories;
import com.digital_booking.api_products.feignclients.CategoryFeignClient;
import com.digital_booking.api_products.util.Log;
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
            log.info(Log.formatLog("CATEGORY-SERVICE-FINDING", "Buscando category con id" + id));
            Category category = cacheCategories.checkCacheForCategory(id);
            log.info(Log.formatLog("CATEGORY-SERVICE-SUCCESS", "Category con id " + id + " obtenida"));
            return category;
        }catch (Exception e){
            log.info(Log.formatLog("CATEGORY-SERVICE-FAIL", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Map<Long, Category> getAllCategories(){
        try{
            log.info(Log.formatLog("CATEGORY-SERVICE-FINDING", "Buscando todas las categories"));
            Collection<Category> categories = categoryFeignClient.findAllCategories();
            Map<Long, Category> categoriesMap = new HashMap<>();
            for(Category c : categories){
                categoriesMap.put(c.getId(), c);
            }
            log.info(Log.formatLog("CATEGORY-SERVICE-SUCCESS", "Todas las categories han sido obtenidas"));
            return categoriesMap;
        }catch (Exception e){
            log.info(Log.formatLog("CATEGORY-SERVICE-FAIL", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Map<Long, Category> getAllCategoriesById(Collection<Long> ids){
        try{
            log.info(Log.formatLog("CATEGORY-SERVICE-FINDING", "Buscando categories con ids " + ids));
            Map<Long, Category> categories = cacheCategories.checkCacheForCategories(ids);
            log.info(Log.formatLog("CATEGORY-SERVICE-SUCCESS", "Categories con ids " + ids + " obtenidas"));
            return categories;
        }catch (Exception e){
            log.info(Log.formatLog("CATEGORY-SERVICE-FAIL", e.getMessage()));
            return null;
        }
    }
}
