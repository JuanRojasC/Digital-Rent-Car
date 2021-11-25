package com.digital_booking.api_products.service;

import com.digital_booking.api_products.cache.CacheImages;
import com.digital_booking.api_products.feignclients.ImageFeignClient;
import com.digital_booking.api_products.util.Log;
import com.digital_booking.api_products.vo.Image;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    /*-------------------------------------------Save Images Collection-------------------------------------------*/

    public Collection<Image> saveImagesCollection(Collection<Image> images){
        try{
            log.info(Log.formatLog("IMAGES-SERVICE-SAVING", "Guardando coleccion de imagenes"));
            Collection<Image> imagesResponse = imageFeignClient.saveImagesCollection(images);
            Collection<Long> ids = new ArrayList<>();
            for(Image img : imagesResponse){
                ids.add(img.getId());
            }
            log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS", "Imagenes con ids " + ids + " guardadas"));
            return imagesResponse;
        }catch (Exception e){
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

    /*-------------------------------------------Find All-------------------------------------------*/

    public Map<Long, Image> getAllImages(){
        try{
            log.info(Log.formatLog("IMAGES-SERVICE-FINDING", "Buscando todas las imagenes"));
            Collection<Image> images = imageFeignClient.findAllImages();
            Map<Long, Image> imagesMap = new HashMap<>();
            for(Image image : images){
                imagesMap.put(image.getId(), image);
            }
            log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS", "Todas las imagenes han sido obtenidas"));
            return imagesMap;
        }catch (Exception e){
            log.info(Log.formatLog("**IMAGES-SERVICE-FAIL**", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Map<Long, Image> getImagesByIds(Collection<Long> ids){
        try{
            log.info(Log.formatLog("IMAGES-SERVICE-FINDING", "Buscando imagenenes con ids " + ids));
            Map<Long, Image> images = cacheImages.checkCacheForImages(ids);
            log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS", "Imagenes con ids " + ids +" obtenidas"));
            return images;
        }catch (Exception e){
            log.info(Log.formatLog("**IMAGES-SERVICE-FAIL**", e.getMessage()));
            return null;
        }
    }

    public Collection<Image> getImagesByIdsCollection(Collection<Long> ids){
        try{
            log.info(Log.formatLog("IMAGES-SERVICE-FINDING", "Buscando imagenenes con ids " + ids));
            Map<Long, Image> images = cacheImages.checkCacheForImages(ids);
            Collection<Image> imagesResponse = new ArrayList<>();
            for (Image image : images.values()) {
                imagesResponse.add(image);
            }
            log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS", "Imagenes con ids " + ids +" obtenidas"));
            return imagesResponse;
        }catch (Exception e){
            log.info(Log.formatLog("**IMAGES-SERVICE-FAIL**", e.getMessage()));
            return null;
        }
    }

    /*-------------------------------------------Delete All By Id-------------------------------------------*/

    public Boolean deleteAllImagesById(Collection<Long> ids){
        try{
            log.info(Log.formatLog("IMAGES-SERVICE-DELETING", "Eliminando imagenenes con ids " + ids));
            imageFeignClient.deleteImagesByIds(ids);
            log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS", "Imagenes con ids " + ids +" eliminadas"));
            return true;
        }catch (Exception e){
            log.info(Log.formatLog("**IMAGES-SERVICE-FAIL**", e.getMessage()));
            return false;
        }
    }
}
