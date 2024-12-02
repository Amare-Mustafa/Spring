package com.SpringBootTut.ecom_proj.controller;

import com.SpringBootTut.ecom_proj.model.Product;
import com.SpringBootTut.ecom_proj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController // Indicates this class handles RESTful web requests
@RequestMapping("/api") // Base URL mapping for all endpoints in this controller
@CrossOrigin // Enables cross-origin requests (useful for frontend-backend communication)
public class ProductController {

    @Autowired // Injects the ProductService dependency
    private ProductService service;

    @RequestMapping("/") // Handles GET requests to the base API URL
    public String greet() {
        return "Welcome!";
    }

    @GetMapping("/products") // Endpoint to retrieve all products
    public ResponseEntity<List<Product>> getAllProducts() {
        // Sends the list of products along with HTTP status code 200 (OK)
        return new ResponseEntity<>(service.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/product/{prodId}") // Endpoint to retrieve a single product by ID
    public ResponseEntity<Product> getProduct(@PathVariable int prodId) {
        Product product = service.getProductById(prodId);
        if (product != null) {
            // If product is found, return it with status 200 (OK)
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            // If not found, return status 404 (NOT FOUND)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product") // Endpoint to add a new product
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile) {
        // @RequestPart is used to accept individual parts of a multipart request
        try {
            Product product1 = service.addProduct(product, imageFile);
            return new ResponseEntity<>(product1, HttpStatus.OK); // Product added successfully
        } catch (Exception e) {
            // Return error message with status 500 (INTERNAL SERVER ERROR)
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/product/{productId}/image") // Endpoint to get a product's image
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId) {
        Product product = service.getProductById(productId);
        byte[] imageFile = product.getImageData();
        // Return image as a byte array with the correct content type
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf(product.getImageType()))
                .body(imageFile);
    }

    @PutMapping("/product/{productId}") // Endpoint to update a product
    public ResponseEntity<String> updateProduct(@PathVariable int productId, @RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product product1;
        try {
            product1 = service.updateProduct(productId, product, imageFile);
        } catch (IOException e) {
            // Return failure message if an error occurs
            return new ResponseEntity<>("Failed To update", HttpStatus.BAD_REQUEST);
        }

        // Return success or failure message based on update result
        if (product1 != null)
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        else
            return new ResponseEntity<>("Failed to update", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/product/{id}") // Endpoint to delete a product by ID
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        Product product = service.getProductById(id);
        if (product != null) {
            service.deleteProduct(id);
            // Return success message with status 200 (OK)
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } else {
            // If product not found, return status 404 (NOT FOUND)
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/product/search") // Endpoint to search products by a keyword
    public ResponseEntity<List<Product>> searchProduct(String keyword) {
        List<Product> products = service.searchProducts(keyword);
        // Return the list of matching products with status 200 (OK)
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}

/**
 * @RestController: Combines @Controller and @ResponseBody, making every method return a JSON response by default.
 * ResponseEntity: Used to send both the data and HTTP status code in the response.
 * @RequestMapping vs @GetMapping:
 * @RequestMapping can handle multiple HTTP methods (GET, POST, etc.).
 * @GetMapping, @PostMapping, etc., are specific to individual HTTP methods.
 * @RequestPart: Accepts parts of a multipart request (e.g., product data and image file separately).
 */
