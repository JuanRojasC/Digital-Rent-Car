package com.digital_booking.api_specs.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Image implements Serializable {

    private Long id;
    private String title;
    private String urlImage;

}
