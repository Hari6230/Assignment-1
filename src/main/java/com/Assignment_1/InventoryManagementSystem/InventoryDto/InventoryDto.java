package com.Assignment_1.InventoryManagementSystem.InventoryDto;

import com.Assignment_1.InventoryManagementSystem.Model.Product;
import com.Assignment_1.InventoryManagementSystem.Model.Store;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {
    private int id;
    private Store store;
   private Product product;
   private int availability;


}
