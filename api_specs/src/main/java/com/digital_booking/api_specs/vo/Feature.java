package com.digital_booking.api_specs.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Feature implements Serializable {

    private Long id;
    private String name;
    private String value;
    private Image icon;

}
