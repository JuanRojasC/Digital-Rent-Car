package com.digital_booking.api_products.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class City {

    private Long id;
    private String name;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Country country;
}
