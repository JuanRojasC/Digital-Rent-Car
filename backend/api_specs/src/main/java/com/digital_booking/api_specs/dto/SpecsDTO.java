package com.digital_booking.api_specs.dto;

import com.digital_booking.api_specs.model.Specs;
import com.digital_booking.api_specs.service.FeatureService;
import com.digital_booking.api_specs.vo.Feature;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class SpecsDTO implements Serializable {

    private Long id;
    private Feature enginePower;
    private Feature airConditioning;
    private Feature seats;
    private Feature combustible;

    /*Map the DTO to Specs class*/
    public Specs mapSpecs(){
        Specs specs = new Specs();
        specs.setId(this.id);
        specs.setEnginePower(this.enginePower.getId());
        specs.setAirConditioning(this.airConditioning.getId());
        specs.setSeats(this.seats.getId());
        specs.setCombustible(this.combustible.getId());
        return specs;
    }

    /*Group all features in class like a collection*/
    public Collection<Feature> collectFeatures(){
        ArrayList<Feature> features = new ArrayList<>();
        features.add(this.enginePower);
        features.add(this.airConditioning);
        features.add(this.seats);
        features.add(this.combustible);
        return features;
    }

    /*In base to name features assign the feature in a collection to the attribute in class*/
    public void assignFeatures(Collection<Feature> features){
        for(Feature feature : features){
            switch (feature.getName()){
                case "enginePower":
                    this.enginePower = feature;
                    break;
                case "airConditioning":
                    this.airConditioning = feature;
                    break;
                case "seats":
                    this.seats = feature;
                    break;
                case "combustible":
                    this.combustible = feature;
                    break;
                default:
                    break;
            }
        }
    }

}
