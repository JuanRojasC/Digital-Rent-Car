package com.digital_booking.api_products.controller;

import com.digital_booking.api_products.dto.ProductDTO;
import com.digital_booking.api_products.exceptions.IncompleteData;
import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.service.ProductService;
import com.digital_booking.api_products.vo.DateRangeFinder;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // POST REQUEST - SAVE
    @CircuitBreaker(name = "allServicesCB", fallbackMethod = "fallBackAllServices")
    @PostMapping("/save/new")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDTO p) throws Exception {
        ProductDTO product = productService.saveProduct(p);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @CircuitBreaker( name = "allServicesCB", fallbackMethod = "fallBackAllServices")
    @PostMapping("/find/available/date/range")
    public ResponseEntity<?> findProductsByDateRange(@RequestBody DateRangeFinder dateRangeFinder) throws ResourceNotFound, IncompleteData {
        Collection<ProductDTO> products = productService.findAllByDateRange(dateRangeFinder);
        return ResponseEntity.ok(products);
    }

    /*------------------------------------------------------------------------------------------------------*/

    // GET REQUEST - FOR ALL
    @CircuitBreaker(name = "allServicesCB", fallbackMethod = "fallBackAllServices")
    @GetMapping("/find/all")
    public ResponseEntity<?> findAllCategories(){
        return ResponseEntity.ok(productService.findAllProducts());
    }

    // GET REQUEST - BY ID
    @CircuitBreaker(name = "allServicesCB", fallbackMethod = "fallBackAllServices")
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id) throws ResourceNotFound {
        ProductDTO product = productService.findProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    // GET REQUEST - BY NAME
    @CircuitBreaker(name = "allServicesCB", fallbackMethod = "fallBackAllServices")
    @GetMapping("/find/title")
    public ResponseEntity<?> findProductByTitle(@RequestParam String name) throws ResourceNotFound {
        Collection<ProductDTO> products = productService.findProductByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    // GET REQUEST - BY CITY_ID
    @CircuitBreaker(name = "allServicesCB", fallbackMethod = "fallBackAllServices")
    @GetMapping("/find/city/{cityId}")
    public ResponseEntity<?> findProductsCityId(@PathVariable Long cityId) throws ResourceNotFound {
        Collection<ProductDTO> products = productService.findAllProductsByCity(cityId);
        return ResponseEntity.ok(products);
    }

    /*------------------------------------------------------------------------------------------------------*/

    // PUT REQUEST
    @CircuitBreaker(name = "allServicesCB", fallbackMethod = "fallBackAllServices")
    @PutMapping("/update/product")
    public ResponseEntity<?> editProduct(@RequestBody ProductDTO p) throws Exception {
        productService.updateProduct(p);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*------------------------------------------------------------------------------------------------------*/

    // DELETE REQUEST
    @CircuitBreaker(name = "allServicesCB", fallbackMethod = "fallBackAllServices")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) throws Exception {
        productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Producto Eliminado");
    }

    /*------------------------------------------------------------------------------------------------------*/
    // CIRCUIT BREAKER METHODS
    /*------------------------------------------------------------------------------------------------------*/

    public ResponseEntity<?> fallBackAllServices(Exception ex){
        return ResponseEntity.ok("PRODUCTS-SERVICE: " + ex.getMessage() + ", please try again");
    }
}
