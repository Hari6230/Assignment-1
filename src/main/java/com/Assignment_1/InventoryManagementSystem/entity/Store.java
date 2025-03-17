package com.Assignment_1.InventoryManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store_details")
public class Store {
    @Id
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$",message = "Store ID should be  Alphanumeric")
    @Column(name = "sId",nullable = false,unique = true)
    @JsonProperty("sId")
    private String  sId;

    @Column(name = "store_name", nullable = false, unique = true, length = 255)
    @JsonProperty("sName")
    private String sName;

    @Column(name = "store_address", nullable = false)
    @JsonProperty("sAddress")
    @Pattern(regexp = ".*\\d{6}$",message = "Address should contains PIN CODE")
    private String sAddress;


}