package com.Assignment_1.InventoryManagementSystem.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "product_details")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "product_id",nullable = false,unique = true)
    private String pid;
    @Column(name = "Product_Name",nullable = false,unique = true,length = 255)
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "The Product name should be Alphanumeric")
    private String pName;
    @Column(name = "Product_Description")
    private String pDesc;

    public Product(String pid, String pName, String pDesc) {
        this.pid = pid;
        this.pName = pName;
        this.pDesc = pDesc;
    }
}