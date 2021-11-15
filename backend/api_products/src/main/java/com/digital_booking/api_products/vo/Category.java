package com.digital_booking.api_products.vo;

import lombok.Data;

@Data
public class Category {

    private Long id;
    private String title;
    private String description;
    private Image image;

}
