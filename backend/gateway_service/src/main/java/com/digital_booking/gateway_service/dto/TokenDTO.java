package com.digital_booking.gateway_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TokenDTO implements Serializable {

    private Integer status;
    private String message;
    private String jwt;

}
