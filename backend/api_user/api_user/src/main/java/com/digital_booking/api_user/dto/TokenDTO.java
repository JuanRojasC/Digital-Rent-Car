package com.digital_booking.api_user.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class TokenDTO implements Serializable {

    private Integer status;
    private String message;
    private String jwt;
    private UserDTO user;

}
