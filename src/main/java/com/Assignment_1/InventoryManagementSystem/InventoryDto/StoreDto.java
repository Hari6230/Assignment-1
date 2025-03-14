package com.Assignment_1.InventoryManagementSystem.InventoryDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreDto {
    private int sId;
    private String sName;
    private String sAddress;
}
