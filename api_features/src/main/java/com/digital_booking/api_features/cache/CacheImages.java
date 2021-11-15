package com.digital_booking.api_features.cache;

import com.digital_booking.api_features.services.ImageService;
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
    private ImageService imageService;
    private Map<Long, Image> cacheImagesForFeatures = new HashMap<>();

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
        Collection<Image> imagesResponse = imageService.getImagesByIds(Arrays.asList(ids));
        log.info("IMAGES-CACHE MEMORY: Se guardaron las imagenes con ids: " + Arrays.asList(ids));
        Map<Long, Image> images = new HashMap<>();
        for(Image image : imagesResponse){
            images.put(image.getId(), image);
        }
        this.cacheImagesForFeatures = images;
    }

    /*-------------------------------------------Methods-------------------------------------------*/

    public Map<Long, Image> checkCacheForImages(Collection<Long> ids){
        Map<Long, Image> images = new HashMap<>();
        for(Long id : ids){
            Image image = this.cacheImagesForFeatures.get(id);
            if(image == null) {
                image = imageService.getImage(id);
                image = image.getId() != null? image : null;
                if(image != null){
                    this.cacheImagesForFeatures.put(image.getId(), image);
                }
            }
            images.put(image.getId(), image);
        }
        return images;
    }

    public Image checkCacheForImage(Long id){
        Image image = this.cacheImagesForFeatures.get(id);
        if(image == null){
            image = imageService.getImage(id);
        }
        return image;
    }
}
