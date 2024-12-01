package com.example.SimpleWebApp.controller;

import com.example.SimpleWebApp.model.Product;
import com.example.SimpleWebApp.service.Service_Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//by default the methods are get requests
@RestController
public class Controller_Products {

/*    Service_Product pService = new Service_Product(); this it the manual way creating instance in jvm*/
    @Autowired
    Service_Product pService;

    //notice the Product object is automatically converted to a json

    /////////////////////Getting and sending data(GET & POST)//////////////////////////
    /**
     * there is a jackson library in the spring web which convert from json to java object and vice verca
     */
    /*@RequestMapping("/products")*///by default the methods are get requests
    @GetMapping("/products")
    public List<Product> getProducts(){
        return pService.getProducts();
    }

    @GetMapping("/product/{prodId}")
    public Product getProductById(@PathVariable int prodId){
        return pService.getProductsById(prodId);
    }

    @PostMapping("/products")
    public  void addProduct(@RequestBody  Product prod){
        pService.addProduct(prod);
    }

    /////////////Updating and deleting(PUT & DELETE)///////////////

    @PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        pService.updateProduct(prod);
    }

    @DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        pService.deleteProduct(prodId);
    }


}
