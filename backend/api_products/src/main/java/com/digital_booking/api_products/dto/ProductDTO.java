package com.digital_booking.api_products.dto;

import com.digital_booking.api_products.model.Booking;
import com.digital_booking.api_products.model.Product;
import com.digital_booking.api_products.vo.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Data
@ToString
public class ProductDTO implements Serializable {

    private Long id;
    private String name;
    private String description;
    private Image mainImage;
    private Category category;
    private City city;
    private Specs specs;
    private Collection<Image> images = new ArrayList<>();

    @JsonIgnoreProperties({"product", "user", "id", "timeBooking"})
    private Collection<BookingDTO> bookings;

    /*Map the DTO to Product class*/
    public Product mapProduct(){
        /*Get the id of each image for the model class*/
        Collection<Long> imagesIds = new ArrayList<>();
        for(Image i : this.images) imagesIds.add(i.getId());

        /*Convert each one bookingDTO to model class Booking for be saved in product model class*/
        Collection<Booking> bookings = new ArrayList<>();
        for(BookingDTO b : this.bookings) bookings.add(b.mapBooking());

        /*Set all attributes of model class*/
        Product product = new Product();
        product.setId(this.id != null? this.id : null);
        product.setName(this.name != null? this.name  : null);
        product.setDescription(this.description != null? this.description : null);
        product.setMainImageId(this.mainImage != null? this.mainImage.getId() : null);
        product.setCategoryId(this.category != null? this.category.getId() : null);
        product.setCityId(this.city != null? this.city.getId() : null);
        product.setSpecsId(this.specs != null? this.specs.getId() : null);
        product.setImagesIds(imagesIds);
        product.setBookings(bookings);

        /*return the model class*/
        return product;
    }
}
