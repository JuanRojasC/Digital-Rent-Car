package com.digital_booking.api_products.service;

import com.digital_booking.api_products.dto.BookingDTO;
import com.digital_booking.api_products.dto.ProductDTO;
import com.digital_booking.api_products.exceptions.IncompleteData;
import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.model.Booking;
import com.digital_booking.api_products.model.Product;
import com.digital_booking.api_products.repository.IProductRepository;
import com.digital_booking.api_products.util.Log;
import com.digital_booking.api_products.vo.*;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.*;

@Log4j
@Service
public class ProductService {

    private IProductRepository productRepository;
    private ImageService imageService;
    private SpecsService specsService;
    private CityService cityService;
    private CategoryService categoryService;
    private BookingService bookingService;

    @Autowired
    public ProductService(IProductRepository productRepository, ImageService imageService, SpecsService specsService, CityService cityService, CategoryService categoryService, @Lazy BookingService bookingService) {
        this.productRepository = productRepository;
        this.imageService = imageService;
        this.specsService = specsService;
        this.cityService = cityService;
        this.categoryService = categoryService;
        this.bookingService = bookingService;
    }

    /*-------------------------------------------Save Product-------------------------------------------*/

    public ProductDTO saveProduct(ProductDTO productToSave) throws IncompleteData {
        log.info(Log.formatLog("PRODUCT-SERVICE-SAVING", "Guardando product nuevo"));
        // Evita que se guarde un id no generado por la DB
        productToSave.setId(null);
        // Evita crear un producto con reservas
        productToSave.setBookings(new ArrayList<>());
        // Comprobacion de la existencia de la categoria
        checkProductCategory(productToSave);
        // Comprobacion de la existencia de la ciudad
        checkProductCity(productToSave);
        // Guarda las imagenes del producto
        saveImagesProduct(productToSave, null);
        // Guarda las specs del producto
        Specs specs = specsService.saveSpecs(productToSave.getSpecs());
        productToSave.setSpecs(specs);
        // Guardado del producto
        Product product = productRepository.save(productToSave.mapProduct());
        productToSave.setId(product.getId());
        log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Product con id " + product.getId() + " guardado" + "\n"));
        return productToSave;
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public ProductDTO findProductById(Long id) throws ResourceNotFound {
        log.info(Log.formatLog("PRODUCT-SERVICE-FINDING", "Buscando product con id " + id));
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ResourceNotFound("No se encontró producto con id "+ id);
        }else {
            ProductDTO productResponse = mapProductToProductDTO(product.get());
            log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Product con id " + id + " encontrado" + "\n"));
            return productResponse;
        }
    }

    /*-------------------------------------------Find By Name-------------------------------------------*/

    public Collection<ProductDTO> findProductByName(String name) throws ResourceNotFound{
        log.info(Log.formatLog("PRODUCT-SERVICE-FINDING", "Buscando products con name " + name ));
        Collection<Product> products = productRepository.findByName(name);
        if(products.isEmpty()){
            throw  new ResourceNotFound("No se encontraron productos con name "+ name);
        }else{
            Collection<ProductDTO> productsResponse = mapCollectionProductToProductDTO(products, false);
            log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Products con name " + name + " encontrados" + "\n"));
            return productsResponse;
        }
    }

    /*-------------------------------------------Find By CityId-------------------------------------------*/

    public Collection<ProductDTO> findAllProductsByCity(Long id) throws ResourceNotFound {
        // Comprobacion de la existencia de la ciudad
        City city = cityService.getCity(id);
        if(city==null) throw new ResourceNotFound("La ciudad buscada no se encuentra en el sistema");
        log.info(Log.formatLog("PRODUCT-SERVICE-FINDING", "Buscando products ubicados en " + city.getName()));
        Collection<Product> products = productRepository.findByCity(id);
        if(products.isEmpty()){
            throw new ResourceNotFound("No se encontraron productos en el area");
        }else{
            Collection<ProductDTO> productsResponse = mapCollectionProductToProductDTO(products, false);
            log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Products ubicados en " + city.getName() + " encontrados" + "\n"));
            return productsResponse;
        }
    }

    /*-------------------------------------------Find Available By Date Range-------------------------------------------*/

    public Collection<ProductDTO> findAllByDateRange(DateRangeFinder dateRangeFinder) throws ResourceNotFound, IncompleteData {
        log.info(Log.formatLog("PRODUCT-SERVICE-FINDING", "Buscando products disponibles entre las fechas de retiro: " + dateRangeFinder.getCheckIn() + " y devolucion: " + dateRangeFinder.getCheckOut()));
        /*validacion de los datos del DateRangeFinder*/
        if(dateRangeFinder.getCityId() == null || dateRangeFinder.getCheckIn() == null || dateRangeFinder.getCheckOut() == null)
            throw new IncompleteData("City_id, CheckIn and CheckOut cannot be null, please check your JSON and try again");
        /*Find if exists bookings between that dates*/
        Collection<Booking> bookings = bookingService.findBookingsBetweenDateRange(dateRangeFinder.getCheckIn(), dateRangeFinder.getCheckOut());
        /*Find the products localized in that city*/
        Collection<ProductDTO> products = findAllProductsByCity(dateRangeFinder.getCityId());
        Map<Long, Booking> bookingsMap = new HashMap<>();
        Collection<ProductDTO> productsAvailable  = new ArrayList<>();
        /*Add the bookings at bookings map with key the produt_id of that booking*/
        for(Booking b : bookings) bookingsMap.put(b.getProduct().getId(), b);
        /*If the id of product is in the bookings map is because that product is booked so continue is not available*/
        for(ProductDTO p : products){
            if(bookingsMap.get(p.getId()) != null) continue;
            else productsAvailable.add(p);
        }
        if(productsAvailable.size() == 0){
            log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "No hay products disponibles entre las fechas de retiro: " + dateRangeFinder.getCheckIn() + " y devolucion: " + dateRangeFinder.getCheckOut() + "\n"));
            throw new ResourceNotFound("No se encontraron productos disponibles entre las fechas: " + dateRangeFinder.getCheckIn() + " y " + dateRangeFinder.getCheckOut());
        }
        log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Products disponibles entre las fechas de retiro: " + dateRangeFinder.getCheckIn() + " y devolucion: " + dateRangeFinder.getCheckOut() + " son " + productsAvailable.size() + "\n"));
        return productsAvailable;
    }

    /*-------------------------------------------Update Product-------------------------------------------*/

    public void updateProduct(ProductDTO product) throws ResourceNotFound, IncompleteData {
        log.info(Log.formatLog("PRODUCT-SERVICE-UPDATING", "Actualizando product con id " + product.getId()));
        /*Check attribute id of product*/
        if(product.getId() == null || product.getName() == null || product.getDescription() == null)
            throw new IncompleteData("id, name and description attributes  cannot be null, please check your JSON and try again.");
        Product productResponse = (Product) checkProductExistence(product.getId(), true);
        /*Check if city exists*/
        checkProductCity(product);
        /*Check if category exists*/
        checkProductCategory(product);
        /*Update new specs*/
        product.getSpecs().setId(productResponse.getSpecsId());
        Boolean specsUpdated = specsService.updateSpecs(product.getSpecs());
        /*Save new images*/
        saveImagesProduct(product, productResponse);
        specsService.updateSpecs(product.getSpecs());
        /*Set the current bookings*/
        product.setBookings(new ArrayList<>());
        Product p = product.mapProduct();
        p.setBookings(productResponse.getBookings());
        /*Update the product*/
        productRepository.save(p);
        log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Product con id " + product.getId() + " actualizado" + "\n"));
    }

    /*-------------------------------------------Delete By Id-------------------------------------------*/

    public void deleteProductById(Long id) throws ResourceNotFound {
        log.info(Log.formatLog("PRODUCT-SERVICE-DELETING", "Eliminando product con id " + id));
        /*Check if the product exists*/
        Product product = (Product) checkProductExistence(id, true);
        /*Delete the specs*/
        Boolean specsDeleted = specsService.deleteSpecs(product.getSpecsId());
        /*Delete the Images*/
        Boolean imagesDeleted = imageService.deleteAllImagesById(product.getImagesIds());
        if(specsDeleted && imagesDeleted){
            productRepository.deleteById(id);
            log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Product con id " + id + " eliminado" + "\n"));
        }else{
            log.info(Log.formatLog("**PRODUCT-SERVICE-FAIL**", "Product con id " + id + " no pudo ser eliminado"));
        }
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<ProductDTO> findAllProducts(){
        log.info(Log.formatLog("PRODUCT-SERVICE-FINDING", "Buscando todos los productos"));
        Collection products = mapCollectionProductToProductDTO(productRepository.findAll(), true);
        log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Todos los productos fueron encontrados" + "\n"));
        return products;
    }

    /*-------------------------------------------Find All By Id-------------------------------------------*/

    public Collection<ProductDTO> findAllProductsById(Collection<Long> ids){
        log.info(Log.formatLog("PRODUCT-SERVICE-FINDING", "Buscando todos los productos con ids " + ids));
        Collection<Product>  productsResponse = productRepository.findAllById(ids);
        if(productsResponse.isEmpty()){
            log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Ningun producto coincidio con alguno de los ids " + ids + "\n"));
            return new ArrayList<>();
        }
        Collection<ProductDTO> products = mapCollectionProductToProductDTO(productRepository.findAllById(ids), false);
        if(productsResponse.size() == ids.size()){
            log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Todos los productos con ids " + ids + " fueron encontrados" + "\n"));
            return products;
        }
        Collection<Long> idsFound = new ArrayList<>();
        for(ProductDTO p : products) idsFound.add(p.getId());
        log.info(Log.formatLog("PRODUCT-SERVICE-SUCCESS", "Los productos con ids " + idsFound + " fueron encontrados" + "\n"));
        return products;
    }

    /*Instead of return a collection return a map*/
    public Map<Long, ProductDTO> findAllProductsByIdMap(Collection<Long> ids){
        Collection<ProductDTO> products = findAllProductsById(ids);
        Map<Long, ProductDTO> productsMap = new HashMap<>();
        for(ProductDTO p : products) productsMap.put(p.getId(), p);
        return productsMap;
    }

    /*-------------------------------------------Map Collection-------------------------------------------*/

    public Collection<ProductDTO> mapCollectionProductToProductDTO(Collection<Product> products, Boolean allProducts){
        Collection<ProductDTO> productsDTO = new ArrayList<>();
        Map<Long, Image> images;
        Map<Long, Specs> specs;
        Map<Long, City> cities;
        Map<Long, Category> categories;
        if(allProducts){
            images = imageService.getAllImages();
            specs = specsService.getAllSpecs();
            cities = cityService.getAllCities();
            categories = categoryService.getAllCategories();
        }else{
            Collection<Long> imagesIds = new ArrayList<>();
            Collection<Long> categoriesIds = new ArrayList<>();
            Collection<Long> citiesIds = new ArrayList<>();
            Collection<Long> specsIds = new ArrayList<>();
            for (Product product : products) {
                imagesIds.add(product.getMainImageId());
                categoriesIds.add(product.getCategoryId());
                citiesIds.add(product.getCityId());
                specsIds.add(product.getSpecsId());
                for(Long id : product.getImagesIds()){
                    imagesIds.add(id);
                }
            }
            images = imageService.getImagesByIds(imagesIds);
            specs = specsService.getAllSpecsByIds(specsIds);
            cities = cityService.getAllCitiesById(citiesIds);
            categories = categoryService.getAllCategoriesById(categoriesIds);
        }
        for(Product product : products){
            Image mainImage = images.get(product.getMainImageId());
            Category category = categories.get(product.getCategoryId());
            City city = cities.get(product.getCityId());
            Specs specsProducts = specs.get(product.getSpecsId());
            Collection<Image> imageCollection = new ArrayList<>();
            for(Long id : product.getImagesIds()){
                imageCollection.add(images.get(id));
            }
            Collection<BookingDTO> bookings = bookingService.mapCollectionBookingToCollectionBookingDTO(product.getBookings());
            productsDTO.add(product.mapProductDTO(mainImage, category, city, specsProducts, imageCollection, bookings));
        }
        return productsDTO;
    }

    /*-------------------------------------------Map Single Object-------------------------------------------*/

    public ProductDTO mapProductToProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setMainImage(imageService.getImage(product.getMainImageId()));
        productDTO.setCategory(categoryService.getCategory(product.getCategoryId()));
        productDTO.setCity(cityService.getCity(product.getCityId()));
        productDTO.setSpecs(specsService.getSpecs(product.getSpecsId()));
        productDTO.setImages(imageService.getImagesByIdsCollection(product.getImagesIds()));
        productDTO.setBookings(bookingService.mapCollectionBookingToBookingDTO(product.getBookings()));
        return productDTO;
    }

    /*-------------------------------------------Check and Security Data-------------------------------------------*/

    /*-------------------------------------------Check Product Existence-------------------------------------------*/

    public Object checkProductExistence(Long id, Boolean returnProduct) throws ResourceNotFound{
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()) throw new ResourceNotFound("Producto con id: " + id + " no encontrado");
        else return returnProduct? product.get() : true;
    }

    /*-------------------------------------------Check Product City-------------------------------------------*/

    public  void checkProductCity(ProductDTO product) throws IncompleteData {
        City cityProduct = product.getCity();
        City city = new City();
        if(cityProduct.getId() != null) city = cityService.getCity(cityProduct.getId());
        else if(cityProduct.getId() == null)throw new IncompleteData("attribute id of city cannot be null, please check your JSON and try again");
        else if(city == null) throw new IncompleteData("This city doesn't exist, please check your data and try again");
        product.setCity(city);
    }

    /*-------------------------------------------Check Product Category-------------------------------------------*/

    public  void checkProductCategory(ProductDTO product) throws IncompleteData {
        Category categoryProduct = product.getCategory();
        Category category = new Category();
        if(categoryProduct.getId() != null) category = categoryService.getCategory(categoryProduct.getId());
        else if(categoryProduct.getId() == null) throw new IncompleteData("attribute id of category cannot be null, please check your JSON and try again");
        else if(category == null) throw new IncompleteData("This category doesn't exist, please check your data and try again");
        product.setCategory(category);
    }

    /*-------------------------------------------Update Images of one Product-------------------------------------------*/

    public void saveImagesProduct(ProductDTO productToSave, Product productSaved) throws IncompleteData {
        // GALLERY IMAGES PROCCESS
        Image mainImage = productToSave.getMainImage();
        if(mainImage.getTitle() == null)
            mainImage.setTitle(productToSave.getName());
        // add main image to collection of images
        productToSave.getImages().add(productToSave.getMainImage());
        for(Image image : productToSave.getImages()){
            if(image.getUrlImage() == null)
                throw new IncompleteData("urlImage of image cannot be null, please check your JSON and try again");
            if((image.getTitle() != null && image.getTitle() != "") && !image.equals(mainImage))
                image.setTitle(productToSave.getName() + " Gallery");
            image.setId(null);
        }
        try{
            Boolean oldsImagesDeleted = true;
            Collection<Image> imagesSaved = new ArrayList<>();
            if(productSaved != null)
                oldsImagesDeleted = imageService.deleteAllImagesById(productSaved.getImagesIds());
            if(oldsImagesDeleted)
                imagesSaved = imageService.saveImagesCollection(productToSave.getImages());
                for(Image image : imagesSaved){
                    if(image.getUrlImage().equals(mainImage.getUrlImage())){
                        mainImage = image;
                        break;
                    }
                }
                productToSave.setMainImage(mainImage);
                imagesSaved.remove(mainImage);
            productToSave.setImages(imagesSaved);
        }catch (Exception e){
            log.error(Log.formatLog("SAVE-IMAGES-PRODUCT-FAIL", e.getMessage()));
        }
    }
}
