package com.digital_booking.api_features.services;

import com.digital_booking.api_features.cache.CacheImages;
import com.digital_booking.api_features.dto.FeatureDTO;
import com.digital_booking.api_features.entity.Feature;
import com.digital_booking.api_features.exceptions.ResourceNotFound;
import com.digital_booking.api_features.repository.IFeatureRepository;
import com.digital_booking.api_features.vo.Image;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Log4j
@Service
public class FeatureService {

    private IFeatureRepository featureRepository;
    private ImageService imageService;
    private CacheImages cacheImages;

    @Autowired
    public FeatureService(IFeatureRepository featureRepository, ImageService imageService, CacheImages cacheImages) {
        this.featureRepository = featureRepository;
        this.imageService = imageService;
        this.cacheImages = cacheImages;
    }

    /*-------------------------------------------Save Feature-------------------------------------------*/

    public FeatureDTO saveFeature(FeatureDTO f){
        Image image = null;
        // Evita que se guarde un id no generado por la DB
        f.setId(null);
        // Guarda la imagen si no existe en la DB
        checkFeatureImage(f);
        Feature feature = featureRepository.save(f.mapToFeature());
        log.info("Se guardo feature con nombre " + feature.getName());
        return feature.mapToFeatureDTO(image);
    }

    /*-------------------------------------------Save Feature's Collection-------------------------------------------*/

    public Collection<FeatureDTO> saveFeaturesCollection(Collection<FeatureDTO> features){
        for (FeatureDTO feature : features) {
            // Evita que se guarde un id no generado por la DB
            feature.setId(null);
            // Guarda la imagen si no existe en la DB
            checkFeatureImage(feature);
        }
        Collection<Feature> featuresResponse = featureRepository.saveAll(mapCollectionFeaturesDTOToFeatures(features));
        log.info("Se guardaron las features con ids: " + getAllIdsFeatures(featuresResponse));
        return mapCollectionFeaturesToFeaturesDTO(featuresResponse);
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public FeatureDTO findById(Long id) throws ResourceNotFound {
        Optional<Feature> feature = featureRepository.findById(id);
        if(feature.isEmpty()){
            throw new ResourceNotFound("No se encontró feature con id "+ id);
        }else {
            Feature featureResponse = feature.get();
            Image image = cacheImages.checkCacheForImage(featureResponse.getImageId());
            log.info("Se busco feature con id "+id);
            return feature.get().mapToFeatureDTO(image);
        }
    }

    /*-------------------------------------------Update Feature-------------------------------------------*/

    public void updateFeature(FeatureDTO feature) throws ResourceNotFound {
        findById(feature.getId());
        checkFeatureImage(feature);
        featureRepository.save(feature.mapToFeature());
        log.info("Se actualizo feature con id "+ feature.getId());
    }

    /*-------------------------------------------Update All By Id-------------------------------------------*/

    public void updateAllFeaturesById(Collection<FeatureDTO> features) throws ResourceNotFound {
        Collection<Feature> featuresResponse = featureRepository.findAllById(getAllIdsFeatures(features));
        Map<Long, Feature> featuresMap = collectionToHashMapFeatures(featuresResponse);
        for(FeatureDTO feature : features){
            if(featuresMap.get(feature.getId()) != null){
                checkFeatureImage(feature);
            }
        }
        featureRepository.saveAll(mapCollectionFeaturesDTOToFeatures(features));
        log.info("Se actualizaron los features con ids "+ features);
    }

    /*-------------------------------------------Delete By Id-------------------------------------------*/

    public void deleteById(Long id) throws ResourceNotFound {
        FeatureDTO feature = findById(id);
        featureRepository.deleteById(id);
        log.info("Se elimino feature con id "+ feature.getId());
    }

    /*-------------------------------------------Delete All By Id-------------------------------------------*/

    public void deleteAllFeaturesById(Collection<Long> featuresIds) throws ResourceNotFound {
        try {
            featureRepository.deleteAllById(featuresIds);
        }catch (Exception e){
            String id = e.getMessage().replaceAll("\\D+", "");
            throw new ResourceNotFound("ERROR 404: No se encontro la feature con id " + id + "\n           " + "Verifique los ids enviados");
        }
        log.info("Se eliminaron features con ids: "+ featuresIds);
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<FeatureDTO> findAllFeatures(){
        List<Feature> features =  featureRepository.findAll();
        log.info("Se buscaron todas las features");
        return mapCollectionFeaturesToFeaturesDTO(features);
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Collection<FeatureDTO> findAllFeaturesById(Collection<Long> ids){
        List<Feature> features =  featureRepository.findAllById(ids);
        log.info("Se buscaron las features con ids: " + ids);
        return mapCollectionFeaturesToFeaturesDTO(features);
    }

    /*-------------------------------------------Map Collection-------------------------------------------*/

    public Collection<FeatureDTO> mapCollectionFeaturesToFeaturesDTO(Collection<Feature> featuresCollection){
        List<FeatureDTO> featuresDTO = new ArrayList<>();
        Map<Long, Image> images = cacheImages.checkCacheForImages(getAllIdsImages(featuresCollection));
        for (Feature feature : featuresCollection) {
            Image image = images.get(feature.getImageId());
            FeatureDTO featureDTO = feature.mapToFeatureDTO(image);
            featuresDTO.add(featureDTO);
        }
        return featuresDTO;
    }

    public Collection<Feature> mapCollectionFeaturesDTOToFeatures(Collection<FeatureDTO> featuresDTO){
        List<Feature> features = new ArrayList<>();
        for (FeatureDTO feature : featuresDTO) {
            features.add(feature.mapToFeature());
        }
        return features;
    }

    public Map<Long, Feature> collectionToHashMapFeatures(Collection<Feature> features){
        HashMap<Long, Feature> featuresMap = new HashMap<>();
        for (Feature feature : features) {
            featuresMap.put(feature.getId(), feature);
        }
        return featuresMap;
    }

    public Collection<Long> getAllIdsImages(Collection<?> features){
        HashSet<Long> ids = new HashSet<>();
        for (Object feature : features) {
            if(feature instanceof Feature) ids.add(((Feature) feature).getImageId());
            else if(feature instanceof FeatureDTO) ids.add(((FeatureDTO) feature).getIcon().getId());
        }
        return ids;
    }

    public Collection<Long> getAllIdsFeatures(Collection<?> features) {
        Collection<Long> ids = new ArrayList<>();
        for (Object feature : features) {
            if(feature instanceof Feature) ids.add(((Feature) feature).getId());
            else if(feature instanceof FeatureDTO) ids.add(((FeatureDTO) feature).getId());
        }
        return ids;
    }

    /*-------------------------------------------Check and Security Data-------------------------------------------*/

    /*-------------------------------------------Check Feature Image-------------------------------------------*/

    public void checkFeatureImage(FeatureDTO feature){
        Image image;
        if(feature.getIcon().getId() == null) image = imageService.saveImage(feature.getIcon());
        else{
            image  = cacheImages.checkCacheForImage(feature.getIcon().getId());
            if(image == null) image = imageService.saveImage(feature.getIcon());
        }
        feature.setIcon(image);
    }
}