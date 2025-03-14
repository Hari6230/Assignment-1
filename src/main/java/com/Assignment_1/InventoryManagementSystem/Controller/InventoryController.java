package com.Assignment_1.InventoryManagementSystem.Controller;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.InventoryDto;
import com.Assignment_1.InventoryManagementSystem.Model.Inventory;
import com.Assignment_1.InventoryManagementSystem.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/create")
    public InventoryDto createInventory(@RequestBody InventoryDto inventoryDto) {
        return inventoryService.createInventory(inventoryDto);
    }

    @GetMapping("/getall")
    public List<InventoryDto> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    @GetMapping("get/{id}")
    public InventoryDto getInventoryById(@PathVariable Long id) {
        return inventoryService.getInventoryById(id);
    }

    @PutMapping("update/{id}")
    public InventoryDto updateInventory(@PathVariable Long id, @RequestBody InventoryDto inventoryDto) {
        return inventoryService.updateInventory(id,inventoryDto);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.ok("The Inventory is deleted");
    }

}