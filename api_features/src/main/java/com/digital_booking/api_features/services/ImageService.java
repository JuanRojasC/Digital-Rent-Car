package com.digital_booking.api_features.services;

import com.digital_booking.api_features.feignclients.ImageFeignClient;
import com.digital_booking.api_features.vo.Image;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

@Log4j
@Service
public class ImageService {

    private ImageFeignClient imageFeignClient;

    @Autowired
    public ImageService(ImageFeignClient imageFeignClient) {
        this.imageFeignClient = imageFeignClient;
    }

    public Image saveImage(Image image){
        try{
            Image imageResponse= imageFeignClient.saveImage(image);
            log.info("IMAGES-API: imagen " + image.getTitle() + " guardada");
            return imageResponse;
        }catch (Exception e){
            log.error("IMAGES-API FALLO: " + e.getMessage());
            return null;
        }
    }

    public Image getImage(Long id){
        try{
            Image image = imageFeignClient.findImageById(id);
            log.info("IMAGES-SERVICE SUCCESS: imagen " + image.getTitle() + " obtenida");
            return image;
        }catch (Exception e){
            log.error("IMAGES-SERVICE FALLO: " + e.getMessage());
            return null;
        }
    }

    public Collection<Image> getImagesByIds(Collection<Long> ids){
        try{
            Collection<Image> images = imageFeignClient.findImagesByIds(ids);
            log.info("IMAGES-SERVICE SUCCESS: imagenes con ids " + ids +" obtenidas");
            return images;
        }catch (Exception e){
            log.error("IMAGES-SERVICE FALLO: " + e.getMessage());
            return null;
        }
    }
}
