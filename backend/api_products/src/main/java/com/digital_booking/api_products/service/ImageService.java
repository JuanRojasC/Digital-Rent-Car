package com.digital_booking.api_products.service;

import com.digital_booking.api_products.cache.CacheImages;
import com.digital_booking.api_products.feignclients.ImageFeignClient;
import com.digital_booking.api_products.vo.Image;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    /*-------------------------------------------Save Images Collection-------------------------------------------*/

    public Collection<Image> saveImagesCollection(Collection<Image> images){
        try{
            Collection<Image> imagesResponse = imageFeignClient.saveImagesCollection(images);
            Collection<Long> ids = new ArrayList<>();
            for(Image img : imagesResponse){
                ids.add(img.getId());
            }
            log.info("IMAGES-API-SAVE: imagenes con ids " + ids + " guardadas");
            return imagesResponse;
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

    /*-------------------------------------------Find All-------------------------------------------*/

    public Map<Long, Image> getAllImages(){
        try{
            Collection<Image> images = imageFeignClient.findAllImages();
            Map<Long, Image> imagesMap = new HashMap<>();
            for(Image image : images){
                imagesMap.put(image.getId(), image);
            }
            log.info("IMAGES-SERVICE-FIND-COLLECTION SUCCESS: Todas las imagenes han sido obtenidas");
            return imagesMap;
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

    public Collection<Image> getImagesByIdsCollection(Collection<Long> ids){
        try{
            Map<Long, Image> images = cacheImages.checkCacheForImages(ids);
            Collection<Image> imagesResponse = new ArrayList<>();
            for (Image image : images.values()) {
                imagesResponse.add(image);
            }
            log.info("IMAGES-SERVICE-FIND-COLLECTION SUCCESS: imagenes con ids " + ids +" obtenidas");
            return imagesResponse;
        }catch (Exception e){
            log.error("IMAGES-SERVICE FALLO: " + e.getMessage());
            return null;
        }
    }

    /*-------------------------------------------Delete All By Id-------------------------------------------*/

    public Boolean deleteAllImagesById(Collection<Long> ids){
        try{
            imageFeignClient.deleteImagesByIds(ids);
            log.info("IMAGES-SERVICE-DELETE-COLLECTION SUCCESS: imagenes con ids " + ids +" eliminadas");
            return true;
        }catch (Exception e){
            log.error("IMAGES-SERVICE FALLO: " + e.getMessage());
            return false;
        }
    }
}
