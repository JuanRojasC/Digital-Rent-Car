package com.digital_booking.api_images.entity;


import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "images")
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    @NotNull
    private String title;

    @Column(name = "url_image", nullable = false)
    @NotNull
    private String urlImage;

}