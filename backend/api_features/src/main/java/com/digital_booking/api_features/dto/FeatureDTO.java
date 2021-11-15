package com.digital_booking.api_features.dto;

import com.digital_booking.api_features.entity.Feature;
import com.digital_booking.api_features.vo.Image;
import lombok.Data;

import java.io.Serializable;

@Data
public class FeatureDTO implements Serializable {

    private Long id;
    private String name;
    private String value;
    private Image icon;

    /*Map the DTO to Feature class*/
    public Feature mapToFeature(){
        Feature feature = new Feature();
        feature.setId(this.id);
        feature.setName(this.name);
        feature.setValue(this.value);
        feature.setImageId(this.icon.getId());
        return feature;
    }

}
