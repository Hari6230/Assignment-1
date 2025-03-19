package com.Assignment_1.InventoryManagementSystem.Controller;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.InventoryDto;
import com.Assignment_1.InventoryManagementSystem.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/createInventory")
    public ResponseEntity<String> createInventory(@RequestBody InventoryDto inventoryDto) {
        return inventoryService.createInventory(inventoryDto);
    }

    @GetMapping("/getAllInventories")
    public List<InventoryDto> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    @GetMapping("getInventoryById/{id}")
    public ResponseEntity<InventoryDto> getInventoryById(@PathVariable String id) {
        return inventoryService.getInventoryById(id);
    }

    @PutMapping("updateInventoryById/{id}")
    public ResponseEntity<String> updateInventory(@PathVariable String id, @RequestBody InventoryDto inventoryDto) {
        return inventoryService.updateInventory(id,inventoryDto);
    }

    @DeleteMapping("deleteInventoryById/{id}")
    public ResponseEntity<String> deleteInventory(@PathVariable String id) {
        inventoryService.deleteInventory(id);
        return ResponseEntity.ok("The Inventory is deleted");
    }

}