package com.Assignment_1.InventoryManagementSystem.InventoryDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {
    private int pId;
    private String pName;
    private String pDesc;


}
