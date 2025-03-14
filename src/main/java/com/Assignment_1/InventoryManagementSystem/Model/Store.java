package com.Assignment_1.InventoryManagementSystem.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "store_details")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    @JsonProperty("sId")
    private int sId;

    @Column(name = "store_name", nullable = false, unique = true, length = 255)
    @JsonProperty("sName")
    private String sName;

    @Column(name = "store_address", nullable = false)
    @JsonProperty("sAddress")
    private String sAddress;



}