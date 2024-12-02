package com.example.SimpleWebApp.repository;

import com.example.SimpleWebApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
