package com.digital_booking.api_products.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "terms_and_conditions")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TermAndCondition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column
    private Long iconId;

}
