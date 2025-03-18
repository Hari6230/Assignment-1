package com.Assignment_1.InventoryManagementSystem.Controller;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.StoreDto;
import com.Assignment_1.InventoryManagementSystem.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/create")
    public String createStore(@RequestBody StoreDto storeDto) {
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