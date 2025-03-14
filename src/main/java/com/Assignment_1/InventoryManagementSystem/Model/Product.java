package com.Assignment_1.InventoryManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_details")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Product_Id")
    @JsonProperty("pid")
    private int pid;
    @Column(name = "Product_Name",nullable = false,unique = true,length = 255)
    @JsonProperty("pName")
    private String pName;
    @JsonProperty("pDesc")
    @Column(name = "Product_Description")
    private String pDesc;
}