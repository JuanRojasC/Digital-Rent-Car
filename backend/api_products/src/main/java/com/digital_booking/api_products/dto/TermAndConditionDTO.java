package com.digital_booking.api_products.dto;

import com.digital_booking.api_products.model.TermAndCondition;
import com.digital_booking.api_products.vo.Image;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TermAndConditionDTO implements Serializable {

    // ATTRIBUTES
    private Long id;
    private String title;
    private String description;
    private Image icon;


    // METHODS
    public TermAndCondition mapTermAndCondition(){
        return TermAndCondition.builder()
                .id(id)
                .title(title)
                .description(description)
                .iconId(icon != null? icon.getId() : null)
                .build();
    }

}
