package com.Assignment_1.InventoryManagementSystem.InventoryDto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
public class StoreDto {
    @JsonProperty("id")
    private int id;
    @JsonProperty("sId")
    private String sId;
    @JsonProperty("sName")
    private String sName;
    @JsonProperty("sAddress")
    private String sAddress;
}
