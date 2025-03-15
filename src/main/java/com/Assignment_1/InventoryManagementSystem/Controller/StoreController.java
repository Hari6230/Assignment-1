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

    @PostMapping("/create")
    public StoreDto createStore(@RequestBody StoreDto storeDto) {
        return storeService.createStore(storeDto);
    }

    @GetMapping("/getall")
    public List<StoreDto> getAllStores() {
        return storeService.getAllStores();
    }


    @DeleteMapping("get/{id}")
    public void deleteStore(@PathVariable String id) {
        storeService.deleteStore(id);
    }
}