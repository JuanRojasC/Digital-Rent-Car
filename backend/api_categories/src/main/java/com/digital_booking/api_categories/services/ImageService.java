package com.digital_booking.api_categories.services;

import com.digital_booking.api_categories.cache.CacheImages;
import com.digital_booking.api_categories.feignclients.ImageFeignClient;
import com.digital_booking.api_categories.vo.Image;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Log4j
@Service
public class ImageService {

    private ImageFeignClient imageFeignClient;
    private CacheImages cacheImages;

    @Autowired
    public ImageService(ImageFeignClient imageFeignClient, CacheImages cacheImages) {
        this.imageFeignClient = imageFeignClient;
        this.cacheImages = cacheImages;
    }

    /*-------------------------------------------Save Image-------------------------------------------*/

    public Image saveImage(Image image){
        try{
            Image imageResponse= imageFeignClient.saveImage(image);
            log.info("IMAGES-API-SAVE: imagen " + image.getTitle() + " guardada");
            return imageResponse;
        }catch (Exception e){
            log.error("IMAGES-API FALLO: " + e.getMessage());
            return null;
        }
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public Image getImage(Long id){
        try{
            Image image = cacheImages.checkCacheForImage(id);
            log.info("IMAGES-SERVICE-FIND SUCCESS: imagen " + image.getTitle() + " obtenida");
            return image;
        }catch (Exception e){
            log.error("IMAGES-SERVICE FALLO: " + e.getMessage());
            return null;
        }
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Map<Long, Image> getImagesByIds(Collection<Long> ids){
        try{
            log.info("IMAGES-SERVICE-FIND-COLLECTION SUCCESS: imagenes con ids " + ids +" obtenidas");
            return cacheImages.checkCacheForImages(ids);
        }catch (Exception e){
            log.error("IMAGES-SERVICE FALLO: " + e.getMessage());
            return null;
        }
    }
}
