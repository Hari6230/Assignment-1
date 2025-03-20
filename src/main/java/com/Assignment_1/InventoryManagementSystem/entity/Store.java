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
public class Store extends TimeStampEntity {
    @Id
    @JsonProperty("id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "store_id",nullable = false,unique = true)

    @JsonProperty("sId")
    private String  sId;

    @Column(name = "store_name", nullable = false, unique = true, length = 255)
    @JsonProperty("sName")
    private String sName;

    @Column(name = "store_address", nullable = false)
    @JsonProperty("sAddress")
    private String sAddress;


}