package com.digital_booking.api_specs.model;

import com.digital_booking.api_specs.dto.SpecsDTO;
import com.digital_booking.api_specs.service.FeatureService;
import com.digital_booking.api_specs.vo.Feature;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name= "specs")
@Data
public class Specs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "engine_power_feature_Id")
    private Long enginePower;

    @Column( name = "air_conditioning_feature_Id")
    private Long airConditioning;

    @Column( name = "seats_feature_Id")
    private Long seats;

    @Column( name = "combustible_feature_Id")
    private Long combustible;

    public Collection<Long> collectFeatures(){
        Collection<Long> features = new ArrayList<>();
        features.add(this.enginePower);
        features.add(this.airConditioning);
        features.add(this.seats);
        features.add(this.combustible);
        return features;
    }

    /*Map the Specs to DTO class with features all null*/
    public SpecsDTO mapSpecsDTO(){
        SpecsDTO specs = new SpecsDTO();
        specs.setId(this.id);
        return specs;
    }

    /*Map the Specs to DTO class with features like parameter*/
    public SpecsDTO mapSpecsDTO(SpecsDTO s){
        SpecsDTO specs = new SpecsDTO();
        specs.setId(this.id);
        specs.setEnginePower(s.getEnginePower());
        specs.setAirConditioning(s.getAirConditioning());
        specs.setSeats(s.getSeats());
        specs.setCombustible(s.getCombustible());
        return specs;
    }

    /*Map the Specs to DTO class with id-features map like parameter*/
    public SpecsDTO mapSpecsDTO(Map<Long, Feature> features){
        SpecsDTO specs = new SpecsDTO();
        specs.setId(this.id);
        specs.setEnginePower(features.get(this.enginePower));
        specs.setAirConditioning(features.get(this.airConditioning));
        specs.setSeats(features.get(this.seats));
        specs.setCombustible(features.get(this.combustible));
        return specs;
    }

}
