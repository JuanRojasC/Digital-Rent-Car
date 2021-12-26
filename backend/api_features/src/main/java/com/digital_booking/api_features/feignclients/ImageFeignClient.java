package com.digital_booking.api_features.feignclients;

import com.digital_booking.api_features.exceptions.ResourceNotFound;
import com.digital_booking.api_features.vo.Image;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@FeignClient(name = "images-service")
@RequestMapping("/images")
public interface ImageFeignClient {

    @GetMapping("/find/{id}")
    Image findImageById(@PathVariable Long id) throws ResourceNotFound;

    @PostMapping("/save/new")
    Image saveImage(@RequestBody Image i);

    @PostMapping("/find/ids")
    Collection<Image> findImagesByIds(@RequestBody Collection<Long> imagesId);

}
