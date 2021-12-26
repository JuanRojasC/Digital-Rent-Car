package com.digital_booking.api_features.services;

import com.digital_booking.api_features.cache.CacheImages;
import com.digital_booking.api_features.feignclients.ImageFeignClient;
import com.digital_booking.api_features.util.Log;
import com.digital_booking.api_features.vo.Image;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
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
            log.info(Log.formatLog("IMAGES-SERVICE-SAVING", "Guardando nueva imagen"));
            Image imageResponse= imageFeignClient.saveImage(image);
            log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS", "Imagen con id " + image.getId() + " guardada"));
            return imageResponse;
        }catch (Exception e){
            log.error("**IMAGES-SERVICE-FAIL**: " + e.getMessage());
            log.info(Log.formatLog("**IMAGES-SERVICE-FAIL**", e.getMessage()));
            return null;
        }
    }


    /*-------------------------------------------Find By Id-------------------------------------------*/

    public Image getImage(Long id){
        try{
            log.info(Log.formatLog("IMAGES-SERVICE-FINDING", "Buscando imagen con id " + id));
            Image image = cacheImages.checkCacheForImage(id);
            log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS", "Imagen con id " + id + "encontrada"));
            return image;
        }catch (Exception e){
            log.info(Log.formatLog("**IMAGES-SERVICE-FAIL**", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Collection<Image> getImagesByIds(Collection<Long> ids){
        try{
            log.info(Log.formatLog("IMAGES-SERVICE-FINDING", "Buscando imagenenes con ids " + ids));
            Map<Long, Image> images = cacheImages.checkCacheForImages(ids);
            Collection<Image> imagesResponse = new ArrayList<>();
            log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS", "Imagenes con ids " + ids +" obtenidas"));
            for (Image image : images.values()) {
                imagesResponse.add(image);
            }
            log.info("IMAGES-SERVICE-FIND-COLLECTION SUCCESS: imagenes con ids " + ids +" obtenidas");
            return imagesResponse;
        }catch (Exception e){
            log.info(Log.formatLog("**IMAGES-SERVICE-FAIL**", e.getMessage()));
            return null;
        }
    }

}
