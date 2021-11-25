package com.digital_booking.api_products.model;

import com.digital_booking.api_products.dto.BookingDTO;
import com.digital_booking.api_products.dto.ProductDTO;
import com.digital_booking.api_products.vo.Category;
import com.digital_booking.api_products.vo.City;
import com.digital_booking.api_products.vo.Image;
import com.digital_booking.api_products.vo.Specs;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "products")
@Getter @Setter
@ToString
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

    @OneToMany( mappedBy = "product", cascade = CascadeType.ALL)
    @Column( name = "bookings_ids")
    @JsonIgnoreProperties("product")
    private Collection<Booking> bookings;

    @ElementCollection
    @Column(name = "images_ids")
    private Collection<Long> imagesIds = new ArrayList<>();

    /*Map the Product to DTO class receiving attributes like args*/
    public ProductDTO mapProductDTO(Image mainImage, Category category, City city, Specs specs, Collection<Image> images, Collection<BookingDTO> bookings){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(this.id);
        productDTO.setName(this.name);
        productDTO.setDescription(this.description);
        productDTO.setMainImage(mainImage);
        productDTO.setCategory(category);
        productDTO.setCity(city);
        productDTO.setSpecs(specs);
        productDTO.setImages(images);
        productDTO.setBookings(bookings);
        return productDTO;
    }
}
