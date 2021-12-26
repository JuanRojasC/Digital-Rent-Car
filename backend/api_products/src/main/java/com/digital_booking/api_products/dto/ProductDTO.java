package com.digital_booking.api_products.dto;

import com.digital_booking.api_products.model.Booking;
import com.digital_booking.api_products.model.Product;
import com.digital_booking.api_products.model.TermAndCondition;
import com.digital_booking.api_products.vo.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Category category;
    private City city;
    private Specs specs;
    private Collection<Image> images = new ArrayList<>();
    @JsonIgnoreProperties({"product", "user", "id", "timeBooking"})
    private Collection<BookingDTO> bookings;
    private Collection<TermAndConditionDTO> termsAndConditions;


    public Product mapProduct(){
        /*Set all attributes of model class*/
        Product product = new Product();
        product.setId(id != null? id : null);
        product.setName(name != null? name  : null);
        product.setDescription(description != null? description : null);
        product.setCategoryId(category != null? category.getId() : null);
        product.setCityId(city != null? city.getId() : null);
        product.setSpecsId(specs != null? specs.getId() : null);
        product.setImagesIds(images != null? images.stream().map(Image::getId).collect(Collectors.toList()) : new ArrayList<>());
        product.setBookings(bookings != null? bookings.stream().map(BookingDTO::mapBooking).collect(Collectors.toList()) : new ArrayList<>());
        product.setTermsAndConditions(termsAndConditions  != null? termsAndConditions.stream().map(TermAndConditionDTO::mapTermAndCondition).collect(Collectors.toList()) : new ArrayList<>());
        return product;
    }
}
