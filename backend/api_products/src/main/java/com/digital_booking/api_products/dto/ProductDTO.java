package com.digital_booking.api_products.dto;

import com.digital_booking.api_products.model.Product;
import com.digital_booking.api_products.vo.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Data
public class ProductDTO implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Image mainImage;
    private Category category;
    private City city;
    private Specs specs;
    private Collection<Image> images = new ArrayList<>();

    /*Map the DTO to Product class*/
    public Product mapProduct(){
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setDescription(this.description);
        product.setMainImageId(this.mainImage.getId());
        product.setCategoryId(this.category.getId());
        product.setCityId(this.city.getId());
        product.setSpecsId(this.specs.getId());
        product.setImagesIds(getAllImagesIds());
        return product;
    }

    /*Extract id of each image in imagesCollection to set in Product class*/
    private Collection<Long> getAllImagesIds(){
        Collection<Long> imagesIds = new ArrayList<>();
        for(Image i : this.images){
            imagesIds.add(i.getId());
        }
        return imagesIds;
    }
}
