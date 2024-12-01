package com.example.SimpleWebApp.service;

import com.example.SimpleWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Service_Product  {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Iphone", 50000),
            new Product(102, "Samsung", 6000),
            new Product(103, "Laptop", 80000)));
    //method to return the list of products

    public List<Product> getProducts(){
        return products;
    }

    public Product getProductsById(int id) {
        /*        for(Product p: products){
            if(p.getProdID() == id){
                return p;
            }
        }*/

        //another way of doing the same thing using Stream API
        return products.stream()
                .filter(p -> p.getProdID() == id)
                .findFirst().orElse(new Product(100,"No Item",0));
    }

    public void addProduct(Product prod){
        if(prod != null){
            products.add(prod);
        }
    }

    public void updateProduct(Product prod) {
        int index = 0;

        for(int i = 0; i < products.size();i++){
            if(products.get(i).getProdID() == prod.getProdID()){
                index = i;
            }
        }

        products.set(index,prod);
    }

    public void deleteProduct(int prodId) {
        int index = 0;
        for(int i = 0; i < products.size();i++){
            if(products.get(i).getProdID() == prodId){
                index = i;
            }
        }
        products.remove(index);
    }
}
