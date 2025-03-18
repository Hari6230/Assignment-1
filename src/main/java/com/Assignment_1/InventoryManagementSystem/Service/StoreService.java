package com.Assignment_1.InventoryManagementSystem.Service;

import com.Assignment_1.InventoryManagementSystem.Exceptions.AllExceptionHandler;
import com.Assignment_1.InventoryManagementSystem.InventoryDto.StoreDto;
import com.Assignment_1.InventoryManagementSystem.entity.Store;
import com.Assignment_1.InventoryManagementSystem.Repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    public String createStore(StoreDto storeDto) {
        try {
            Store store = new Store(storeDto.getId(), storeDto.getSId(), storeDto.getSName(), storeDto.getSAddress());
            Store save = storeRepository.save(store);
            return "The store is created Successfully";
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while creating store: " + e.getMessage());
        }
    }

    public List<StoreDto> getAllStores() {
        try {
            return storeRepository.findAll().stream()
                    .map(x -> new StoreDto(x.getId(), x.getSId(), x.getSName(), x.getSAddress()))
                    .toList();
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching all stores: " + e.getMessage());
        }
    }

    public Store getStoreById(String id) {
        try {
            return storeRepository.findById(id)
                    .orElseThrow(() -> new NoSuchElementException("There is no store with id " + id + " present"));
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while fetching store by id: " + e.getMessage());
        }
    }

    public Store updateStore(Store store) {
        try {
            return storeRepository.save(store);
        } catch (Exception e) {
            throw new AllExceptionHandler("There is an error while Updating the store");
        }
    }

    public void deleteStore(String id) {
        try {
            storeRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error occurred while deleting store: " + e.getMessage());
        }
    }
}
