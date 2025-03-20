package com.Assignment_1.InventoryManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "product_details")
public class Product extends TimeStampEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "productId",nullable = false,unique = true)
    private String productId;
    @Column(name = "ProductName",nullable = false,unique = true,length = 255)
    private String productName;
    @Column(name = "ProductDescription")
    private String productDescription;

    public Product(String pid, String pName, String pDesc) {
        this.productId = pid;
        this.productName = pName;
        this.productDescription = pDesc;
    }
}