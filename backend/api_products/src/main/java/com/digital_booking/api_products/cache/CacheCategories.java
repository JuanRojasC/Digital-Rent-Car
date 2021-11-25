package com.digital_booking.api_products.cache;

import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.feignclients.CategoryFeignClient;
import com.digital_booking.api_products.util.Log;
import com.digital_booking.api_products.vo.Category;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;

@Log4j
@Component
public class CacheCategories {

    private static CacheCategories instance = null;

    @Autowired
    private CategoryFeignClient categoryFeignClient;
    private Map<Long, Category> cacheCategories;

    private CacheCategories(){}

    public static CacheCategories getInstance(){
        if(instance == null){
            instance = new CacheCategories();
        }
        return instance;
    }

    /*-------------------------------------------Post Construct-------------------------------------------*/

    @PostConstruct
    public void startCacheForCategories(){
        Long ids[] = {1L, 2L, 3L, 4L};
        Collection<Category> categoriesResponse = categoryFeignClient.findCategoriesByIds(Arrays.asList(ids));
        log.info(Log.formatLog("CATEGORIES-CACHE-MEMORY", "Se guardaron las categorias con ids " + Arrays.asList(ids)));
        Map<Long, Category> categories = new HashMap<>();
        for(Category category : categoriesResponse){
            categories.put(category.getId(), category);
        }
        this.cacheCategories = categories;
    }

    /*-------------------------------------------Methods-------------------------------------------*/

    public Map<Long, Category> checkCacheForCategories(Collection<Long> ids) throws ResourceNotFound {
        Map<Long, Category> categories = new HashMap<>();
        log.info(Log.formatLog("CATEGORIES-CACHE-MEMORY", "Buscando categories con ids " + Arrays.asList(ids)));
        for(Long id : ids){
            Category category = this.cacheCategories.get(id);
            if(category == null) {
                category = categoryFeignClient.findCategoryById(id);
                category = category.getId() != null? category : null;
                if(category != null){
                    this.cacheCategories.put(category.getId(), category);
                }
            }
            categories.put(category.getId(), category);
        }
        log.info(Log.formatLog("CATEGORIES-CACHE-MEMORY", "Categorias con ids " + Arrays.asList(ids) + " obtenidas"));
        return categories;
    }

    public Category checkCacheForCategory(Long id) throws ResourceNotFound {
        Category category = this.cacheCategories.get(id);
        if(category == null){
            category = categoryFeignClient.findCategoryById(id);
            if(category != null) {
                this.cacheCategories.put(category.getId(), category);
                log.info(Log.formatLog("CATEGORIES-CACHE-MEMORY", "Categoria con id: " + Arrays.asList(id) + " obtenida"));
            }
        }
        return category;
    }


}
