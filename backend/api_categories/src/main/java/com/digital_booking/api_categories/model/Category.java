package com.digital_booking.api_categories.model;

import com.digital_booking.api_categories.dto.CategoryDTO;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="categories")
@Getter @Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    @NotNull
    private String title;

    @Column(name = "description", columnDefinition = "text", nullable = false)
    @NotNull
    private String description;

    @Column(name="image_id")
    private Long imageId;

    /*Map the DTO to Category class*/
    public CategoryDTO mapToCategoryDTO(){
        CategoryDTO category = new CategoryDTO();
        category.setId(this.id);
        category.setTitle(this.title);
        category.setDescription(this.description);
        category.setImage(null);
        return category;
    }
}
