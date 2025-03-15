package com.Assignment_1.InventoryManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Column(name="Product_Id")
    private int pid;
    @Column(name = "Product_Name",nullable = false,unique = true,length = 255)
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "The Product name should be Alphanumeric")
    private String pName;
    @Column(name = "Product_Description")
    private String pDesc;

    public Product(String pName, String pDesc){
        this.pName=pName;
        this.pDesc=pDesc;
    }
}