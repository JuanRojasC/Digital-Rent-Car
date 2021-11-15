package com.digital_booking.api_products.model;

import com.digital_booking.api_products.dto.ProductDTO;
import com.digital_booking.api_products.vo.Category;
import com.digital_booking.api_products.vo.City;
import com.digital_booking.api_products.vo.Image;
import com.digital_booking.api_products.vo.Specs;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "products")
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false, columnDefinition = "text")
    private String description;

    @Column(name = "main_image_id")
    private Long mainImageId;

    @Column(name = "category_id")
    private Long categoryId;

    @Column(name = "city_id")
    private Long cityId;

    @Column( name = "specs_id")
    private  Long specsId;

    @ElementCollection
    @Column(name = "images_ids")
    private Collection<Long> imagesIds = new ArrayList<>();

    /*Map the Product to DTO class*/
    public ProductDTO mapProductDTO(){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(this.id);
        productDTO.setName(this.name);
        productDTO.setDescription(this.description);
        productDTO.setMainImage(null);
        productDTO.setCategory(null);
        productDTO.setCity(null);
        productDTO.setSpecs(null);
        productDTO.setImages(null);
        return productDTO;
    }

    /*Map the Product to DTO class receiving attributes like args*/
    public ProductDTO mapProductDTO(Image mainImage, Category category, City city, Specs specs, Collection<Image> images){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(this.id);
        productDTO.setName(this.name);
        productDTO.setDescription(this.description);
        productDTO.setMainImage(mainImage);
        productDTO.setCategory(category);
        productDTO.setCity(city);
        productDTO.setSpecs(specs);
        productDTO.setImages(images);
        return productDTO;
    }
}
