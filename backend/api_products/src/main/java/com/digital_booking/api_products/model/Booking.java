package com.digital_booking.api_products.model;

import com.digital_booking.api_products.dto.BookingDTO;
import com.digital_booking.api_products.dto.ProductDTO;
import com.digital_booking.api_products.vo.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="bookings")
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="time_booking", nullable = false)
    @NotNull
    private Date timeBooking;

    @Column(name ="start_time", nullable = false)
    @NotNull
    private Date startTime;

    @Column(name ="finish_time", nullable = false)
    @NotNull
    private Date finishTime;

    @Column(name="user_id", nullable = false)
    private Long userId;

    @ManyToOne
    @JsonIgnoreProperties("bookings")
    private Product product;

    /*Map the Booking to DTO class*/
    public BookingDTO mapBookingDTO(ProductDTO product){
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setId(this.id);
        bookingDTO.setTimeBooking(this.timeBooking);
        bookingDTO.setStartTime(this.startTime);
        bookingDTO.setFinishTime(this.finishTime);
        bookingDTO.setUser(new User(this.userId));
        bookingDTO.setProduct(product);
        return bookingDTO;
    }
}
