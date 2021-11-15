package com.digital_booking.api_specs.service;

import com.digital_booking.api_specs.dto.SpecsDTO;
import com.digital_booking.api_specs.exceptions.ResourceNotFound;
import com.digital_booking.api_specs.model.Specs;
import com.digital_booking.api_specs.repository.ISpecsRepository;
import com.digital_booking.api_specs.vo.Feature;
import com.digital_booking.api_specs.vo.Image;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Log4j
@Service
public class SpecsService {

    private ISpecsRepository specsRepository;
    private FeatureService featureService;

    @Autowired
    public SpecsService(ISpecsRepository specsRepository, FeatureService featureService) {
        this.specsRepository = specsRepository;
        this.featureService = featureService;
    }

    /*-------------------------------------------Save Specs-------------------------------------------*/

    public SpecsDTO saveSpecs(SpecsDTO specs){
        // Evita que se guarde un id no generado por la DB
        specs.setId(null);
        // Guarda las features del specs
        Collection<Feature> features = featureService.saveFeaturesCollection(specs.collectFeatures());
        specs.assignFeatures(features);
        Specs specsResponse = specsRepository.save(specs.mapSpecs());
        log.info("SPECS: Se guardaron las specs con Id " + specsResponse.getId());
        return specsResponse.mapSpecsDTO(specs);
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public SpecsDTO findById(Long id) throws ResourceNotFound {
        Optional<Specs> specs = specsRepository.findById(id);
        if(specs.isEmpty()){
            throw new ResourceNotFound("No se encontró specs con id "+ id);
        }else {
            Specs specsResponse = specs.get();
            Collection<Feature> features = featureService.getFeaturesByIds(specsResponse.collectFeatures());
            Map<Long, Feature> featuresMap = collectionToHashMapFeatures(features);
            log.info("SPECS: Se busco specs con id "+id);
            return specs.get().mapSpecsDTO(featuresMap);
        }
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Collection<SpecsDTO> findAllSpecsById(Collection<Long> ids){
        Collection<Specs> specsResponse = specsRepository.findAllById(ids);
        log.info("SPECS: Se buscaron todos los specs con ids " + ids);
        return mapCollectionToDTOSpecs(specsResponse);
    }

    /*-------------------------------------------Return the Specs-------------------------------------------*/

    public Object specs() {
        List combustibleOptions = new ArrayList();
        combustibleOptions.add(new Feature(null, "gasoline", "false", new Image(8L, "Gasoline Icon", "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/gasoline.png")));
        combustibleOptions.add(new Feature(null, "diesel", "false", new Image(8L, "Gasoline Icon", "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/gasoline.png")));
        combustibleOptions.add(new Feature(null, "electric", "false", new Image(6L, "Electric Icon", "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/electric.png")));
        Map specs = new HashMap<String, Object>();
        specs.put("enginePower", new Feature(null, "enginePower", null, new Image(7L, "Engine Icon", "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/engine.png")));
        specs.put("airConditioning", new Feature(null, "airConditioning", null, new Image(5L, "Air conditioner Icon", "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/air-conditioner.png")));
        specs.put("seats", new Feature(null,"seats", null, new Image(9L, "seat Icon", "https://digital-rentcar-bucket.s3.us-east-2.amazonaws.com/Icons/seat.png")));
        specs.put("combustible",combustibleOptions );
        specs.put("combustible**", "just select one option for combustible. combustibe: object");
        return specs;
    }

    /*-------------------------------------------Update Specs-------------------------------------------*/

    public void updateSpecs(SpecsDTO specs) throws ResourceNotFound {
        Optional<Specs> specsResponse = specsRepository.findById(specs.getId());
        matchFeaturesId(specsResponse.get(), specs);
        featureService.updateFeaturesById(specs.collectFeatures());
        specsRepository.save(specs.mapSpecs());
        log.info("SPECS: Se actualizo specs con id "+ specs.getId());
    }

    /*-------------------------------------------Delete By Id-------------------------------------------*/

    public void deleteById(Long id) throws ResourceNotFound {
        Specs specs = findById(id).mapSpecs();
        if(featureService.deleteFeaturesByIds(specs.collectFeatures())){
            specsRepository.deleteById(id);
        }
        log.info("SPECS: Se elimino specs con id "+ id);
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<SpecsDTO> findAllSpecs(){
        Collection<Specs> specs = specsRepository.findAll();
        Collection<SpecsDTO> specsDTO = new ArrayList<>();
        log.info("SPECS: Se buscaron todos los specs");
        return mapCollectionToDTOSpecs(specs);
    }

    /*-------------------------------------------Map Collection-------------------------------------------*/

    public Collection<SpecsDTO> mapCollectionToDTOSpecs(Collection<Specs> specssCollection){
        Collection<SpecsDTO> specsDTOCollection = new ArrayList<>();
        Collection<Feature> features = featureService.getAllFeatures();
        Map<Long, Feature> featuresMap = collectionToHashMapFeatures(features);
        for (Specs specs : specssCollection) {
            specsDTOCollection.add(specs.mapSpecsDTO(featuresMap));
        }
        return specsDTOCollection;
    }

    public Map<Long, Feature> collectionToHashMapFeatures(Collection<Feature> features){
        HashMap<Long, Feature> featuresMap = new HashMap<>();
        for (Feature feature : features) {
            featuresMap.put(feature.getId(), feature);
        }
        return featuresMap;
    }

    /*-------------------------------------------Check and Security Data-------------------------------------------*/

    public void matchFeaturesId(Specs specsSaved, SpecsDTO specsToSave){
        System.out.println(specsSaved.getEnginePower() + " " + specsSaved.getAirConditioning());
        specsToSave.getEnginePower().setId(specsSaved.getEnginePower());
        specsToSave.getAirConditioning().setId(specsSaved.getAirConditioning());
        specsToSave.getSeats().setId(specsSaved.getSeats());
        specsToSave.getCombustible().setId(specsSaved.getCombustible());
    }

    /*-------------------------------------------APIS Operations-------------------------------------------*/

}
