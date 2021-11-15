package com.digital_booking.api_products.service;

import com.digital_booking.api_products.dto.ProductDTO;
import com.digital_booking.api_products.exceptions.IncompleteData;
import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.model.Product;
import com.digital_booking.api_products.repository.IProductRepository;
import com.digital_booking.api_products.vo.Category;
import com.digital_booking.api_products.vo.City;
import com.digital_booking.api_products.vo.Image;
import com.digital_booking.api_products.vo.Specs;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public ProductService(IProductRepository productRepository, ImageService imageService, SpecsService specsService, CityService cityService, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.imageService = imageService;
        this.specsService = specsService;
        this.cityService = cityService;
        this.categoryService = categoryService;
    }

    /*-------------------------------------------Save Product-------------------------------------------*/

    public ProductDTO saveProduct(ProductDTO p) throws IncompleteData {
        // Evita que se guarde un id no generado por la DB
        p.setId(null);
        // Comprobacion de la existencia de la categoria
        checkProductCategory(p);
        // Comprobacion de la existencia de la ciudad
        checkProductCity(p);
        // Guarda las imagenes del producto
        Image mainImage = imageService.saveImage(p.getMainImage());
        p.setMainImage(mainImage);
        Collection<Image> images = imageService.saveImagesCollection(p.getImages());
        p.setImages(images);
        // Guarda las specs del producto
        Specs specs = specsService.saveSpecs(p.getSpecs());
        p.setSpecs(specs);
        // Guardado del producto
        Product product = productRepository.save(p.mapProduct());
        p.setId(product.getId());
        log.info("PRODUCT-SAVE: Se guardo el producto con Id " + product.getId() + ": " + product.getName());
        return p;
    }

    /*-------------------------------------------Find By Id-------------------------------------------*/

    public ProductDTO findById(Long id) throws ResourceNotFound {
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new ResourceNotFound("No se encontró producto con id "+ id);
        }else {
            log.info("PRODUCT-FIND:Se busco producto con id "+id);
            return mapProductToProductDTO(product.get());
        }
    }

    /*-------------------------------------------Find By Name-------------------------------------------*/

    public Collection<ProductDTO> findByName(String name) throws ResourceNotFound{
        Collection<Product> products = productRepository.findByName(name);
        if(products.isEmpty()){
            throw  new ResourceNotFound("No se encontraron productos con name "+ name);
        }else{
            log.info("PRODUCT-FIND-COLLECTION:Se busco categoría con titulo "+ name);
            return mapCollectionProductToProductDTO(products, false);
        }
    }

    /*-------------------------------------------Update Product-------------------------------------------*/

    public void updateProduct(ProductDTO product) throws ResourceNotFound, IncompleteData {
        if(product.getId() == null) throw new IncompleteData("id attribute of product cannot be null");
        Product productResponse = (Product) checkProductExistence(product.getId(), true);
        matchProductAttributes(product, productResponse);
        specsService.updateSpecs(product.getSpecs());
        Product p = product.mapProduct();
        p.setImagesIds(productResponse.getImagesIds());
        productRepository.save(p);
        log.info("PRODUCT-UPDATE: Se actualizo producto con id "+ product.getId());
    }

    /*-------------------------------------------Delete By Id-------------------------------------------*/

    public void deleteProductById(Long id) throws ResourceNotFound {
        Product product = (Product) checkProductExistence(id, true);
        specsService.deleteSpecs(product.getSpecsId());
        imageService.deleteAllImagesById(product.getImagesIds());
        productRepository.deleteById(id);
        log.info("PRODUCT-DELETE: Se elimino producto con id "+ id);
    }

    /*-------------------------------------------Find All-------------------------------------------*/

    public Collection<ProductDTO> findAllProducts(){
        log.info("PRODUCT-FIND-COLLECTION: Se buscaron todos los productos");
        return mapCollectionProductToProductDTO(productRepository.findAll(), true);
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
                categoriesIds.add(product.getId());
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
            productsDTO.add(product.mapProductDTO(mainImage, category, city, specsProducts, imageCollection));
        }
        return productsDTO;
    }

    public Map<Long, Object> collectionToHashMap(Collection<Object> list){
        HashMap<Long, Object> hashMap = new HashMap<>();
        for (Object o : list) {
            if( o instanceof Image) hashMap.put(((Image) o).getId(), o);
            else if ( o instanceof City) hashMap.put(((City) o).getId(), o);
            else if ( o instanceof Specs) hashMap.put(((Specs) o).getId(), o);
            else if( o instanceof Category) hashMap.put(((Category) o).getId(), o);
            else if( o instanceof Product) hashMap.put(((Product) o).getId(), o);
            else if( o instanceof  ProductDTO) hashMap.put(((ProductDTO) o).getId(), o);
        }
        return hashMap;
    }

    /*-------------------------------------------Get Attributes-------------------------------------------*/

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

    /*-------------------------------------------Match Products Attributes Ids-------------------------------------------*/

    public void matchProductAttributes(ProductDTO productToSave, Product productSaved){
        productToSave.getCity().setId(productSaved.getCityId());
        productToSave.getCategory().setId(productSaved.getCategoryId());
        productToSave.getMainImage().setId(productSaved.getMainImageId());
        productToSave.getSpecs().setId(productSaved.getSpecsId());
    }

}
