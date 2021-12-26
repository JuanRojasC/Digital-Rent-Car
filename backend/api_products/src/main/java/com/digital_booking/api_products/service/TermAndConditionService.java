package com.digital_booking.api_products.service;

import com.digital_booking.api_products.dto.ProductDTO;
import com.digital_booking.api_products.dto.TermAndConditionDTO;
import com.digital_booking.api_products.exceptions.IncompleteData;
import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.model.TermAndCondition;
import com.digital_booking.api_products.repository.ITermAndConditionRepository;
import com.digital_booking.api_products.util.Log;
import com.digital_booking.api_products.vo.Image;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Log4j
@Service
public class TermAndConditionService {

    private final ITermAndConditionRepository termAndConditionRepository;
    private final ProductService productService;
    private final ImageService imageService;

    @Autowired
    public TermAndConditionService(ITermAndConditionRepository termAndConditionRepository, ProductService productService, ImageService imageService) {
        this.termAndConditionRepository = termAndConditionRepository;
        this.productService = productService;
        this.imageService = imageService;
    }

    /*-----------------------------------------     Save Term&Condition      -----------------------------------------*/
    public TermAndConditionDTO saveTermAndCondition(TermAndConditionDTO objectToSave) throws Exception {
        managmentObject(objectToSave, true);
        objectToSave.setId(null);
        TermAndCondition objectSaved = termAndConditionRepository.save(objectToSave.mapTermAndCondition());
        objectToSave.setId(objectSaved.getId());
        log.info(Log.formatLog("T&C-SERVICE", "Nuevo T&C guardado con id " + objectToSave.getId()));
        return objectToSave;
    }

    /*-----------------------------------------     Save Term&Condition Collection     -------------------------------*/
    public Collection<TermAndConditionDTO> saveTermAndConditionCollection(Collection<TermAndConditionDTO> collectionToSave) throws Exception {
        managmentObject(collectionToSave, true);
        Collection<TermAndCondition> collectionSaved = termAndConditionRepository.saveAll(this.mapCollectionClass(collectionToSave));
        log.info(Log.formatLog("T&C-SERVICE", "Coleccion de T&Cs con ids " + getIds(collectionSaved) + " guardada"));
        return mapCollectionDTO(collectionSaved);
    }

    /*-----------------------------------------     Update Term&Condition      ---------------------------------------*/
    public TermAndConditionDTO updateTermAndCondition(TermAndConditionDTO objectToUpdate) throws Exception {
        managmentObject(objectToUpdate, false);
        TermAndCondition objectUpdated = termAndConditionRepository.save(objectToUpdate.mapTermAndCondition());
        log.info(Log.formatLog("T&C-SERVICE", "T&C con id " + objectToUpdate.getId() + " actualizado"));
        return mapTermAndConditionDTO(objectUpdated);
    }

    /*-----------------------------------------     Update Term&Condition Collection     -----------------------------*/
    public Collection<TermAndConditionDTO> updateTermAndConditionCollection(Collection<TermAndConditionDTO> collectionToUpdate) throws Exception {
        managmentObject(collectionToUpdate, false);
        Collection<TermAndCondition> collectionUpdated = termAndConditionRepository.saveAll(this.mapCollectionClass(collectionToUpdate));
        log.info(Log.formatLog("T&C-SERVICE", "Coleccion de T&Cs con ids " + getIds(collectionUpdated) + " actualizada"));
        return mapCollectionDTO(collectionUpdated);
    }

    /*-----------------------------------------     Delete Term&Condition      ---------------------------------------*/
    public Boolean deleteTermAndCondition(Long id) throws Exception{
        if((Boolean) checkExistence(id, false, true)) termAndConditionRepository.deleteById(id);
        log.info(Log.formatLog("T&C-SERVICE", "T&C con id " + id + " eliminado"));
        return true;
    }

    /*-----------------------------------------     Delete Term&Condition Collection     -----------------------------*/
    public Boolean deleteTermAndConditionCollection(Collection<TermAndCondition> collectionToDelete) throws Exception{
        for(TermAndCondition term : collectionToDelete) checkExistence(term.getId(), false, true);
        Collection<Long> ids = collectionToDelete.stream().map(TermAndCondition::getId).collect(Collectors.toList());
        termAndConditionRepository.deleteAllById(ids);
        log.info(Log.formatLog("T&C-SERVICE", "Coleccion de T&Cs con ids " + ids + " eliminada"));
        return true;
    }

    /*-----------------------------------------     Find Term&Condition By Id    -------------------------------------*/
    public TermAndConditionDTO findTermAndConditionById(Long id) throws Exception {
        Optional<TermAndCondition> objectFound = termAndConditionRepository.findById(id);
        if(objectFound.isEmpty())
            throw new ResourceNotFound("T&C not found");
        TermAndConditionDTO objectResponse = mapTermAndConditionDTO(objectFound.get());
        log.info(Log.formatLog("T&C-SERVICE", "T&C con id " + id + " encontrado"));
        return objectResponse;
    }

    /*-----------------------------------------     Find Term&Condition By Id    -------------------------------------*/
    public Collection<TermAndConditionDTO> findAllTermsAndConditions() throws Exception {
        Collection<TermAndCondition> collectionFound = termAndConditionRepository.findAll();
        log.info(Log.formatLog("T&C-SERVICE", "Todos los T&C fueron buscados"));
        return mapCollectionDTO(collectionFound);
    }

    /*-----------------------------------------     Find Term&Condition Collection    --------------------------------*/
    public Collection<TermAndConditionDTO> findTermAndConditionById(Collection<TermAndCondition> collectionToFind) throws Exception {
        Collection<Long> ids = collectionToFind.stream().map(tc -> tc.getId()).collect(Collectors.toList());
        Collection<TermAndCondition> collectionFound = termAndConditionRepository.findAllById(ids);
        if(collectionFound.isEmpty()) throw new ResourceNotFound("Ningun T&C con alguno de los ids de la coleccion fue encontrado");
        log.info(Log.formatLog("T&C-SERVICE", "T&C con ids " + ids + " encontrados"));
        return mapCollectionDTO(collectionFound);
    }

    /*-----------------------------------------     Mappers     ------------------------------------------------------*/
    public TermAndConditionDTO mapTermAndConditionDTO(TermAndCondition termAndCondition){
        return TermAndConditionDTO.builder()
                .id(termAndCondition.getId())
                .title(termAndCondition.getTitle())
                .description(termAndCondition.getDescription())
                .icon(imageService.getImage(termAndCondition.getIconId()))
                .build();
    }

    public Collection<TermAndCondition> mapCollectionClass(Collection<TermAndConditionDTO> collection){
        Collection<TermAndCondition> collectionResponse = new ArrayList<>();
        for(TermAndConditionDTO term : collection) collectionResponse.add(term.mapTermAndCondition());
        return collectionResponse;
    }

    public Collection<TermAndConditionDTO> mapCollectionDTO(Collection<TermAndCondition> collection){
        Collection<TermAndConditionDTO> collectionResponse = new ArrayList<>();
        Set<Long> imagesIds = new HashSet<>(collection.stream().map(TermAndCondition::getIconId).collect(Collectors.toList()));
        Map<Long, Image> icons = imageService.getImagesByIds(new ArrayList<>(imagesIds));
        for(TermAndCondition term : collection) {
            collectionResponse.add(
                    TermAndConditionDTO.builder()
                    .id(term.getId())
                    .title(term.getTitle())
                    .description(term.getDescription())
                    .icon(icons != null? icons.get(term.getIconId()) : null)
                    .build()
            );
        }
        return collectionResponse;
    }

    /*-----------------------------------------     get Ids     ------------------------------------------------------*/
    public Collection<Long> getIds(Collection<TermAndCondition> collection){
        Collection<Long> ids = new ArrayList<>();
        for(TermAndCondition term : collection){
            ids.add(term.getId());
        }
        return ids;
    }

    /*-----------------------------------------     Save Value Objects     -------------------------------------------*/
    public void saveValueObjects(TermAndConditionDTO termAndCondition){
        Image imageVO = termAndCondition.getIcon();
        imageVO.setId(null);
        termAndCondition.setIcon(imageService.saveImage(imageVO));
    }

    /*------------------------------------------     Check Attributes      -------------------------------------------*/
    public void checkAttributes(TermAndConditionDTO termAndCondition, Boolean isNew) throws IncompleteData {
        log.info(Log.formatLog("T&C-VALIDATION", "Validando atributos"));
        String standardMessage = "cannot be null, please check data";
        if(termAndCondition.getId() == null && !isNew)
            throw new IncompleteData("Id attribute" + standardMessage);
        if(termAndCondition.getDescription() == null)
            throw new IncompleteData("Description attribute" + standardMessage);
        if(termAndCondition.getIcon() != null){
            if(termAndCondition.getIcon().getId() == null && !isNew)
                throw new IncompleteData("Id attribute of image" + standardMessage);
            if(termAndCondition.getIcon().getTitle() == null)
                termAndCondition.getIcon().setTitle("Term and Condition icon");
            if(termAndCondition.getIcon().getUrlImage() == null)
                throw new IncompleteData("Url attribute of image" + standardMessage);
        }
    }

    /*-----------------------------------------     Check and Managment Integrity of Object    -----------------------*/

    public void managmentObject(Object object, Boolean isNew) throws IncompleteData, ResourceNotFound {
        if(object instanceof TermAndConditionDTO term){
            checkAttributes(term, isNew);
            saveValueObjects(term);
            if(!isNew) checkExistence(term.getId(), false, true);
        }
        if(object instanceof Collection){
            Collection<TermAndConditionDTO> collection = (Collection<TermAndConditionDTO>) object;
            for(TermAndConditionDTO term : collection){
                checkAttributes(term, isNew);
                saveValueObjects(term);
            }
            if(!isNew) for(TermAndConditionDTO term : collection) checkExistence(term.getId(), false, true);
        }
    }

    /*-----------------------------------------     Check Existence of Object    -----------------------*/

    public Object checkExistence(Long id, Boolean returnObject, Boolean launchException) throws ResourceNotFound {
        Optional<TermAndCondition> objectFound = termAndConditionRepository.findById(id);
        if(objectFound.isPresent() && returnObject) return objectFound.get();
        else if(objectFound.isPresent()) return true;
        else if(launchException) throw new ResourceNotFound("T&C con id " + id + " no existe");
        else return false;
    }
}
