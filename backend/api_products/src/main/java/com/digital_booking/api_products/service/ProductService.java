package com.digital_booking.api_products.service;

import com.digital_booking.api_products.dto.BookingDTO;
import com.digital_booking.api_products.dto.ProductDTO;
import com.digital_booking.api_products.dto.TermAndConditionDTO;
import com.digital_booking.api_products.exceptions.IncompleteData;
import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.model.Booking;
import com.digital_booking.api_products.model.Product;
import com.digital_booking.api_products.model.TermAndCondition;
import com.digital_booking.api_products.repository.IProductRepository;
import com.digital_booking.api_products.util.Log;
import com.digital_booking.api_products.vo.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Log4j
@Service
public class ProductService {

    private final IProductRepository productRepository;
    private final ImageService imageService;
    private final SpecsService specsService;
    private final CityService cityService;
    private final CategoryService categoryService;
    private final BookingService bookingService;
    private final TermAndConditionService termAndConditionService;

    @Autowired
    public ProductService(IProductRepository productRepository, ImageService imageService, SpecsService specsService, CityService cityService, CategoryService categoryService, @Lazy BookingService bookingService, @Lazy TermAndConditionService termAndConditionService) {
        this.productRepository = productRepository;
        this.imageService = imageService;
        this.specsService = specsService;
        this.cityService = cityService;
        this.categoryService = categoryService;
        this.bookingService = bookingService;
        this.termAndConditionService = termAndConditionService;
    }

    /*-------------------------------------------Save Product-------------------------------------------*/

    public ProductDTO saveProduct(ProductDTO productToSave) throws Exception {
        log.info(Log.formatLog("PRODUCT-SERVICE-SAVING", "Guardando product nuevo"));
        productToSave.setId(null);
        checkProductCategory(productToSave);
        checkProductCity(productToSave);
        saveImagesProduct(productToSave);
        productToSave.setBookings(new ArrayList<>());
        productToSave.setSpecs(specsService.saveSpecs(productToSave.getSpecs()));
        managmentTermsAndConditions(productToSave, true, false, false);
        Product product = productRepository.save(productToSave.mapProduct());
        productToSave.setId(product.getId());
        log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Product con id " + product.getId() + " guardado" + "\n"));
        return productToSave;
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public ProductDTO findProductById(Long id) throws ResourceNotFound {
        log.info(Log.formatLog("PRODUCT-SERVICE-FINDING", "Buscando product con id " + id));
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new ResourceNotFound("No se encontró producto con id " + id);
        } else {
            ProductDTO productResponse = mapProductToProductDTO(product.get());
            log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Product con id " + id + " encontrado" + "\n"));
            return productResponse;
        }
    }

    /*-------------------------------------------Find By Name-------------------------------------------*/

    public Collection<ProductDTO> findProductByName(String name) throws ResourceNotFound {
        log.info(Log.formatLog("PRODUCT-SERVICE-FINDING", "Buscando products con name " + name));
        Collection<Product> products = productRepository.findByName(name);
        if (products.isEmpty()) {
            throw new ResourceNotFound("No se encontraron productos con name " + name);
        } else {
            Collection<ProductDTO> productsResponse = mapCollectionClassToDTO(products, false);
            log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Products con name " + name + " encontrados" + "\n"));
            return productsResponse;
        }
    }

    /*-------------------------------------------Find By CityId-------------------------------------------*/

    public Collection<ProductDTO> findAllProductsByCity(Long id) throws ResourceNotFound {
        City city = cityService.getCity(id);
        if (city == null)
            throw new ResourceNotFound("La ciudad buscada no se encuentra en el sistema");
        log.info(Log.formatLog("PRODUCT-SERVICE-FINDING", "Buscando products ubicados en " + city.getName()));
        Collection<Product> products = productRepository.findByCity(id);
        if (products.isEmpty()) {
            throw new ResourceNotFound("No se encontraron productos en el area");
        } else {
            Collection<ProductDTO> productsResponse = mapCollectionClassToDTO(products, false);
            log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Products ubicados en " + city.getName() + " encontrados" + "\n"));
            return productsResponse;
        }
    }

    /*-------------------------------------------Find Available By Date Range-----------------------------------------*/

    public Collection<ProductDTO> findAllByDateRange(DateRangeFinder dateRangeFinder) throws ResourceNotFound, IncompleteData {
        log.info(Log.formatLog("PRODUCT-SERVICE-FINDING", "Buscando products disponibles entre las fechas de retiro: " + dateRangeFinder.getCheckIn() + " y devolucion: " + dateRangeFinder.getCheckOut()));
        /*SECURITY CHECKS---------------------------------------------------------------------------------------------*/
        if (dateRangeFinder.getCityId() == null || dateRangeFinder.getCheckIn() == null || dateRangeFinder.getCheckOut() == null)
            throw new IncompleteData("City_id, CheckIn and CheckOut cannot be null, please check your JSON and try again");
        /*PROCESS-----------------------------------------------------------------------------------------------------*/
        Collection<Booking> bookings = bookingService.findBookingsBetweenDateRange(dateRangeFinder.getCheckIn(), dateRangeFinder.getCheckOut());
        Collection<ProductDTO> products = findAllProductsByCity(dateRangeFinder.getCityId());
        Map<Long, Booking> bookingsMap = new HashMap<>();
        Collection<ProductDTO> productsAvailable = new ArrayList<>();
        for (Booking b : bookings) bookingsMap.put(b.getProduct().getId(), b);
        /*If the id of product is in the bookings map is because that product is booked so continue*/
        for (ProductDTO p : products)
            if (bookingsMap.get(p.getId()) == null) productsAvailable.add(p);
        if (productsAvailable.size() == 0)
            throw new ResourceNotFound("No se encontraron productos disponibles entre las fechas: " + dateRangeFinder.getCheckIn() + " y " + dateRangeFinder.getCheckOut());
        log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Products disponibles entre las fechas de retiro: " + dateRangeFinder.getCheckIn() + " y devolucion: " + dateRangeFinder.getCheckOut() + " son " + productsAvailable.size() + "\n"));
        return productsAvailable;
    }

    /*-------------------------------------------Update Product-------------------------------------------------------*/

    public void updateProduct(ProductDTO productToUpdate) throws Exception {
        log.info(Log.formatLog("PRODUCT-SERVICE-UPDATING", "Actualizando product con id " + productToUpdate.getId()));
        /*SECURITY CHECKS---------------------------------------------------------------------------------------------*/
        if (productToUpdate.getId() == null || productToUpdate.getName() == null || productToUpdate.getDescription() == null)
            throw new IncompleteData("id, name and description attributes  cannot be null, please check your JSON and try again.");
        /*SECURITY SETTINGS-------------------------------------------------------------------------------------------*/
        productToUpdate.setBookings(new ArrayList<>());
        /*PROCESS-----------------------------------------------------------------------------------------------------*/
        Product productFound = (Product) checkProductExistence(productToUpdate.getId(), true);
        checkProductCity(productToUpdate);
        checkProductCategory(productToUpdate);
        saveImagesProduct(productToUpdate);
        productToUpdate.getSpecs().setId(productFound.getSpecsId());
        specsService.updateSpecs(productToUpdate.getSpecs());
        managmentTermsAndConditions(productToUpdate, false, true, false);
        Product product = productToUpdate.mapProduct();
        product.setBookings(productFound.getBookings());
        productRepository.save(product);
        log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Product con id " + productToUpdate.getId() + " actualizado" + "\n"));
    }

    /*-------------------------------------------Delete By Id-------------------------------------------*/

    public void deleteProductById(Long id) throws Exception {
        log.info(Log.formatLog("PRODUCT-SERVICE-DELETING", "Eliminando product con id " + id));
        /*SECURITY CHECKS---------------------------------------------------------------------------------------------*/
        Product product = (Product) checkProductExistence(id, true);
        /*PROCESS-----------------------------------------------------------------------------------------------------*/
        Boolean specsDeleted = specsService.deleteSpecs(product.getSpecsId());
        Boolean imagesDeleted = imageService.deleteAllImagesById(product.getImagesIds());
        managmentTermsAndConditions(product, false,false, true);
        if (specsDeleted && imagesDeleted) {
            productRepository.deleteById(id);
            log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Product con id " + id + " eliminado" + "\n"));
        } else {
            log.info(Log.formatLog("**PRODUCT-SERVICE-FAIL**", "Product con id " + id + " no pudo ser eliminado"));
        }
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<ProductDTO> findAllProducts() {
        log.info(Log.formatLog("PRODUCT-SERVICE-FINDING", "Buscando todos los productos"));
        Collection<ProductDTO> products = mapCollectionClassToDTO(productRepository.findAll(), true);
        log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Todos los productos fueron encontrados" + "\n"));
        return products;
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Collection<ProductDTO> findAllProductsById(Collection<Long> ids) {
        log.info(Log.formatLog("PRODUCT-SERVICE-FINDING", "Buscando todos los productos con ids " + ids));
        Collection<Product> productsResponse = productRepository.findAllById(ids);
        if (productsResponse.isEmpty()) {
            log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Ningun producto coincidio con alguno de los ids " + ids + "\n"));
            return new ArrayList<>();
        }
        Collection<ProductDTO> products = mapCollectionClassToDTO(productRepository.findAllById(ids), false);
        if (productsResponse.size() == ids.size()) {
            log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Todos los productos con ids " + ids + " fueron encontrados" + "\n"));
            return products;
        }
        Collection<Long> idsFound = new ArrayList<>();
        for (ProductDTO p : products) idsFound.add(p.getId());
        log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Los productos con ids " + idsFound + " fueron encontrados" + "\n"));
        return products;
    }

    /*Instead of return a collection return a map*/
    public Map<Long, ProductDTO> findAllProductsByIdMap(Collection<Long> ids) {
        Collection<ProductDTO> products = findAllProductsById(ids);
        Map<Long, ProductDTO> productsMap = new HashMap<>();
        for (ProductDTO p : products) productsMap.put(p.getId(), p);
        return productsMap;
    }

    /*-------------------------------------------Map Collection-------------------------------------------*/

    public Collection<ProductDTO> mapCollectionClassToDTO(Collection<Product> products, Boolean allProducts) {
        Collection<ProductDTO> collectionResponse = new ArrayList<>();
        Map<Long, Image> images;
        Map<Long, Specs> specs;
        Map<Long, City> cities;
        Map<Long, Category> categories;
        if (allProducts) {
            images = imageService.getAllImages();
            specs = specsService.getAllSpecs();
            cities = cityService.getAllCities();
            categories = categoryService.getAllCategories();
        } else {
            Collection<Long> imagesIds = new ArrayList<>();
            Collection<Long> categoriesIds = new ArrayList<>();
            Collection<Long> citiesIds = new ArrayList<>();
            Collection<Long> specsIds = new ArrayList<>();
            for (Product product : products) {
                categoriesIds.add(product.getCategoryId());
                citiesIds.add(product.getCityId());
                specsIds.add(product.getSpecsId());
                imagesIds.addAll(product.getImagesIds());
            }
            images = imageService.getImagesByIds(imagesIds);
            specs = specsService.getAllSpecsByIds(specsIds);
            cities = cityService.getAllCitiesById(citiesIds);
            categories = categoryService.getAllCategoriesById(categoriesIds);
        }
        for (Product product : products) {
            Collection<Image> imageCollection = new ArrayList<>();
            for (Long id : product.getImagesIds()) imageCollection.add(images.get(id));
            Category category = categories.get(product.getCategoryId());
            City city = cities.get(product.getCityId());
            Specs specsProducts = specs.get(product.getSpecsId());
            Collection<BookingDTO> bookings = bookingService.mapCollectionBookingToCollectionBookingDTO(product.getBookings());
            Collection<TermAndConditionDTO> termsAndConditions = termAndConditionService.mapCollectionDTO(product.getTermsAndConditions());
            collectionResponse.add(product.mapProductDTO(category, city, specsProducts, imageCollection, bookings, termsAndConditions));
        }
        return collectionResponse;
    }

    /*-------------------------------------------Map Single Object-------------------------------------------*/

    public ProductDTO mapProductToProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setCategory(categoryService.getCategory(product.getCategoryId()));
        productDTO.setCity(cityService.getCity(product.getCityId()));
        productDTO.setSpecs(specsService.getSpecs(product.getSpecsId()));
        productDTO.setImages(imageService.getImagesByIdsCollection(product.getImagesIds()));
        productDTO.setBookings(bookingService.mapCollectionBookingToBookingDTO(product.getBookings()));
        productDTO.setTermsAndConditions(termAndConditionService.mapCollectionDTO(product.getTermsAndConditions()));
        return productDTO;
    }

    /*-----------------------------------------     Check and Security Data     --------------------------------------*/

    /*-------------------------------------------Check Product Existence----------------------------------------------*/

    public Object checkProductExistence(Long id, Boolean returnProduct) throws ResourceNotFound {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) throw new ResourceNotFound("Producto con id: " + id + " no encontrado");
        else return returnProduct ? product.get() : true;
    }

    /*-------------------------------------------Check Product City---------------------------------------------------*/

    public void checkProductCity(ProductDTO product) throws IncompleteData {
        City cityProduct = product.getCity();
        if(cityProduct == null || cityProduct.getId() == null)
            throw new IncompleteData("attribute id of city cannot be null, please check your JSON and try again");
        City city = cityService.getCity(cityProduct.getId());
        if (city == null)
            throw new IncompleteData("This city doesn't exist, please check your data and try again");
        product.setCity(city);
    }

    /*-------------------------------------------Check Product Category-------------------------------------------*/

    public void checkProductCategory(ProductDTO product) throws IncompleteData {
        Category categoryProduct = product.getCategory();
        if(categoryProduct == null || categoryProduct.getId() == null)
            throw new IncompleteData("attribute id of category cannot be null, please check your JSON and try again");
        Category category = categoryService.getCategory(categoryProduct.getId());
        if (category == null)
            throw new IncompleteData("This category doesn't exist, please check your data and try again");
        product.setCategory(category);
    }

    /*-------------------------------------------Update Images of one Product-------------------------------------------*/

    public void saveImagesProduct(ProductDTO productToSave) throws IncompleteData, ResourceNotFound {
        Collection<Image> collectionImages = productToSave.getImages();
        for (Image image : collectionImages) {
            if (image.getUrlImage() == null || image.getUrlImage().trim().length() == 0)
                throw new IncompleteData("urlImage of image cannot be null, please check your JSON and try again");
            image.setId(null);
            image.setTitle(productToSave.getName() + (image.getTitle() == null || image.getTitle().trim().length() == 0 ? " Gallery" : " " + image.getTitle()));
        }
        if (productToSave.getId() == null) {
            productToSave.setImages(imageService.saveImagesCollection(collectionImages));
        } else {
            Product product = (Product) checkProductExistence(productToSave.getId(), true);
            Boolean oldImagesDeleted = imageService.deleteAllImagesById(product.getImagesIds());
            if (oldImagesDeleted)
                productToSave.setImages(imageService.saveImagesCollection(collectionImages));
        }
    }

    public void managmentTermsAndConditions(Object object, Boolean isSaveProduct, Boolean isUpdate, Boolean isDelete) throws Exception {
        if(isSaveProduct || isUpdate){
            if (object instanceof ProductDTO product) {
                for(TermAndConditionDTO term : product.getTermsAndConditions()) {
                    termAndConditionService.checkExistence(term.getId(), false, true);
                }
            }
        }else if (isDelete) {
            if (object instanceof ProductDTO product) {
                termAndConditionService.deleteTermAndConditionCollection(((Product) checkProductExistence(product.getId(), true)).getTermsAndConditions());
            }
        }
    }
}
