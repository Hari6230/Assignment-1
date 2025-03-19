package com.Assignment_1.InventoryManagementSystem.Service;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.InventoryDto;
import com.Assignment_1.InventoryManagementSystem.entity.Inventory;
import com.Assignment_1.InventoryManagementSystem.Repository.InventoryRepository;
import com.Assignment_1.InventoryManagementSystem.utils.ValidationUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Slf4j
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;


    public ResponseEntity<String> createInventory(InventoryDto inventoryDto) {
        try {
            ValidationUtils.validateInventoryDto(inventoryDto);
            Inventory inventory = new Inventory(inventoryDto.getIId(),inventoryDto.getStore(), inventoryDto.getProduct(), inventoryDto.getAvailability());
            if (ObjectUtils.isEmpty(inventory)) {
                inventoryRepository.save(inventory);
                return ResponseEntity.status(HttpStatus.OK).body("The Inventory is created");
            } else {
                log.error("Duplicate Inventory, Inventory already exist with id:{}", inventoryDto.getId());
                throw new BadRequestException("Duplicate order, order already exist with id" + inventoryDto.getId());
            }
        } catch (BadRequestException e) {
            log.error("Error occurred in InventoryService :{}", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());

        }


    }

    public List<InventoryDto> getAllInventories() {
        return inventoryRepository.findAll().stream().map(i -> new InventoryDto(i.getId(), i.getInventoryId(), i.getStore(), i.getProduct(), i.getAvailableInventory())).collect(Collectors.toList());
    }

    public ResponseEntity<InventoryDto>getInventoryById(String id) {
        Inventory inventory = inventoryRepository.findByInventoryId(id);
        if(!ObjectUtils.isEmpty(inventory)){
            InventoryDto inventoryDto = new InventoryDto(inventory.getId(), inventory.getInventoryId(), inventory.getStore(), inventory.getProduct(), inventory.getAvailableInventory());
            return ResponseEntity.status(HttpStatus.OK).body(inventoryDto);
        }else{
            log.error("Inventory is not present with Inventory_id{}",id);
            throw new NoSuchElementException("The Inventory is not present with id "+id);
        }

    }

    public ResponseEntity<String> updateInventory(String id, InventoryDto inventoryDto) {
        Inventory existinventory = inventoryRepository.findByInventoryId(id);
       if(!ObjectUtils.isEmpty(existinventory)){
           existinventory.setStore(inventoryDto.getStore());
           existinventory.setProduct(inventoryDto.getProduct());
           existinventory.setAvailableInventory(inventoryDto.getAvailability());
           inventoryRepository.save(existinventory);
           return ResponseEntity.status(HttpStatus.OK).body("The Inventory table is Updated");
       }else{
           log.error("The Inventory is not present with Inventory_id:{}",id);
           throw new NoSuchElementException("There is no Inventory present with id "+id);
       }
    }

    public void deleteInventory(String id) {

        inventoryRepository.deleteByInventoryId(id);
    }

}