package com.Assignment_1.InventoryManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inventory")
@Getter
@Setter
@NoArgsConstructor
public class Inventory {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

     @Column(name = "inventoryId",nullable = false,unique = true)
     private String inventoryId;

    @ManyToOne
    @JoinColumn(name = "store_id", referencedColumnName = "store_id",nullable = false,unique = true)
    @JsonProperty("store")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId",nullable = false,unique = true)
    @JsonProperty("product")
    private Product product;

    @Column(nullable = false)
    @JsonProperty("availableInventory")
    private int availableInventory;

    public Inventory(String inventoryId, Store store, Product product, int availableInventory) {
        this.inventoryId = inventoryId;
        this.store = store;
        this.product = product;
        this.availableInventory = availableInventory;
    }
}