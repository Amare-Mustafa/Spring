package com.SpringBootTut.ecom_proj.service;

import com.SpringBootTut.ecom_proj.model.Product;
import com.SpringBootTut.ecom_proj.repository.ProductRepo;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service // Indicates this is a service layer where business logic is implemented
public class ProductService {

    @Autowired // Injects the ProductRepo dependency for database operations
    private ProductRepo repo;

    // Retrieves all products from the database
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    // Retrieves a single product by its ID. Returns null if not found
    public Product getProductById(int prodId) {
        return repo.findById(prodId).orElse(null);
    }

    // Adds a new product to the database with an image file
    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        // Extract and set image details (name, type, and byte data)
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes()); // Converts image file into byte array
        return repo.save(product); // Saves the product to the database
    }

    // Updates an existing product and its image
    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        // Extract and set updated image details
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return repo.save(product); // Updates the product in the database
    }

    // Deletes a product from the database by its ID
    public void deleteProduct(int id) {
        repo.deleteById(id);
    }

    // Searches products by a keyword using the custom query in ProductRepo
    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}

/*
@Service: Marks the class as a service layer component in Spring.
@Autowired: Enables dependency injection for the ProductRepo.
MultipartFile: Used to handle image uploads, extracting details like the file name, type, and content.
Image Handling: Converts images into a byte array for storage in the database.
Repository Interaction: The repo is used for CRUD operations and custom queries.
 */