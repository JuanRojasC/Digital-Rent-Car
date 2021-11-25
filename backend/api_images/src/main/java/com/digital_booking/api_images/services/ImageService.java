package com.digital_booking.api_images.services;

import com.digital_booking.api_images.entity.Image;
import com.digital_booking.api_images.exceptions.ResourceNotFound;
import com.digital_booking.api_images.repository.IImageRepository;
import com.digital_booking.api_images.util.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log4j
@Service
public class ImageService {

    private IImageRepository imageRepository;

    @Autowired
    public ImageService(IImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    /*-------------------------------------------Save Image-------------------------------------------*/

    public Image saveImage(Image i){
        log.info(Log.formatLog("IMAGES-SERVICE-SAVING", "Guardando nueva imagen"));
        i.setId(null);
        Image image = imageRepository.save(i);
        log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS ✓✓", "Imagen con id " + image.getId() + " guardada"));
        return image;
    }

    /*-------------------------------------------Save Images Collection-------------------------------------------*/

    public Collection<Image> saveImagesCollection(Collection<Image> images){
        log.info(Log.formatLog("IMAGES-SERVICE-SAVING", "Guardando coleccion de imagenes"));
        for(Image i : images){
            i.setId(null);
        }
        Collection<Image> imagesResponse = imageRepository.saveAll(images);
        log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS ✓✓", "Coleccion con " + images.size() + " imagenes guardadas"));
        return imagesResponse;
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public Image findById(Long id) throws ResourceNotFound{
        log.info(Log.formatLog("IMAGES-SERVICE-FINDING", "Buscando imagen con id " + id));
        Optional<Image> image = imageRepository.findById(id);
        if (image.isEmpty()){
            throw new ResourceNotFound("No se encontro la imagen con id: " + id);
        }else{
            log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS ✓✓", "Imagen con id " + id + " encontrada"));
            return image.get();
        }
    }

    /*-------------------------------------------Update Image-------------------------------------------*/

    public void updateImage(Image image) throws ResourceNotFound{
        log.info(Log.formatLog("IMAGES-SERVICE-UPDATING", "Buscando imagen con id " + image.getId()));
        findById(image.getId());
        imageRepository.save(image);
        log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS ✓✓", "Imagen con id " + image.getId() + " actualizada"));
    }

    /*-------------------------------------------Delete By Id-------------------------------------------*/

    public void deleteById(Long id) throws ResourceNotFound{
        log.info(Log.formatLog("IMAGES-SERVICE-DELETING", "Eliminando imagen con id " + id));
        findById(id);
        imageRepository.deleteById(id);
        log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS ✓✓", "Imagen con id " + id +" eliminada"));
    }

    /*-------------------------------------------Delete All By Id-------------------------------------------*/

    public void deleteAllImagesById(Collection<Long> ids) throws ResourceNotFound {
        try {
            log.info(Log.formatLog("IMAGES-SERVICE-DELETING", "Eliminando imagenenes con ids " + ids));
            imageRepository.deleteAllById(ids);
        }catch (Exception e){
            String id = e.getMessage().replaceAll("\\D+", "");
            throw new ResourceNotFound("ERROR 404: No se encontro la imagen con id " + id + "\n           " + "Verifique los ids enviados");
        }
        log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS ✓✓", "Imagenes con ids " + ids +" eliminadas"));
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<Image>findAllImages(){
        log.info(Log.formatLog("IMAGES-SERVICE-FINDING", "Buscando todas las imagenes"));
        Collection<Image> images = imageRepository.findAll();
        log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS ✓✓", "Todas las imagenes han sido obtenidas"));
        return images;
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Collection<Image> findAllImagesById(Collection<Long> ids){
        log.info(Log.formatLog("IMAGES-SERVICE-FINDING", "Buscando imagenenes con ids " + ids));
        Collection<Image> images = imageRepository.findAllById(ids);
        log.info(Log.formatLog("IMAGES-SERVICE-SUCCESS ✓✓", "Imagenes con ids " + ids +" obtenidas"));
        return images;
    }

}
