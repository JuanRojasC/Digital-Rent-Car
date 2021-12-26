package com.digital_booking.api_cities.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "countries")
@Getter @Setter
public class Country implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="country_id")
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @JsonIgnore
    @OneToMany(targetEntity = City.class, mappedBy = "country", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Collection<City> citiesCollection;
}
