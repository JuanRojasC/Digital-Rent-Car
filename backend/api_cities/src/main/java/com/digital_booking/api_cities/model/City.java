package com.digital_booking.api_cities.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name= "cities")
@Getter @Setter
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="city_id")
    private Long id;

    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "latitude", nullable = false, precision = 11, scale = 7 )
    @NotNull
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = false, precision = 11, scale = 7 )
    @NotNull
    private BigDecimal longitude;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "country_id")
    private Country country;
}
