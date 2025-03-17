package com.Assignment_1.InventoryManagementSystem.InventoryDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto {

    public ProductDto(String pName, String pDesc){
        this.pName = pName;
        this.pDesc = pDesc;
    }
    public ProductDto(int id, String pName, String pDesc){
        this.pId = id;
        this.pName = pName;
        this.pDesc = pDesc;
    }
    @JsonProperty("pId")
    private int pId;
    @JsonProperty("pName")
    private String pName;
    @JsonProperty("pDesc")
    private String pDesc;


}
