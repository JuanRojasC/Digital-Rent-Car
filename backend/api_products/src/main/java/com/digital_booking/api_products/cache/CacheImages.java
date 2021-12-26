package com.digital_booking.api_products.cache;

import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.feignclients.ImageFeignClient;
import com.digital_booking.api_products.util.Log;
import com.digital_booking.api_products.vo.Image;
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
//        Long ids[] = {16L,17L,18L,19L,20L,21L,22L,23L,24L,25L,26L,27L,28L,29L,30L,31L,32L,33L,34L,35L,36L,37L,38L,39L,40L,41L,42L,43L,44L,45L,46L,47L,48L,49L,50L,51L,52L,53L,54L,55L,56L,57L,58L,59L,60L,61L,62L,63L,64L,65L,66L,67L,68L,69L,70L,71L,72L,73L,74L,75L,76L,77L,78L,79L,80L,81L,82L,83L,84L};
        Long ids[] = {};
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
        log.info(Log.formatLog("IMAGES-CACHE MEMORY", "Buscando images con ids " + Arrays.asList(ids)));
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
        log.info(Log.formatLog("IMAGES-CACHE MEMORY", "Images con ids " + Arrays.asList(ids) + " obtenidas"));
        return images;
    }

    public Image checkCacheForImage(Long id) throws ResourceNotFound {
        Image image = this.cacheImages.get(id);
        if(image == null){
            image = imageFeignClient.findImageById(id);
            if(image != null) {
                this.cacheImages.put(image.getId(), image);
                log.info(Log.formatLog("IMAGES-CACHE MEMORY", "Image con id " + Arrays.asList(id) + " obtenida"));
            }
        }
        return image;
    }
}
