package com.digital_booking.api_features.entity;

import com.digital_booking.api_features.dto.FeatureDTO;
import com.digital_booking.api_features.vo.Image;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="features")
@Getter @Setter
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="name", nullable = false)
    @NotNull
    private String name;

    @Column(name ="value")
    private String value;

    @Column(name="image_id")
    private Long imageId;

    /*Map the Feature to DTO class icon null*/
    public FeatureDTO mapToFeatureDTO(){
        FeatureDTO feature = new FeatureDTO();
        feature.setId(this.id);
        feature.setName(this.name);
        feature.setValue(this.value);
        feature.setIcon(null);
        return feature;
    }

    /*Map the Feature to DTO class icon like a parameter*/
    public FeatureDTO mapToFeatureDTO(Image image){
        FeatureDTO feature = new FeatureDTO();
        feature.setId(this.id);
        feature.setName(this.name);
        feature.setValue(this.value);
        feature.setIcon(image);
        return feature;
    }

}
