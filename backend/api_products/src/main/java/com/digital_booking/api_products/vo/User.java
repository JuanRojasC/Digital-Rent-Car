package com.digital_booking.api_products.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;

    public User(Long id) {
        this.id = id;
    }
}
