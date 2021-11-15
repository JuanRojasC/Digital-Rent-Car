package com.digital_booking.api_categories.feignclients;

import com.digital_booking.api_categories.exceptions.ResourceNotFound;
import com.digital_booking.api_categories.vo.Image;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "images-service", url = "http://localhost:9005")
@RequestMapping("/images")
public interface ImageFeignClient {

    @GetMapping("/find/{id}")
    Image findImageById(@PathVariable Long id) throws ResourceNotFound;

    @PostMapping("/save/new")
    Image saveImage(@RequestBody Image i);

    @PostMapping("/find/ids")
    Collection<Image> findImagesByIds(@RequestBody Collection<Long> imagesId);

}
