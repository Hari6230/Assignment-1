package com.Assignment_1.InventoryManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventory")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id",nullable = false,unique = true)
    @JsonProperty("store")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id",nullable = false,unique = true)
    @JsonProperty("product")
    private Product product;

    @Column(nullable = false)
    @JsonProperty("availableInventory")
    private int availableInventory;
}