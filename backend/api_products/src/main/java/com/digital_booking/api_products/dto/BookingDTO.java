package com.digital_booking.api_products.dto;

import com.digital_booking.api_products.model.Booking;
import com.digital_booking.api_products.vo.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

import java.util.Date;

@Data
@ToString
public class BookingDTO implements Serializable {

    private Long id;
    private Date timeBooking;
    private Date startTime;
    private Date finishTime;
    private User user;

    @JsonIgnoreProperties("bookings")
    private ProductDTO product;

    /*Map the DTO to Booking class*/
    public Booking mapBooking(){
        Booking booking = new Booking();
        booking.setId(this.id);
        booking.setTimeBooking(this.timeBooking);
        booking.setStartTime(this.startTime);
        booking.setFinishTime(this.finishTime);
        booking.setUserId(this.user != null? this.user.getId() : null);
        booking.setProduct(this.product != null? this.product.mapProduct() : null);
        return booking;
    }

}
