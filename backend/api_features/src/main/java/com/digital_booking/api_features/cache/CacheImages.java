package com.digital_booking.api_features.cache;

import com.digital_booking.api_features.exceptions.ResourceNotFound;
import com.digital_booking.api_features.feignclients.ImageFeignClient;
import com.digital_booking.api_features.util.Log;
import com.digital_booking.api_features.vo.Image;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.*;

@Log4j
@Component
public class CacheImages {

    private static CacheImages instance = null;

    @Autowired
    private ImageFeignClient imageFeignClient;
    private Map<Long, Image> cacheImages = new HashMap<>();

    private CacheImages(){
    }

    public static CacheImages getInstance() {
        if(instance == null){
            instance = new CacheImages();
        }
        return instance;
    }

    /*-------------------------------------------Post Construct-------------------------------------------*/

    @PostConstruct
    public void startCacheForImages(){
        Long ids[] = {5L, 6L, 7L, 8L, 9L};
        Collection<Image> imagesResponse = imageFeignClient.findImagesByIds(List.of(ids));
        log.info(Log.formatLog("IMAGES-CACHE MEMORY", "Se guardaron las imagenes con ids: " + Arrays.asList(ids)));
        Map<Long, Image> images = new HashMap<>();
        for(Image image : imagesResponse){
            images.put(image.getId(), image);
        }
        this.cacheImages = images;
    }

    /*-------------------------------------------Methods-------------------------------------------*/

    public Map<Long, Image> checkCacheForImages(Collection<Long> ids) throws ResourceNotFound {
        Map<Long, Image> images = new HashMap<>();
        log.info(Log.formatLog("IMAGES-CACHE MEMORY", "Buscando images con ids " + ids));
        for(Long id : ids){
            Image image = this.cacheImages.get(id);
            if(image == null) {
                image = imageFeignClient.findImageById(id);
                image = image.getId() != null? image : null;
                if(image != null){
                    this.cacheImages.put(image.getId(), image);
                }
            }
            images.put(image.getId(), image);
        }
        log.info(Log.formatLog("IMAGES-CACHE MEMORY", "Images con ids " + ids + " obtenidas"));
        return images;
    }

    public Image checkCacheForImage(Long id) throws ResourceNotFound {
        Image image = this.cacheImages.get(id);
        if(image == null){
            image = imageFeignClient.findImageById(id);
            if(image != null) {
                this.cacheImages.put(image.getId(), image);
                log.info(Log.formatLog("IMAGES-CACHE MEMORY", "Image con id " + id + " obtenida"));
            }
        }
        return image;
    }
}
