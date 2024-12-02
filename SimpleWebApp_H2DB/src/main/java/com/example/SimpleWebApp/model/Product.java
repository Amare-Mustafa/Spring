package com.example.SimpleWebApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Lombok is  java library that reduces boilerplate code.
 * it automatically generates default things like getter,setter, constructor , tostring()
 */
/*@Data*/
@Component
@Entity
public class Product {
    @Id
    private int ProdID;
    private String ProdName;
    private int price;

    public Product() {
    }

    public Product(int prodID, String prodName, int price) {
        ProdID = prodID;
        ProdName = prodName;
        this.price = price;
    }

    public int getProdID() {
        return ProdID;
    }

    public void setProdID(int prodID) {
        ProdID = prodID;
    }

    public String getProdName() {
        return ProdName;
    }

    public void setProdName(String prodName) {
        ProdName = prodName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
