package com.example.SimpleWebApp.service;

import com.example.SimpleWebApp.model.Product;
import com.example.SimpleWebApp.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Service_Product  {

    @Autowired
    ProductRepo repo;
/*    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Iphone", 50000),
            new Product(102, "Samsung", 6000),
            new Product(103, "Laptop", 80000)));*/
    //method to return the list of products

    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProductsById(int id) {
        return repo.findById(id).orElse(new Product());
    }

    public void addProduct(Product prod){
        repo.save(prod);
    }

    public void updateProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProduct(int prodId) {
        repo.deleteById(prodId);
    }
}
