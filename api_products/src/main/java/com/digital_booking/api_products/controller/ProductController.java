package com.digital_booking.api_products.controller;

import com.digital_booking.api_products.dto.ProductDTO;
import com.digital_booking.api_products.exceptions.IncompleteData;
import com.digital_booking.api_products.exceptions.ResourceNotFound;
import com.digital_booking.api_products.service.ProductService;
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

    // POST REQUEST
    @CircuitBreaker(name = "allServicesCB", fallbackMethod = "fallBackAllServices")
    @PostMapping("/save/new")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDTO p) throws IncompleteData {
        ProductDTO product = productService.saveProduct(p);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    /*------------------------------------------------------------------------------------------------------*/

    // GET REQUEST
    @CircuitBreaker(name = "allServicesCB", fallbackMethod = "fallBackAllServices")
    @GetMapping("/find/all")
    public ResponseEntity<?> findAllCategories(){
        return ResponseEntity.ok(productService.findAllProducts());
    }

    @CircuitBreaker(name = "allServicesCB", fallbackMethod = "fallBackAllServices")
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findProductById(@PathVariable Long id) throws ResourceNotFound {
        ProductDTO product = productService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @CircuitBreaker(name = "allServicesCB", fallbackMethod = "fallBackAllServices")
    @GetMapping("/find/title")
    public ResponseEntity<?> findProductByTitle(@RequestParam String name) throws ResourceNotFound {
        Collection<ProductDTO> product = productService.findByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    /*------------------------------------------------------------------------------------------------------*/

    // PUT REQUEST
    @CircuitBreaker(name = "allServicesCB", fallbackMethod = "fallBackAllServices")
    @PutMapping("/update/product")
    public ResponseEntity<?> editProduct(@RequestBody ProductDTO p) throws ResourceNotFound, IncompleteData {
        productService.updateProduct(p);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /*------------------------------------------------------------------------------------------------------*/

    // DELETE REQUEST
    @CircuitBreaker(name = "allServicesCB", fallbackMethod = "fallBackAllServices")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) throws ResourceNotFound {
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
