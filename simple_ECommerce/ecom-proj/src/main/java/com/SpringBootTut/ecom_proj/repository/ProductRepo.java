package com.SpringBootTut.ecom_proj.repository;

import com.SpringBootTut.ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// Marks this interface as a Spring Data repository
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    // Custom JPQL query for searching products based on a keyword
    @Query("SELECT p from Product p WHERE " +
            // Matches the 'name' field of the Product entity, ignoring case, and allowing partial matches
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword ,'%')) OR " +
            // Matches the 'brand' field of the Product entity, ignoring case, and allowing partial matches
            "LOWER(p.brand) LIKE LOWER(CONCAT('%', :keyword ,'%')) OR " +
            // Matches the 'category' field of the Product entity, ignoring case, and allowing partial matches
            "LOWER(p.category) LIKE LOWER(CONCAT('%', :keyword , '%'))")
    // Returns a list of products that match the keyword in any of the specified fields
    List<Product> searchProducts(String keyword);
}

