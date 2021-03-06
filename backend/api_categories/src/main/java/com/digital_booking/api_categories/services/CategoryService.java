package com.digital_booking.api_categories.services;

import com.digital_booking.api_categories.dto.CategoryDTO;
import com.digital_booking.api_categories.exceptions.IncompleteData;
import com.digital_booking.api_categories.exceptions.ResourceNotFound;
import com.digital_booking.api_categories.model.Category;
import com.digital_booking.api_categories.repository.ICategoryRepository;
import com.digital_booking.api_categories.util.Log;
import com.digital_booking.api_categories.vo.Image;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Log4j
@Service
public class CategoryService {

    private ICategoryRepository categoryRepository;
    private ImageService imageService;

    @Autowired
    public CategoryService(ICategoryRepository categoryRepository,ImageService imageService) {
        this.categoryRepository = categoryRepository;
        this.imageService = imageService;
    }

    /*-------------------------------------------Save Category-------------------------------------------*/
    public CategoryDTO saveCategory(CategoryDTO c){
        log.info(Log.formatLog("CATEGORY-SERVICE-FINDING", "Guardando nueva category"));
        // Evita que se guarde un id no generado por la DB
        c.setId(null);
        // Guarda la imagen si no existe en la DB
        checkCategoryImage(c);
        Category category = categoryRepository.save(c.mapToCategory());
        c.setId(category.getId());
        log.info(Log.formatLog("CATEGORY-SERVICE-SUCCESS", "Category con id " + category.getId() + " guardada"));
        return c;
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public CategoryDTO findCategoryById(Long id) throws ResourceNotFound {
        log.info(Log.formatLog("CATEGORY-SERVICE-FINDING", "Buscando category con id" + id));
        Optional<Category> categoryResponse = categoryRepository.findById(id);
        if(categoryResponse.isEmpty()){
            throw new ResourceNotFound("No se encontr?? categor??a con id "+ id);
        }else {
            CategoryDTO categoryDTO = setImageToDTO(categoryResponse.get());
            log.info(Log.formatLog("CATEGORY-SERVICE-SUCCESS", "Category con id " + id + " obtenida"));
            return categoryDTO;
        }
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Collection<CategoryDTO> findAllCategoriesById(Collection<Long> ids){
        log.info(Log.formatLog("CATEGORY-SERVICE-FINDING", "Buscando categories con ids " + ids));
        Collection<Category> categories = categoryRepository.findAllById(ids);
        log.info(Log.formatLog("CATEGORY-SERVICE-SUCCESS", "Categories con ids " + ids + " obtenidas"));
        return mapCollectionCategoryToCategoryDTO(categories);
    }

    /*-------------------------------------------Find By Title-------------------------------------------*/

    public CategoryDTO findCategoryByTitle(String title) throws ResourceNotFound{
        log.info(Log.formatLog("CATEGORY-SERVICE-FINDING", "Buscando categories con title " + title));
        Category category = categoryRepository.findByTitle(title);
        if(category == null){
            throw  new ResourceNotFound("No se encontr?? categor??a con title "+ title);
        }else{
            CategoryDTO categoryDTO = setImageToDTO(category);
            log.info(Log.formatLog("CATEGORY-SERVICE-SUCCESS", "Categories con title " + title + " obtenidas"));
            return categoryDTO;
        }
    }

    /*-------------------------------------------Update Category-------------------------------------------*/

    public void updateCategory(CategoryDTO category) throws ResourceNotFound, IncompleteData {
        log.info(Log.formatLog("CATEGORY-SERVICE-UPDATING", "Actualizando category con id " + category.getId()));
        if(category.getId() == null) throw new IncompleteData("Id attribute cannot be null, check your JSON and try again");
        checkExistenceCategoryById(category.getId());
        checkCategoryImage(category);
        categoryRepository.save(category.mapToCategory());
        log.info(Log.formatLog("CATEGORY-SERVICE-SUCCESS", "Category con id " + category.getId() + " actualizada"));
    }

    /*-------------------------------------------Delete By Id-------------------------------------------*/

    public void deleteCategoryById(Long id) throws ResourceNotFound {
        log.info(Log.formatLog("CATEGORY-SERVICE-DELETING", "Eliminando category con id " + id));
        checkExistenceCategoryById(id);
        categoryRepository.deleteById(id);
        log.info(Log.formatLog("CATEGORY-SERVICE-SUCCESS", "Category con id " + id + " eliminada"));
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<CategoryDTO> findAllCategories(){
        Collection<Category> categories =  categoryRepository.findAll();
        log.info("CATEGORY-FIND-COLLECTION: Se buscaron todas las categor??as");
        return mapCollectionCategoryToCategoryDTO(categories);
    }

    /*-------------------------------------------Mapping Collection-------------------------------------------*/

    public Collection<CategoryDTO> mapCollectionCategoryToCategoryDTO(Collection<Category> categories){
        log.info(Log.formatLog("CATEGORY-SERVICE-FINDING", "Buscando todas las categories"));
        Collection<CategoryDTO> categoriesDTO = new ArrayList<>();
        Map<Long, Image> images = imageService.getImagesByIds(getAllIdsImages(categories));
        for(Category category : categories){
            CategoryDTO categoryDTO = category.mapToCategoryDTO();
            categoryDTO.setImage(images.get(category.getImageId()));
            categoriesDTO.add(categoryDTO);
        }
        log.info(Log.formatLog("CATEGORY-SERVICE-SUCCESS", "Todas las categories han sido obtenidas"));
        return categoriesDTO;
    }

    /*-------------------------------------------Mapping Object-------------------------------------------*/

    public CategoryDTO setImageToDTO(Category category){
        Image image = imageService.getImage(category.getImageId());
        CategoryDTO categoryDTO = category.mapToCategoryDTO();
        categoryDTO.setImage(image);
        return categoryDTO;
    }

    /*-------------------------------------------Map Collection-------------------------------------------*/

    public Collection<Long> getAllIdsImages(Collection<Category> categories){
        Collection<Long> imagesIds = new ArrayList<>();
        for(Category category : categories){
            imagesIds.add(category.getImageId());
        }
        return imagesIds;
    }

    /*-------------------------------------------Check and Security Data-------------------------------------------*/

    /*-------------------------------------------Check Category Image-------------------------------------------*/

    public void checkCategoryImage(CategoryDTO category){
        Image imageCategory = category.getImage();
        Image image = new Image();
        // Check existence and get from service
        if(imageCategory.getId() != null) image = imageService.getImage(imageCategory.getId());
        // Check if the image should be saved, because have title and urlImage but not id
        if(image.getId() == null && imageCategory.getTitle() != null && imageCategory.getUrlImage() != null) image = imageService.saveImage(imageCategory);
        category.setImage(image);
    }

    /*-------------------------------------------Check Category Existence By Id-------------------------------------------*/

    public Boolean checkExistenceCategoryById(Long id) throws ResourceNotFound {
        Optional<Category> categoryResponse = categoryRepository.findById(id);
        if(categoryResponse.isEmpty()){
            throw new ResourceNotFound("No se encontr?? categor??a con id "+ id);
        }else {
            return true;
        }
    }
}