package com.digital_booking.api_images.services;

import com.digital_booking.api_images.entity.Image;
import com.digital_booking.api_images.exceptions.ResourceNotFound;
import com.digital_booking.api_images.repository.IImageRepository;
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
        i.setId(null);
        Image image = imageRepository.save(i);
        log.info("Se guardo la imagen con titulo: " + image.getTitle());
        return image;
    }

    /*-------------------------------------------Save Images Collection-------------------------------------------*/

    public Collection<Image> saveImagesCollection(Collection<Image> images){
        for(Image i : images){
            i.setId(null);
        }
        Collection<Image> imagesResponse = imageRepository.saveAll(images);
        log.info("Se guardo coleccion con " + images.size() + " imagenes");
        return imagesResponse;
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public Image findById(Long id) throws ResourceNotFound{
        Optional<Image> image = imageRepository.findById(id);
        if (image.isEmpty()){
            throw new ResourceNotFound("No se encontro la imagen con id: " + id);
        }else{
            log.info("Se busco la imagen con id: " + id);
            return image.get();
        }
    }

    /*-------------------------------------------Update Image-------------------------------------------*/

    public void updateImage(Image image) throws ResourceNotFound{
        findById(image.getId());
        imageRepository.save(image);
        log.info("Se actualizó la imagen con id: " + image.getId());
    }

    /*-------------------------------------------Delete By Id-------------------------------------------*/

    public void deleteById(Long id) throws ResourceNotFound{
        Image image = findById(id);
        log.info("Se elimino la imagen con id: " + image.getId());
        imageRepository.deleteById(id);
    }

    /*-------------------------------------------Delete All By Id-------------------------------------------*/

    public void deleteAllImagesById(Collection<Long> ids) throws ResourceNotFound {
        try {
            imageRepository.deleteAllById(ids);
        }catch (Exception e){
            String id = e.getMessage().replaceAll("\\D+", "");
            throw new ResourceNotFound("ERROR 404: No se encontro la imagen con id " + id + "\n           " + "Verifique los ids enviados");
        }
        log.info("Se eliminaron las imagenes con ids: " + ids);
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<Image>findAllImages(){
        log.info("Se buscaron todas las imagenes");
        return imageRepository.findAll();
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Collection<Image> findAllImagesById(Collection<Long> ids){
        log.info("Se buscaron las imagenes con ids: " + ids);
        return imageRepository.findAllById(ids);
    }

}
