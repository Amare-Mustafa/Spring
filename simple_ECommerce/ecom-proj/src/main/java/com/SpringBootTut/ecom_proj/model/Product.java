package com.SpringBootTut.ecom_proj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Entity//a JPA entity, which represents a table in the database. The ORM(like Hibernate) will map this class to the table, and its fields to the table columns
@Data//LOMBOK: auto generates all the basic methods like setters getter constructors and toString methods keeping your code cleaner
@AllArgsConstructor
@NoArgsConstructor

public class Product {

    @Id
    @GeneratedValue //auto generates the id
    private int id;
    private String name;
    private String description;
    private String brand;
    private BigDecimal price;
    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")//formating the date using json formater
    private Date releaseDate;
    private boolean productAvailable;
    private int stockQuantity;

    private String imageName;
    private String imageType;
    @Lob //large object
    private byte[] imageData;


}
/**
 * @Repository: Identifies this interface as a repository for database operations.
 * JpaRepository<Product, Integer>: Provides CRUD and pagination methods for Product entity. Integer is the primary key type.
 * @Query: A custom query written using JPQL (Java Persistence Query Language).
 * LOWER and LIKE: Makes the search case-insensitive and allows partial matching.
 * CONCAT('%', :keyword ,'%'): Surrounds the keyword with % to enable wildcard matching on both sides.
 */