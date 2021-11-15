package com.digital_booking.api_products.feignclients;

import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.vo.Image;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "images-service", url = "http://localhost:9005")
@RequestMapping("/images")
public interface ImageFeignClient {

    @GetMapping("/find/{id}")
    Image findImageById(@PathVariable Long id) throws ResourceNotFound;

    @GetMapping("/find/all")
    Collection<Image> findAllImages();

    @PostMapping("/save/new")
    Image saveImage(@RequestBody Image i);

    @PostMapping("/save/collection")
    Collection<Image> saveImagesCollection(@RequestBody Collection<Image> i);

    @PostMapping("/find/ids")
    Collection<Image> findImagesByIds(@RequestBody Collection<Long> imagesId);

    @PostMapping("/delete/ids")
    void deleteImagesByIds(@RequestBody Collection<Long> ids) throws ResourceNotFound;

}
