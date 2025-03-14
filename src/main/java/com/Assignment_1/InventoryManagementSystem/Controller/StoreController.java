package com.Assignment_1.InventoryManagementSystem.Controller;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.StoreDto;
import com.Assignment_1.InventoryManagementSystem.Model.Store;
import com.Assignment_1.InventoryManagementSystem.Repository.InventoryRepository;
import com.Assignment_1.InventoryManagementSystem.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;
    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping
    public Store createStore(@RequestBody Store store) {
        return storeService.createStore(store);
    }

    @GetMapping
    public List<StoreDto> getAllStores() {
        return storeService.getAllStores();
    }


    @DeleteMapping("/{id}")
    public void deleteStore(@PathVariable int id) {
        storeService.deleteStore(id);
    }
}