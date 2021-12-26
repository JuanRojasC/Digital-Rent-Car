package com.digital_booking.api_images.controller;


import com.digital_booking.api_images.entity.Image;
import com.digital_booking.api_images.exceptions.ResourceNotFound;
import com.digital_booking.api_images.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/images")
public class ImageController {

    private ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    //POST REQUEST
    @PostMapping("/save/new")
    public ResponseEntity<Image> saveImage(@RequestBody Image i){
        Image image = imageService.saveImage(i);
        return ResponseEntity.status(HttpStatus.OK).body(image);
    }
    @PostMapping("/save/collection")
    public ResponseEntity<?> saveImagesCollection(@RequestBody Collection<Image> i){
        Collection<Image> images = imageService.saveImagesCollection(i);
        return ResponseEntity.status(HttpStatus.OK).body(images);
    }
    /*Get Images for each id in list*/
    @PostMapping("/find/ids")
    public ResponseEntity<?> findImagesByIds(@RequestBody Collection<Long> imagesId){
        Collection<Image> images = imageService.findAllImagesById(imagesId);
        return ResponseEntity.status(HttpStatus.OK).body(images);
    }
    /*Delete Images for each id in list*/
    @PostMapping("/delete/ids")
    public ResponseEntity<?> deleteImagesByIds(@RequestBody Collection<Long> ids) throws ResourceNotFound {
        imageService.deleteAllImagesById(ids);
        return ResponseEntity.status(HttpStatus.OK).body("Todas las imagenes han sido eliminadas");
    }

    /*------------------------------------------------------------------------------------------------------*/

    //GET REQUEST
    @GetMapping("/find/all")
    public ResponseEntity<?>findAllImages(){
        return ResponseEntity.ok(imageService.findAllImages());
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?>findImageById(@PathVariable Long id) throws ResourceNotFound{
        Image image = imageService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(image);
    }

    /*------------------------------------------------------------------------------------------------------*/

    //PUT REQUEST
    @PutMapping("/update/image")
    public ResponseEntity<?>editImage(@RequestBody Image i) throws ResourceNotFound{
        imageService.updateImage(i);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*------------------------------------------------------------------------------------------------------*/

    //DELETE REQUEST
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteImage(@PathVariable Long id) throws ResourceNotFound{
        imageService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Imagen Eliminada");
    }
}
