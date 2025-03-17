package com.Assignment_1.InventoryManagementSystem.Controller;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.InventoryDto;
import com.Assignment_1.InventoryManagementSystem.Service.InventoryService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/create")
    public InventoryDto createInventory(@RequestBody InventoryDto inventoryDto) {
        try {
            return inventoryService.createInventory(inventoryDto);
        } catch (BadRequestException e) {
            throw new RuntimeException(e);
        }
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