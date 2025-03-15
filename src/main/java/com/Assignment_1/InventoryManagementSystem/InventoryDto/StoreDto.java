package com.Assignment_1.InventoryManagementSystem.InventoryDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreDto {
    private String sId;
    private String sName;
    private String sAddress;
}
