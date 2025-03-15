package com.Assignment_1.InventoryManagementSystem.Service;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.InventoryDto;
import com.Assignment_1.InventoryManagementSystem.Model.Inventory;
import com.Assignment_1.InventoryManagementSystem.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;


    public InventoryDto createInventory(InventoryDto inventoryDto) {
        Inventory inventory = new Inventory(inventoryDto.getStore(), inventoryDto.getProduct(), inventoryDto.getAvailability());
        Inventory save = inventoryRepository.save(inventory);
        return new InventoryDto(save.getId(), save.getStore(), save.getProduct(), save.getAvailableInventory());

    }

    public List<InventoryDto> getAllInventories() {
        return inventoryRepository.findAll().stream().map(i -> new InventoryDto(i.getId(), i.getStore(), i.getProduct(), i.getAvailableInventory())).collect(Collectors.toList());
    }

    public InventoryDto getInventoryById(Long id) {
        Inventory inventory = inventoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("There is no Inventory with ID " + id));
        return new InventoryDto(inventory.getId(), inventory.getStore(), inventory.getProduct(), inventory.getAvailableInventory());
    }

    public InventoryDto updateInventory(Long id, InventoryDto inventoryDto) {

        Inventory existinventory = inventoryRepository.findById(id).orElseThrow(() -> new NoSuchElementException("There is no Inventory with ID " + id));
        existinventory.setId(inventoryDto.getId());
        existinventory.setStore(inventoryDto.getStore());
        existinventory.setProduct(inventoryDto.getProduct());
        existinventory.setAvailableInventory(inventoryDto.getAvailability());
        Inventory updatedInventory = inventoryRepository.save(existinventory);

        return new InventoryDto(updatedInventory.getId(), updatedInventory.getStore(), updatedInventory.getProduct(), updatedInventory.getAvailableInventory());
    }

    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

}