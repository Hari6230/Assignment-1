package com.Assignment_1.InventoryManagementSystem.Controller;

import com.Assignment_1.InventoryManagementSystem.InventoryDto.StoreDto;
import com.Assignment_1.InventoryManagementSystem.Service.StoreService;
import com.Assignment_1.InventoryManagementSystem.entity.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/createStore")
    public String createStore(@RequestBody StoreDto storeDto) {
        return storeService.createStore(storeDto);
    }

    @GetMapping("/getAllStoreDetails")
    public List<StoreDto> getAllStores() {
        return storeService.getAllStores();
    }
    @GetMapping("getStoreById/{sId}")
    public void getStoreById(@PathVariable String sId){
        storeService.getStoreById(sId);
    }

    @PutMapping("/updateStoreById/{sid}")
    public String updateStoreById(@PathVariable String sid, @RequestBody StoreDto storeDto) {
        StoreDto existingStore = storeService.getStoreById(sid);
        existingStore.setSName(storeDto.getSName());
        existingStore.setSAddress(storeDto.getSAddress());
        Store s = new Store(existingStore.getId(),existingStore.getSId(),existingStore.getSName(),existingStore.getSAddress());
        return storeService.updateStore(s);


    }

    @DeleteMapping("deleteStoreById/{id}")
    public String deleteStore(@PathVariable String id) {
        return storeService.deleteStore(id);
    }
}