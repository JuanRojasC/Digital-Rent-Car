package com.digital_booking.api_products.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

@Data
public class Specs {

    private Long id;
    private Feature enginePower;
    private Feature airConditioning;
    private Feature seats;
    private Feature combustible;

    public Collection<Feature> collectFeatures(){
        ArrayList<Feature> features = new ArrayList<>();
        features.add(this.enginePower);
        features.add(this.airConditioning);
        features.add(this.seats);
        features.add(this.combustible);
        return features;
    }
}
