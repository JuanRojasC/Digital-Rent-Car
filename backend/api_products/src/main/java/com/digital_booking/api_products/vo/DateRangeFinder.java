package com.digital_booking.api_products.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class DateRangeFinder implements Serializable {

    private Date checkIn;
    private Date checkOut;
    private Long cityId;

}
