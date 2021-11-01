package com.digital_booking.categorias.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name ="categories")
@Getter @Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_sequence")
    @SequenceGenerator(name="category_sequence", sequenceName = "category_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "title", nullable = false)
    @NotNull
    private String title;

    @Column(name = "description", columnDefinition = "text", nullable = false)
    @NotNull
    private String description;

    @Column(name="url_image")
    private String urlImage;
}
