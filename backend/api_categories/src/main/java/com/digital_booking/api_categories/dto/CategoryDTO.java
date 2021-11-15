package com.digital_booking.api_categories.dto;

import com.digital_booking.api_categories.model.Category;
import com.digital_booking.api_categories.vo.Image;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDTO implements Serializable {

    private Long id;
    private String title;
    private String description;
    private Image image;

    /*Map the DTO to Category class*/
    public Category mapToCategory(){
        Category category = new Category();
        category.setId(this.id);
        category.setTitle(this.title);
        category.setDescription(this.description);
        category.setImageId(this.image.getId());
        return category;
    }
}
