package com.Assignment_1.InventoryManagementSystem.InventoryDto;

import com.Assignment_1.InventoryManagementSystem.entity.Product;
import com.Assignment_1.InventoryManagementSystem.entity.Store;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("store")
    private Store store;
    @JsonProperty("product")
    private Product product;
    @JsonProperty("availability")
    private int availability;


}
