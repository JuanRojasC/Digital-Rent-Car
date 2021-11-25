package com.digital_booking.gateway_service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String password;

}
